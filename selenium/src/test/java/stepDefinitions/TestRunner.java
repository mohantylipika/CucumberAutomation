package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(    features = {"src/test/resources/features"}, 
                     glue = { "stepDefinitions" },
                     monochrome=true,
                     plugin= {"pretty", "json:target/jsonreport.json"}
                    		           
	
                     
)

public class TestRunner {

}
