package Scenerio_Component;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Component.BaseClass;
import PageObject_Component.HomePage;

public class FlightBookingTest extends BaseClass{


	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOneWayRadioButton();
		hp.enterFromField("Bangalore");
		waitFor(2000);
		hp.clickOnFromAutoSuggestor(0);
		hp.enterToField("Delhi");
		hp.clickOnToAutoSuggestor(0);
		hp.clickOnDate();
		hp.clickOnSearchButton();
		waitFor(5000);
		Assert.assertTrue(hp.isSearchSummaryResultDisplayed());

	}

}
