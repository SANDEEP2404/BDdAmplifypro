package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\\test\\java\\Features"
    ,glue={"StepDefinition"},
    monochrome =true,

    plugin = {"pretty","junit:target/JUnitReports/report.xml",
    		"json:target/JSONReports/repot.json",
    	      "html:target/HtmlReports"}
    		) 
public class TestRunner{
	
}
