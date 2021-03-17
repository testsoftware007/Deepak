package cucumber.Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue = "StepDefenation",
		plugin="json:target/jsonReports/cucumber-report.json",
		junit = "--step-notifications",
		tags="@DeletePlace"
		
		
		//strict=true
		)
        

public class TestRunner {
	
}