package cucumber.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefi {
	final static Logger logger = Logger.getLogger(LoginStepDefi.class);
	public WebDriver driver;

	@Given("^I open a chrome brawser$")
	public void iOpenAChromeBrawser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    throw new PendingException();
	}

	@When("^I navigate to orangeHMR website$")
	public void iNavigateToOrangeHMRWebsite() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/leave/assignLeave");
		logger.info("Navigating to orangeHRM. ");
	    throw new PendingException();
	}

	@Then("^I see OrangeHMR landing page$")
	public void iSeeOrangeHMRLandingPage() throws Throwable {
		String websiteTitile = driver.getTitle();
		logger.info("Website title is: " + websiteTitile);
		assertEquals(websiteTitile, "OrangeHRM");
		throw new PendingException();
	}

	@When("^I enter username$")
	public void iEnterUsername() throws Throwable {
		driver.findElement(By.xpath("input[id='txtUsername']")).sendKeys("Admin");
		logger.info("entered user name. ");
	    throw new PendingException();
	}

	@When("^I enter password$")
	public void iEnterPassword() throws Throwable {
		driver.findElement(By.xpath("input[name='txtPassword']")).sendKeys("admin123");
		logger.info("entered password. ");
	    throw new PendingException();
	}

	@When("^I click on login button$")
	public void iClickOnLoginButton() throws Throwable {
		driver.findElement(By.cssSelector("#btnLogin")).click();
		logger.info("clicked on login. ");
	    throw new PendingException();
	}

	@Then("^I see orangeHRM main page$")
	public void iSeeOrangeHRMMainPage() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement authentication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
		assertNotNull("page Synchronisation to sign in Page failed", authentication);
		logger.info("page Synchronisation --> to main Page");
		logger.info("pausing test for 3 sec. ");
		
		driver.close();
		driver.quit();
	    throw new PendingException();
	}
}
