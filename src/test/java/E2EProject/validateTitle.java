package E2EProject;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

 public class validateTitle extends base 
 {
	 LandingPage lp;
	 public WebDriver driver; //to execute testcase parallerly u need to mention this line in evry testcase.
	 public static Logger Log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
		public void init() throws IOException
		{
		 driver=initializeDriver();
		 Log.info("Driver is initialized");
		 driver.get(prop.getProperty("url"));	
		 Log.info("Navigated to home page");
		}
	 
	 
	
	@Test
	public void title() throws IOException
	{
		lp= new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES12");
		 Log.info("Successful validated text message");
	}
	
	@Test
	public void title1() throws IOException
	{
	    lp= new LandingPage(driver);
		Assert.assertEquals(lp.getTitle1().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		 Log.info("Successful validated text message");
	}
	
	@Test
	public void PageNavigation() throws IOException
	{
		lp= new LandingPage(driver);
		Assert.assertTrue(lp.getNavigation().isDisplayed());
	    Log.info("Navigation Bar is Displayed");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
