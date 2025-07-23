package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src/test/resources/Features"},
glue= {"stepDefination"},
plugin= {"pretty","html:sr/test/htmlreport.html "}
		)
public class CucumerTestRunner extends AbstractTestNGCucumberTests{

}
