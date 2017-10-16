package application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
/**
 * his class tests the application and checks whether the 
 * required  results are returned.
 * **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @MockBean
    private Application applicaton;

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();
    
    MockRestServiceServer mockServer;
    
    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
    
    @Test
    public void testApplication() {
    	String localURL="https://api.ideal-postcodes.co.uk/v1/postcodes/HA27HG?api_key=iddqd";
        mockServer.expect(requestTo(localURL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(AddressJSON.JSON, MediaType.TEXT_PLAIN));

        String result = Application.getAddressDetail(localURL, restTemplate);

        assertThat(result).contains("HA27HG");
    }

}