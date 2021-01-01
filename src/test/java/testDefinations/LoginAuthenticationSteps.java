package testDefinations;

import cucumber.Base.BaseClass;
import cucumber.ObjectRepository.HomePage;
import cucumber.ObjectRepository.MyAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class LoginAuthenticationSteps extends BaseClass {
	
	MyAccountPage myAccount;

	@Before
	public void prop_init() {
		prop_Initialize();
	}
	
	@After
	public void closeBrowser()
	{
		quit();
		log.debug("********************* " + browsername + " Web Browser has closed*****************");
	}

	@Given("Open_the browser")
	public void open_the_browser() {
		browser_Initialize();
		log.debug("********************* " + browsername + " Web Browser has opened*****************");
	}

	@When("Enter the website URL")
	public void enter_the_website_url() {
		threadDriver.get().navigate().to(prop.getProperty("url"));
		log.debug("Webpage has opened");
	}

	@And(" Click on My Account Menu")
	public void click_on_my_account_menu() {
		HomePage homepage = new HomePage(threadDriver.get());
		homepage.clickOnMyAccountLink();
		log.info("clicked on My acoount link");

	}

	@And("Enter the case changed username in username textbox")
	public void enter_the_case_changed_username_in_username_textbox() {
		myAccount = new MyAccountPage(threadDriver.get());
		myAccount.enterUserName(prop.getProperty("UserName"));
		log.info("entered username");

	}

	@And("Enter the case chenged password in the password tetxbox")
	public void enter_the_case_chenged_password_in_the_password_tetxbox() {
		myAccount.enterPassword(prop.getProperty("Password"));
		log.info("entered password");
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		myAccount.clickOnLoginButton();
		log.info("clicked on login button");

	}

	@Then("your are logged in, sign out of the site")
	public void your_are_logged_in_sign_out_of_the_site() {
		 myAccount.clickOnSignOutButton();
		log.info("clicked on sign out button");
		
	}

	@When("press back button")
	public void press_back_button() {
		threadDriver.get().navigate().back();
		log.info("Press backed button");

	}

	@Then("User shouldn’t be signed in to his account rather a general webpage must be visible")
	public void user_shouldnt_be_signed_in_to_his_account_rather_a_general_webpage_must_be_visible() {
		boolean forgetPasswordlink = myAccount.verifyAfterLogoutLostPassword();
		Assert.assertEquals(true, forgetPasswordlink);
		log.info("User is normal account page after signout");

	}
}
