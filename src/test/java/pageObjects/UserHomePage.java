package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	WebDriver driver;
	String packageName;
	
	public UserHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'Damini Singh')]")
	WebElement userName;
	
	@FindBy(css = "input[type='search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit' and @data-test='search_button']")
	WebElement searchButton;
	
	public WebElement getUserName()
	{
		return userName;
	}
	
	public WebElement getSearchBox()
	{
		return searchBox;
	}
	
	public WebElement getSearchButton()
	{
		return searchButton ;
	}
}
