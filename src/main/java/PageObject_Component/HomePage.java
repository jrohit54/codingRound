package PageObject_Component;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(linkText="Your trips")
	public WebElement tripElement;

	@FindBy(id="SignIn")
	public WebElement signInElement;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id="OneWay")
	private WebElement oneWayElement;

	@FindBy(id="FromTag")
	private WebElement fromElement;

	@FindBy(xpath="//ul[@id='ui-id-1']/li")
	private List<WebElement> allFromElements;

	@FindBy(xpath="//ul[@id='ui-id-2']/li")
	private List<WebElement> allToElements;

	@FindBy(id="ToTag")
	private WebElement toElement;

	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[3]/a")
	private WebElement dateElement;

	@FindBy(id="SearchBtn")
	private WebElement searchButton;

	@FindBy(className="searchSummary")
	private WebElement searchSummaryElement;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * To click on your trip link on home page
	 */
	public void clickOnYourTripLink()
	{
		explicitWait(tripElement, 2);
		tripElement.click();
	}
	/**
	 * To click on sign in link
	 */
	public void clickOnSignInLink()
	{
		explicitWait(signInElement, 2);
		signInElement.click();
	}
	/**
	 * To click on hotel link in home page
	 */
	public void clickOnHotelLink()
	{
		explicitWait(hotelLink, 2);
		hotelLink.click();
	}
	/**
	 * To click on radio button 
	 */
	public void clickOnOneWayRadioButton()
	{
		explicitWait(oneWayElement, 2);
		oneWayElement.click();
	}
	/**
	 * To enter data in   from field 
	 * @param text
	 */
	public void enterFromField(String text)
	{
		explicitWait(fromElement, 2);
		fromElement.clear();
		fromElement.sendKeys(text);	
	}
	/**
	 * to click on auto suggester
	 * @param index
	 */
	public void clickOnFromAutoSuggestor(int index)
	{	
		allFromElements.get(index).click();
	}
	/**
	 * to enter data in the to field
	 * @param text
	 */
	public void enterToField(String text)
	{
		explicitWait(toElement, 2);
		toElement.clear();
		toElement.sendKeys(text);		
	}
	/**
	 * To click on auto suggester
	 * @param index
	 */
	public void clickOnToAutoSuggestor(int index)
	{	
		allToElements.get(index).click();
	}
	/**
	 * to click on date
	 */
	public void clickOnDate()
	{
		explicitWait(dateElement, 2);
		dateElement.click();
	}
	/**
	 * to click on search button
	 */
	public void clickOnSearchButton()
	{
		explicitWait(searchButton, 2);
		searchButton.click();
	}
	/**
	 * To check is result displayed or not
	 * @return
	 */
	public boolean isSearchSummaryResultDisplayed()
	{
		explicitWait(searchSummaryElement, 2);
		return searchSummaryElement.isDisplayed();
	}
}
