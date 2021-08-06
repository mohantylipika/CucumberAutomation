package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(    features = {"src/test/resources/features"}, 
                     glue = { "stepDefinitions" },
                     monochrome=true,
                     plugin= {"pretty", "html:target/htmlreport.html", 
                    		            "json:target/jsonreport.json",
                    		            "junit:target/junitreport.xml"},
		tags = "@1st"
                     
)

public class TestRunner {

}
