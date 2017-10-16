package application;

import java.util.List;
import java.util.Optional;

/**
 * This mainly focuses on the holding the json information. 
 * Address is constructed from the list element based on the 
 * provided postcode.
 **/

public class JsonBean {
	List<AddressInfo> result;
	public List<AddressInfo> getResult() {
		return result;
	}

	public void setResult(List<AddressInfo> result) {
		this.result = result;
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(result.size()).append("+");
		for(int i=0; i<result.size(); ++i){
			sb.append(result.get(i).toString());
		}
		return sb.toString();
		
	}
	/**This method returns the address for a given postcode
	 * @param postcode
	 * **/
	public String getAddress(String postcode){
		Optional<AddressInfo> matchingObjects = result.stream().
			    filter(p -> p.postcode.replaceAll("\\s+","").equals(postcode)).
			    findFirst();
		if(matchingObjects.isPresent()){
			return matchingObjects.get().getAddress();
		}
		return null;
		
	}
	
}
