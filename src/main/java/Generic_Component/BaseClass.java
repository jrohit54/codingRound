package Generic_Component;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sun.javafx.PlatformUtil;

public class BaseClass {

	public static WebDriver driver;
	public static String BaseUrl="https://www.cleartrip.com/";

    /*
     * For explicit wait
     */
	public void explicitWait(WebElement ele, long t)
	{
		WebDriverWait wait=new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();	  
	}

	@BeforeSuite
	public void setUp()
	{
       setDriverPath();
       driver= new ChromeDriver();
       driver.get(BaseUrl);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
    /**
     * for wait
     * @param durationInMilliSeconds
     */
	public  void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
	/**
	 * For switch to frame
	 * @param name
	 */
	public void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	
	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}
	@AfterSuite
	public void testDown()
	{
		driver.quit();
	}
	
}