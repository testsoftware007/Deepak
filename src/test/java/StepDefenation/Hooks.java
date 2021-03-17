package StepDefenation;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		StepDefenation del = new StepDefenation();
		if(StepDefenation.place_id==null)
		{
		del.add_Place_Payload_with("Deepak", "English", "Khurja");
		del.user_calls_with_http_method("PostPlaceAPI", "post");
		del.verify_place_id_created_maps_to_using("Deepak", "GetPlaceAPI");
		}
	}

}
