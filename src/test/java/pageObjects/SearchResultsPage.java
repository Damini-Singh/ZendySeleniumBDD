package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	WebDriver driver;
	String packageName;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Refine results']")
	WebElement refineResultsLabel;
	
	@FindBy(xpath = "//div[contains(@data-test,'search-result-2-actions')]//button[1]")
	WebElement downloadButton;
	
	@FindBy(xpath = "//div[contains(@data-test,'search-result-0-actions')]//button[1]")
	WebElement readButton;
	
	@FindBy(xpath = "(//div[contains(@data-test,'search-result-0-title')]//span)[1]")
	WebElement searchReadText;
	
	@FindBy(xpath = "(//div[contains(@data-test,'search-result-2-title')]//span)[1]")
	WebElement searchText;
	
	public WebElement getRefineResultsLabelElement()
	{
		return refineResultsLabel;
	}
	
	public WebElement getDownloadButtonElement()
	{
		return downloadButton;
	}
	
	public WebElement getSearchText()
	{
		return searchText;
	}
	public WebElement getReadButtonElement()
	{
		return readButton;
	}
	
	public WebElement getSearchReadText()
	{
		return searchReadText;
	}
}
