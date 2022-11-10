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

 public class ForgotTest extends base 
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
		lp.cancelLetter().click();
		LoginPage log= lp.getSignin();
		log.getEmail().sendKeys(uname);
		log.getPassword().sendKeys(password);
		Log.info(text); //will directly see in file without printing
		//log.getLogin().click();
		ForgotPassword fp= log.forgot();
		fp.getEmail().sendKeys("bhbhbb@gmail.com");
		fp.getInstruction().click();
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.close();
	} 
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[1][3];           //2 user with 3 value
		                                            //          0        1       2
		
		data[0][0]="non@qw.com";
		data[0][1]="123";
		data[0][2]="restricted user";
		
		return data;
	}
	
	
}
