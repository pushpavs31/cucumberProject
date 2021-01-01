package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features={"D://testing materials//eclipse//workspace-eclipse2//CucumberDemo//src//test//java//Features//Login-Authentication.feature"},
	glue={"testDefinations"},
	dryRun=false,
	plugin= {"pretty",
			"html:target/cucumber-report.html",
			"junit:target/cucumber-report.xml"
			},
	publish = true	
		)

public class LoginTest {

}
