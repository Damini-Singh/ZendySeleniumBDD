package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TextContextSetup;


public class SearchAndDownloadEbookStepDefinition {
	

	public WebDriver driver;
	String pageTitle;
	TextContextSetup textContextSetup;
	public WebElement loginButton;
	public WebElement signupButton;
	public WebElement aboutLink;
	public WebElement yourOnlineLibrary;
	public WebElement zendyLogo;
	public WebElement emailAddress;
	public WebElement password;
	public WebElement forgotPassword;
	public WebElement logInButton;
	String emailId;
	String passwordDetail;
	WebDriverWait wait;
	JavascriptExecutor js;
	String searchText;
	String searchReadText;
	String parentWindow;
	String childWindow;
	
	
	public SearchAndDownloadEbookStepDefinition(TextContextSetup textContextSetup) 
	{
		this.textContextSetup = textContextSetup;
		this.driver = textContextSetup.driver;
		this.loginButton = textContextSetup.pageObjectManager.landingPage.getLoginButtonElement();
		this.signupButton = textContextSetup.pageObjectManager.landingPage.getSignupButtonElement();
		this.aboutLink = textContextSetup.pageObjectManager.landingPage.getAboutLinkElement();
		this.yourOnlineLibrary = textContextSetup.pageObjectManager.landingPage.getyourOnlineLibraryElement();
		this.zendyLogo = textContextSetup.pageObjectManager.landingPage.getZendyLogo();	
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.js = (JavascriptExecutor)driver;
		
		
	}
	
	
	
	//Scenario 1
	@Given("user is on zendy landing page")
	public void user_is_on_zendy_landing_page() throws Exception {
		
		pageTitle = textContextSetup.pageObjectManager.landingPage.getTitle();
		Assert.assertEquals(pageTitle, "Home | Zendy");
		textContextSetup.pageObjectManager.landingPage.getLoginButtonElement().click();
		
	    
	}
	
	@Then("user checks all the key buttons and links are visible")
	public void user_checks_all_the_key_buttons_and_links_are_visible() {
		
		Assert.assertEquals(true, zendyLogo.isDisplayed());
	    Assert.assertEquals(true, loginButton.isDisplayed());
	    Assert.assertEquals(true, signupButton.isDisplayed());
	    Assert.assertEquals(true, aboutLink.isDisplayed()); 
	    Assert.assertEquals(true, yourOnlineLibrary.isDisplayed());
	}
	
	//Scenario 2
	@When("user logs in to zendy application")
	public void user_logs_in_to_zendy_application() throws InterruptedException {
		Assert.assertEquals(true, loginButton.isDisplayed());
		Thread.sleep(20); 
		
		SetLoginPageData();
		
	    Assert.assertEquals(true, emailAddress.isDisplayed());
	    Assert.assertEquals(true, password.isDisplayed());
	    Assert.assertEquals(true, forgotPassword.isDisplayed());
	   // Assert.assertEquals(true, logInButton.isEnabled());
	    //Fill Login Page details
	    emailAddress.sendKeys("daminisingh.1405+test@gmail.com");
	    password.sendKeys("DiscoSing@92");
	    Thread.sleep(50);
	    //Assert.assertEquals(true, logInButton.isEnabled());
	    textContextSetup.pageObjectManager.loginPage.getSignInButtonElement().click();
		
	}
	
	
	
	@Then("user homepage is loaded with username")
	public void user_homepage_is_loaded_with_username() {
		
		WebElement userName = textContextSetup.pageObjectManager.userHomePage.getUserName();
		wait.until(ExpectedConditions.visibilityOf(userName));
	
		Assert.assertEquals(true, userName.isDisplayed());
		
		
	}
	@When("user search for {string} text")
	public void user_search_for_text(String string) {
	    
		WebElement searchBox = textContextSetup.pageObjectManager.userHomePage.getSearchBox();
		WebElement searchButton = textContextSetup.pageObjectManager.userHomePage.getSearchButton();
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		Assert.assertEquals(true, searchButton.isDisplayed());
		searchBox.sendKeys(string);
		searchBox.sendKeys(Keys.ENTER);
		
	}
	@Then("user is landed to search page with search results")
	public void user_is_landed_to_search_page_with_search_results() {
	    
		WebElement refineResult = textContextSetup.pageObjectManager.searchResultsPage.getRefineResultsLabelElement();
		wait.until(ExpectedConditions.visibilityOf(refineResult));
		Assert.assertEquals(true, refineResult.isDisplayed());
		
	}
	@Then("user selects download button for first option")
	public void user_selects_download_button_for_first_option() {
		
		WebElement downloadButton = textContextSetup.pageObjectManager.searchResultsPage.getDownloadButtonElement();
		searchText = textContextSetup.pageObjectManager.searchResultsPage.getSearchText().getText();
		Assert.assertEquals(true, downloadButton.isDisplayed());
		js.executeScript("arguments[0].click()", downloadButton);
	}
	@Then("user is redirected to new page for downloading article.")
	public void user_is_redirected_to_new_page_for_downloading_article() {
	    
		switchToChildWindow();
		String childWindowText = driver.getTitle();
        Assert.assertEquals(searchText, childWindowText);
        Assert.assertEquals(false, false);
	    
	}
	
	@Then("user selects read button for first option")
	public void user_selects_read_button_for_first_option() {
		
		WebElement readButton = textContextSetup.pageObjectManager.searchResultsPage.getDownloadButtonElement();
		searchReadText = textContextSetup.pageObjectManager.searchResultsPage.getSearchText().getText();
		Assert.assertEquals(true, readButton.isDisplayed());
		js.executeScript("arguments[0].click()", readButton);
	}
	
	@Then("user is redirected to new page for reading article.")
	public void user_is_redirected_to_new_page_for_reading_article() {
		
		switchToChildWindow();
		WebElement childPageTitle = textContextSetup.pageObjectManager.getNewTabDataPage().getNewTabPageTitleElement();
		wait.until(ExpectedConditions.visibilityOf(childPageTitle));
		String childWindowText = childPageTitle.getText();
        Assert.assertEquals(searchReadText, childWindowText);
	}
	
	public void SetLoginPageData()
	{
		//login page assignments
		this.emailAddress = textContextSetup.pageObjectManager.loginPage.getEmailAddressElement();
		this.password = textContextSetup.pageObjectManager.loginPage.getPasswordElement();
		this.forgotPassword = textContextSetup.pageObjectManager.loginPage.getForgotPasswordElement();
		this.logInButton = textContextSetup.pageObjectManager.loginPage.getSignInButtonElement();
	}
	
	public void switchToChildWindow()
	{
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        //String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        //driver.switchTo().window(parent);
	}
	    
	
}
