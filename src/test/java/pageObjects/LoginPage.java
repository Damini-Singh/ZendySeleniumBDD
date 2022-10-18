package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class LoginPage extends TestBase{

	WebDriver driver;
	String packageName;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#email")
	WebElement emailAddress;
	
	@FindBy(css = "#password")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Forgot your password?')]")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button[@id='sign_in_btn']")
	WebElement signInButton;
	
	
	public WebElement getEmailAddressElement()
	{
		return emailAddress;
	}
	
	public WebElement getPasswordElement()
	{
		return password;
	}
	
	public WebElement getForgotPasswordElement()
	{
		return forgotPassword;
	}
	
	public WebElement getSignInButtonElement()
	{
		return signInButton;
	}
	
	
	
	//Set Email and password
	public String setEmailID()
	{
		return emailId;
	}
	public String setPassword() 
	{
		return passwordDet;
	}
}
