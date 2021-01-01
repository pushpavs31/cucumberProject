package cucumber.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	
	
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}

}
