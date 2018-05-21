package Scenerio_Component;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Component.BaseClass;
import PageObject_Component.HomePage;
import PageObject_Component.HotelBookingPage;

public class HotelBookingTest extends BaseClass{
	
	
	  @Test
	    public void shouldBeAbleToSearchForHotels() {
		  driver.navigate().to(BaseUrl);
		  HomePage hm=new HomePage(driver);
		  hm.clickOnHotelLink();
		  HotelBookingPage hotelPage=new HotelBookingPage(driver);
		  hotelPage.enterLocationField("Indiranagar, Bangalore");
		  hotelPage.clickOnLocationAutoSuggestor(0);
		  hotelPage.clickOnFromDate();
		  hotelPage.clickOnToDate();
		  hotelPage.selectTravellers("1 room, 1 adult");
          hotelPage.clickOnSearchButton();
          waitFor(5000);
          Assert.assertTrue(hotelPage.isSearchSummaryResultDisplayed());
          
	  }

}
