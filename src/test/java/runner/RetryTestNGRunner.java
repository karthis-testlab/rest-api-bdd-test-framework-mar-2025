package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"@failed-scenarios.txt"},
		         glue = {"step.defs"}
		        )
public class RetryTestNGRunner extends AbstractTestNGCucumberTests {
	
	

}