package cucumber.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, 
         snippets = SnippetType.CAMELCASE, 
         features = {"src/test/resources/Features/LoginPage.feature" }, 
         glue = {"cucumber.stepDefinitions" }, 
         monochrome = true, 
         dryRun = false
         // feature file tag name @smoke
         // tags = { "@smoke" }
)
public class LoginRunner {
	
	@AfterClass
	public static void createReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/extentConfig.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}

	
	// plugin= {"pretty","html:test-output"}
	// format = {"pretty","html:test-outout","json:json_output/
	// monochrome = false, make the console output readable format.
	//dryRun = true -->help with find out which step definitions i missed.
	// dryRun = false -->when wanted to execdute the test.

}
