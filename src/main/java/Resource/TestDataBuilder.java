package Resource;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuilder {

	public AddPlace payload(String name, String language, String address)
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(333);
		p.setAddress(address);
		p.setLanguage(language);
		List<String> myList = new ArrayList<String>();
		myList.add("kumar");
		myList.add("Gaurav");
		p.setTypes(myList);
		p.setName(name);
		p.setPhone_number("8777777765");
		p.setWebsite("test.com");
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		return p;
	}
	
	public String deletePlacePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"   \r\n}";
	}
}
