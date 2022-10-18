package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public UserHomePage userHomePage;
	public SearchResultsPage searchResultsPage;
	public NewTabData newTabData;
	//public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		getLandingPage();
		getLoginPage();
		getUserHomePage();
		getSearchResultsPage();
		getNewTabDataPage();
		
	}
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
		
	}
	
	public LoginPage getLoginPage()
	{
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public UserHomePage getUserHomePage() {
		userHomePage = new UserHomePage(driver);
		return userHomePage;
	}
	
	public SearchResultsPage getSearchResultsPage()
	{
		searchResultsPage = new SearchResultsPage(driver);
		return searchResultsPage;
	}
	
	public NewTabData getNewTabDataPage()
	{
		newTabData = new NewTabData(driver);
		return newTabData;
	}

}
