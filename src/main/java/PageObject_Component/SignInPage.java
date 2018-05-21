package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.BaseClass;

public class SignInPage extends BaseClass{

	@FindBy(id="signInButton")
	public WebElement signInButton;

	@FindBy(id="errors1")
	public WebElement errorsElement;

	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * To click on Sign in button
	 */
	public void clickOnSignInButton()
	{
		explicitWait(signInButton, 2);
		signInButton.click();
	}
	/**
	 * To check is error message is displayed or not
	 * @param text
	 * @return
	 */
	public boolean  IsErrorTextDisplayed(String text)
	{
		explicitWait(errorsElement, 2);
		String string= errorsElement.getText();
		return string.contains(text);
	}
}
