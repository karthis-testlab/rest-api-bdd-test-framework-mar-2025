package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"src/test/java/features/IncidentPostMethod.feature:22"},
		         glue = {"steps.def.som", "hooks"},
		         dryRun = false,
		         plugin = {
		        		 "pretty",
		        		 "html:reports/cucumber-report.html",
		        		 "rerun:reports/failed-scenarios.txt"
		         },
		         publish = true
		        )
public class TestNgRunner extends AbstractTestNGCucumberTests {	

}