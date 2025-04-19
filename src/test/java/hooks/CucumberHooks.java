package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import jira.services.Issues;

public class CucumberHooks {
	
	@Before
	public void runningBeforeScenario() {
		System.out.println("Running Before Each Scenario");
	}
	
	@After
	public void runningAfterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			new Issues().createBug("FAILED - "+scenario.getName());
		}
	}
	
	@BeforeStep
	public void runningBeforeStep() {
		System.out.println("Running Before Each Scenario step");
	}
	
	@AfterStep
	public void runningAfterStep() {
		System.out.println("Running After Each Scenario step");
	}

}