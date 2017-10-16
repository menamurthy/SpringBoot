package application;
/**
 * This class has the address information for postcode
 * */
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressInfo implements AddressInfoInterface{
	@JsonProperty("postcode")
	String postcode;
	@JsonProperty("line_1")
	String line1;
	@JsonProperty("line_2")
	String line2;
	@JsonProperty("line_3")
	String line3;
	@JsonProperty("country")
	String country;
	
	/**
	 * The address is returned.
	 * **/
	@Override
	public String getAddress(){
		System.out.println( "\n The address found for the postcode "
				+postcode+" is -\n"+line1+"\n"+line2+"\n"
				+line3+"\n"+country+"\n");
		return "\n The address found for the postcode "
				+postcode+" is -\n"+line1+"\n"+line2+"\n"
				+line3+"\n"+country+"\n";
	}

	@Override
	public String toString(){
		return postcode;
	}

}
