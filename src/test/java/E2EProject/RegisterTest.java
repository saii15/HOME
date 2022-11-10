package E2EProject;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import resources.XLUtil;
import resources.base;

 public class RegisterTest extends base 
 {
	 public WebDriver driver; //to execute testcase parallerly u need to mention this line in evry testcase.
	 public static Logger Log =LogManager.getLogger(base.class.getName());
		
	 @BeforeTest
		public void init() throws IOException
		{
		 driver=initializeDriver();
		 
		}
	 
	@Test(dataProvider="loginData")
	public void registratin(String item) throws IOException
	{
		driver.get(prop.getProperty("url2"));
		driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
		s.selectByIndex(15);
		System.out.println(s.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(item);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.close();
	} 
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path=".\\dataFiles\\loginData.xlsx";
		XLUtil xlutil=new XLUtil(path);
		
		int totalrows=xlutil.getRowCount("Sheet3");
		int totalcols=xlutil.getCellCount("Sheet3",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet3", i, j);
			}
				
		}
		
		return loginData;
	}
	
	
}
