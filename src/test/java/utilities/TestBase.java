package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static final String wait = null;
	public WebDriver driver;
	public String browser;
	public Properties prop;
	public String emailId;
	public String passwordDet;
	
	public WebDriver webDriverManager() throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		emailId = prop.getProperty("emailAddress");
		passwordDet = prop.getProperty("password");
		//DesiredCapabilities caps = new DesiredCapabilities();
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Safari"))
			{
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			
			//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.get(prop.getProperty("TestURL"));
			
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.setExperimentalOption("excludeSwitches",Arrays.asList(
			 * "disable-popup-blocking")); caps.setCapability(ChromeOptions.CAPABILITY,
			 * options);
			 */
			Thread.sleep(5000);	
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}

}
