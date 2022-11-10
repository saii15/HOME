package E2EProject;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

 public class HomePage extends base 
 {
	 public WebDriver driver; //to execute testcase parallerly u need to mention this line in evry testcase.
	 public static Logger Log =LogManager.getLogger(base.class.getName());
		
	 @BeforeTest
		public void init() throws IOException
		{
		 driver=initializeDriver();
		}
	 
	@Test(dataProvider="getData")
	public void loginTest(String uname, String password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage lp= new LandingPage(driver);
		if(lp.getLetterSize()>0)
		{
			lp.cancelLetter().click();
		}
		LoginPage log= lp.getSignin();
		log.getEmail().sendKeys(uname);
		log.getPassword().sendKeys(password);
		Log.info(text); //will directly see in file without printing
		//log.getLogin().click();
		ForgotPassword fp= log.forgot();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	} 
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][3];           //2 user with 3 value
		                                            //          0        1       2
		data[0][0]="non@qw.com";                   //  0   non@qw.com   123    restricted user
		data[0][1]="123";                          //  1   res@qw.com   567    Non restricted user
		data[0][2]="restricted user";
		
		
		data[1][0]="res@qw.com";
		data[1][1]="567";
		data[1][2]="Non restricted user";
		
		return data;
	}
	
	
}
