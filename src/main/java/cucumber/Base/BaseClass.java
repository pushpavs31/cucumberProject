package cucumber.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.Listeners.WebEventListner;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public int max_page_load_time = 120;
	public int max_implicit_time = 120;
//	public static EventFiringWebDriver e_driver;
//	public static WebEventListner webListener;
	public static Logger log;
	public static String browsername;
	public Properties prop;
	
	public static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();

	public void prop_Initialize() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(".//Configuration//globalprop.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void browser_Initialize() {
		 browsername = prop.getProperty("browser1");

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			threadDriver.set(driver);
		}

		else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			threadDriver.set(driver);
		}

		else if (browsername.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			threadDriver.set(driver);
		}

		threadDriver.get().manage().window().maximize();
		threadDriver.get().manage().deleteAllCookies();
		threadDriver.get().manage().timeouts().pageLoadTimeout(max_page_load_time, TimeUnit.SECONDS);
		threadDriver.get().manage().timeouts().implicitlyWait(max_implicit_time, TimeUnit.SECONDS);

		log = LogManager.getLogger(BaseClass.class.getName());
//		log.debug(browsername + " Browser has started Successfully");

	}

	public void closure() {
		threadDriver.get().close();
	}

	public void quit() {
		threadDriver.get().quit();
	}

}
