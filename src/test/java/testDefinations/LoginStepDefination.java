package testDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.Base.BaseClass;
import cucumber.Listeners.WebEventListner;
import cucumber.ObjectRepository.HomePage;
import cucumber.ObjectRepository.MyAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginStepDefination extends BaseClass {

	MyAccountPage myAccount;
	MyAccountPage myAccount1;
	
	
	@Before
	public void prop_Launch()
	{
		prop_Initialize();
	}

	@Given("Open the browser")
	public void open_the_browser() {
		browser_Initialize();
		log.debug(browsername + " Browser has started Successfully");
		log.debug("*********************Web Browser has opened*****************");
	}

	@When("^Enter the URL \"([^\"]*)\"$")
	public void enter_the_url_something(String url) {
		driver.get(url);
		log.debug("Website has opened");
	}

	@And("Click on My Account Menu")
	public void click_on_my_account_menu() {
		HomePage homepage = new HomePage(threadDriver.get());
		homepage.clickOnMyAccountLink();
		log.info("clicked on My acoount link");

	}

	@And("Enter registered username in username textbox")
	public void enter_registered_username_in_username_textbox() {
		myAccount = new MyAccountPage(threadDriver.get());
		myAccount.enterUserName("siddhantvs311992@gmail.com");
		log.info("entered username");
	}

	@And("Enter password in password textbox")
	public void enter_password_in_password_textbox() {
		myAccount.enterPassword("31Pushpavinod@");
		log.info("entered password");
	}

	@When("Click on login button")
	public void click_on_login_button() throws InterruptedException {
		myAccount.clickOnLoginButton();
		log.info("clicked on login button");
	}

	@Then("User must successfully login to the web page")
	public void user_must_successfully_login_to_the_web_page() {

		if (driver.getPageSource().contains("Hello")) {
			Assert.assertTrue(true);
			log.info("LogIn successfully");
		} else {
			Assert.assertTrue(false);
			log.info("Login unsuccessful");
		}

	}

	@When("^Enter incorrect \"(.*)\" in username textbox$")
	public void enter_incorrect_username_in_username_textbox(String user) {
		myAccount = new MyAccountPage(threadDriver.get());
		myAccount.enterUserName(user);
		log.info("enterd uncorrrect username");
	}

	@When("^Enter incorrect \"(.*)\" in password textbox.$")
	public void enter_incorrect_password_in_password_textbox(String pass) {
		myAccount.enterPassword(pass);
		log.info("enterd uncorrrect password");

	}

	
	@Then("Proper error must be display {string} and prompt to enter login again")
	public void proper_error_must_be_display_and_prompt_to_enter_login_again(String msg) {
		if (threadDriver.get().getPageSource().contains(msg)) {
			Assert.assertTrue("Login unsuccessful", true);
			System.out.println("login unsuccessful");
			log.info("Login unsuccessful");
		} else {
			System.out.println("login successfully");
			Assert.assertTrue("Login successful", false);
			log.info("Login successful");
		}

	}

	@After
	public void tearDown() {
		closure();
	}

}
