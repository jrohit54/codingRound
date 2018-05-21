package PageObject_Component;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Component.BaseClass;

public class HotelBookingPage extends BaseClass{

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(xpath="//h1[text()='Search for hotels']")
	private WebElement headerElement;

	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[3]/a")
	private WebElement dateFromElement;

	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]/a")
	private WebElement dateToElement;

	@FindBy(xpath="//ul[@class='autoComplete']/li/a")
	private List<WebElement> allLocationElements;

	@FindBy(className="searchSummary")
	private WebElement searchSummaryElement;


	public HotelBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * To enter data in location field
	 * @param text
	 */
	public void enterLocationField(String text)
	{
		explicitWait(localityTextBox, 2);
		localityTextBox.sendKeys(text);
	}
	/**
	 * To select the travellers
	 * @param text
	 */
	public void selectTravellers(String text)
	{ 
		explicitWait(travellerSelection, 2);
		Select select = new Select(travellerSelection);
		select.selectByVisibleText(text);
	}
	/**
	 * To click on search button
	 */
	public void clickOnSearchButton()
	{
		explicitWait(searchButton, 2);
		searchButton.click();	
	}
	public void clickOnHeader()
	{
		headerElement.click();
	}
	/**
	 * to click on from data
	 */
	public void clickOnFromDate()
	{
		explicitWait(dateFromElement, 2);
		dateFromElement.click();
	}
	/**
	 * To click on location auto suggestor
	 * @param index
	 */
	public void clickOnLocationAutoSuggestor(int index)
	{	
		allLocationElements.get(index).click();
	}
	/**
	 * To click on To date
	 */
	public void clickOnToDate()
	{
		explicitWait(dateToElement, 2);
		dateToElement.click();
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
