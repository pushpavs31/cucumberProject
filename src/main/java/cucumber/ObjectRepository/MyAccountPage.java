package cucumber.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Utility.Utilities;

public class MyAccountPage {
	
WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@CacheLookup
	@FindBy(id="username")
	WebElement loginUserNameField;
	
	@CacheLookup
	@FindBy(id="password")
	WebElement loginPasswordField;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	WebElement signout;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Lost your password?')]")
	WebElement forgetPasswordLink;
	
	
	public void enterUserName(String Uname)
	{
		loginUserNameField.sendKeys(Uname);
	}
	
	public void enterPassword(String pass)
	{
		loginPasswordField.sendKeys(pass);
	}
	
	public void clickOnLoginButton() throws InterruptedException
	{
		Thread.sleep(2000);
		loginButton.click();
	}
	

	public void clickOnSignOutButton() {
		Utilities.waitForElement(signout, 10, driver);
		signout.click();
		
	}
	
	public boolean verifyAfterLogoutLostPassword()
	{
		return forgetPasswordLink.isDisplayed();
	}

}
