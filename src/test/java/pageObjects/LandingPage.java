package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	String packageName;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[normalize-space()='Choose Your Plan']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//span[@class='jss2']//span[contains(text(),'Log in')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[@class='jss2']//span[contains(text(),'Sign Up')]")
	WebElement signupButton;
	
	@FindBy(xpath = "(//span[contains(text(),'about')])[1]")
	WebElement aboutLink;
	
	@FindBy(xpath = "//span[normalize-space()='Your Online Library']")
	WebElement yourOnlineLibrary;
	
	@FindBy(xpath = "//a[contains(@class,'link active')]/img[@src='/images/ae/zendy_app_logo.svg']")
	WebElement zendyLogo;
///////////////////////////////////
	@FindBy(xpath = "//span[@class='hide-mobile']")
	WebElement languageButtonText;
	
	@FindBy(css = ".countryList-items>li[id = \"bh\"]")
	WebElement countryBahrain;
	
	@FindBy(css = ".countryList-items>li[id = \"sa\"]")
	WebElement countrySaudiArabia;
	
	@FindBy(css = ".countryList-items>li[id = \"kw\"]")
	WebElement countryKuwait;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[1]")
	WebElement packageLite;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[2]")
	WebElement packageClassic;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[3]")
	WebElement packagePremium;
	
	@FindBy(css = "div[class='packages packages Light'] span[class='currency']")
	WebElement PackageCurrencyLite;
	
	@FindBy(css = "div[class='packages packages Classic'] span[class='currency']")
	WebElement PackageCurrencyClassic;
	
	@FindBy(css = "div[class='packages packages Premium'] span[class='currency']")
	WebElement PackageCurrencyPremium;
	
	public String getTitle()
	{
		return driver.getTitle();
		//return pageTitle.getText();
	}
	
	public WebElement getLoginButtonElement()
	{
		return loginButton;
	}
	public WebElement getSignupButtonElement()
	{
		return signupButton;
	}
	public WebElement getAboutLinkElement()
	{
		return aboutLink;
	}

	/*
	 * public List<WebElement> getPackageListElement() { return packageList; }
	 */
	public WebElement getyourOnlineLibraryElement()
	{
		return yourOnlineLibrary;
	}
	public WebElement getZendyLogo()
	{
		return zendyLogo;
	}
	public String getLanguageButtonText() 
	{
		return languageButtonText.getText();
	}
	public String getPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	
	public WebElement clickOnSelectedCountry(String Country)
	{
		if(Country.equals("KSA"))
		{
			return countrySaudiArabia;
		}
		else if(Country.equals("Kuwait"))
		{
			return countryKuwait;
		}
		else if(Country.equals("Bahrain"))
		{
			return countryBahrain;
		}
		
		return null;
		
	}
	
	public List<WebElement> getPackageCurrency()
	{
		 List<WebElement> packType = new ArrayList<>();
		  
		  packType.add(PackageCurrencyLite);
		  packType.add(PackageCurrencyClassic);  
		  packType.add(PackageCurrencyPremium);
		  
		  return packType;
	}
	
	public WebElement getPackageLite()
	{
		return packageLite;
	}
	public WebElement getpackageClassic()
	{
		return packageClassic;
	}
	public WebElement getpackagePremiumL()
	{
		return packagePremium;
	}
	
	

}
