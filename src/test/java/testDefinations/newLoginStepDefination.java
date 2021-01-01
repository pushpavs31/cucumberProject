package testDefinations;

import cucumber.Base.BaseClass;
import cucumber.ObjectRepository.HomePage;
import cucumber.ObjectRepository.MyAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class newLoginStepDefination extends BaseClass {
	
	MyAccountPage myAccount;

	@Before
	public void propLoad()
	{
		prop_Initialize();
	}
	
	@After
	public void teardown()
	{
		quit();
	}
	
	@Given("Open the Browser")
	public void open_the_browser() {
		browser_Initialize();
		log.debug("********************* "+browsername+" Web Browser has opened*****************");
	}
	  
	@When("User Enter the Website URL")
	public void enter_the_website_url_http_practice_automationtesting_in() {
		
		 threadDriver.get().navigate().to(prop.getProperty("url"));
		   log.debug("Website has opened");
	}
	
	@When("Click on the My Account Menu")
	public void click_on_the_my_account_menu() {
		HomePage homepage = new HomePage(threadDriver.get());
		homepage.clickOnMyAccountLink();
		log.info("clicked on My acoount link");
	  
	}
	@When("Enter {string} in username textbox")
	public void enter_in_username_textbox(String uname) {
		myAccount = new MyAccountPage(threadDriver.get());
		myAccount.enterUserName(uname);
		log.info("entered username");
	   
	}
	@When("Now enter {string} in the password textbox")
	public void now_enter_in_the_password_textbox(String pass) {
		myAccount.enterPassword(pass);
		log.info("entered password");
	}
	@When("Click on login button.")
	public void click_on_login_button() throws InterruptedException {
		myAccount.clickOnLoginButton();
		log.info("clicked on login button");
	   
	}
	@Then("Proper message must be displayed {string} or {string} and prompt to enter login again")
	public void proper_message_must_be_displayed_or_and_prompt_to_enter_login_again(String msg1, String msg2) {
		if(threadDriver.get().getPageSource().contains(msg1))
		{
			System.err.println("login unsucessfull");
			log.info("login unsuccessfull");
			Assert.assertFalse(false);
		}
		else {
			System.err.println("login sucessfull");
			log.info("login successfull");
			Assert.assertTrue(true);
		}
	}

}
