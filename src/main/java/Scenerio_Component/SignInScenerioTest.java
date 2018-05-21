package Scenerio_Component;


import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Component.BaseClass;
import PageObject_Component.HomePage;
import PageObject_Component.SignInPage;

public class SignInScenerioTest extends BaseClass {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		driver.navigate().to(BaseUrl);
		HomePage hm=new HomePage(driver);
		hm.clickOnYourTripLink();
		hm.clickOnSignInLink();
		switchToFrame("modal_window");
		SignInPage signPage=new SignInPage(driver);
		signPage.clickOnSignInButton();
		Assert.assertTrue(signPage.IsErrorTextDisplayed("There were errors in your submission"));

	}
	
}
