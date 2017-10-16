package application;
/**
 * This application mainly focuses on the retrieval of 
 * the address information for a give post code. The API
 * api.ideal-postcodes.co.uk is used to get the information 
 * of the details of the postcode.
 * **/

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	@Autowired
	private static RestTemplate restTemplate;

	private static final Logger log = Logger.getLogger(Application.class);
	static String param;
	public static String localURL = "https://api.ideal-postcodes.co.uk/v1/postcodes/"+param+"?api_key=iddqd";
	public static void main(String args[]) {
//		param = args[0];
		param = "W60LG";//W6   0LG //SW1A   2AA//BT48   6DQ
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	/**
	 * In this method the json is fetched from the API and 
	 * JSonBean is populated with the information. The application is started.
	 * @param RestTemplate
	 * **/
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			JsonBean resultBean = restTemplate.getForObject(localURL.toString()	, JsonBean.class);
			String address = resultBean.getAddress(param);
			System.out.println("Address is :"+address);
		};
	}
	
	static String getAddressDetail(String localURL, RestTemplate restTemplate){
		JsonBean resultBean = restTemplate.getForObject(localURL.toString()	, JsonBean.class);
		String address = resultBean.getAddress(param);
		System.out.println(address);
		return address;
	}
}
