package Resource;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.sun.xml.bind.v2.runtime.property.Property;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException 
	{
		
		if(req==null)	
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.text"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
			    .addQueryParam("key", "qaclick123").build();
		return req;
		}
		return req;
	  
	}
	public static String getGlobalValue(String key) throws IOException
	{
		String path = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("Global.properties");
		//path+"/Global.properties"
		prop.load(fis);
		prop.getProperty(key);
		return prop.getProperty(key);
	}
	public String getJasonPath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.getString(key);
	}

}
