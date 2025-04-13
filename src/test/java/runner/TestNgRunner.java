package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"src/test/java/features/IncidentGetMethodQueryParam.feature"},
		         glue = {"step.defs"},
		         dryRun = false
		        )
public class TestNgRunner extends AbstractTestNGCucumberTests {

}