package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"@reports/failed-scenarios.txt"},
		         glue = {"step.defs"}
		        )
public class RetryTestNGRunner extends AbstractTestNGCucumberTests {
	
	

}