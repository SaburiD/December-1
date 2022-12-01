package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		//features = ".//Features/Customer.feature",
		//features = ".//Features/",
		features = {".//Features/Customer.feature",".//Features/LoginFeature.feature"},
		glue="StepDefination",
		//tags = "@Regression",
		tags = "@Sanity and @Regression",
		//tags = "@Sanity and not @Regression",
					
		dryRun = false,
		monochrome=true,
		plugin = {"pretty","html:target/cucumber-report/custreports_html1.html","json:target/cucumber-report/custreports_json1.json","junit:target/cucumber-report/custreports_junit1.xml"}
		
		)



public class Run {

}
