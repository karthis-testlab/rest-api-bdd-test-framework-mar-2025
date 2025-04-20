package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import jira.services.Issues;
import steps.def.som.base.TestContext;

import static utils.FileHandlers.*;

public class CucumberHooks {
	
	private TestContext context;
	
	public CucumberHooks(TestContext context) {
		this.context = context;
	}
	
	@Before
	public void runningBeforeScenario() {
		System.out.println("Running Before Each Scenario");
	}
	
	@After
	public void runningAfterScenario(Scenario scenario) {		
		if (scenario.isFailed()) {
			
			scenario.log("Create Bug in the SB Borad. The issue reference link: https://karthikeselene.atlassian.net/browse/"+
					new Issues().createBug("FAILED - "+scenario.getName())
					.jsonPath().getString("key"));	
			
			System.out.println(context.getContext("response"));
			
			createNewTxtFile(scenario.getId()+"-response", context.getContext("response"));
			createNewTxtFile(scenario.getId()+"-error", context.getContext("error"));
			appendTxtFile(scenario.getId()+"-error", context.getContext("trace"));			
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