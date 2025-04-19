package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"src/test/java/features/IncidentPostMethod.feature:22"},
		         glue = {"step.defs", "hooks"},
		         dryRun = false,
		         plugin = {
		        		 "rerun:failed-scenarios.txt"
		         },
		         tags = "@parallel"
		        )
public class ParallelTestNgRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {		
		return super.scenarios();
	}

}