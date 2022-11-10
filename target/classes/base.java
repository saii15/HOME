package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base
{
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop= new Properties();
		//FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        FileInputStream fis= new FileInputStream("./src/main/java/resources/data.properties");
		prop.load(fis);
		//String browername=System.getProperty("brower"); //to get browser value from jenkins parameterized build.
        String browername=prop.getProperty("brower");
		System.out.println(browername);
		
		if(browername.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
           /* ChromeOptions option= new ChromeOptions();
			option.addArguments("headless");               this code is To run chrome in headless mode 
		    driver=new ChromeDriver(option);  */
		    driver.manage().window().maximize();
		}
		else
		if(browername.equals("firefox"))
		{
			//System.setProperty("webdriver.g.driver", "C:\\New folder\\chromedriver.exe");
		   // driver=new FireFoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	  public String getScreenshotPath(String testCaseName, WebDriver driver) throws
	  IOException { File src=
	  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); String dest=
	  System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	  FileUtils.copyFile(src, new File(dest));// for fileUtils add apache coomon io
	  return dest; // this is for attaching ss to extent report
	  }
	 
}
