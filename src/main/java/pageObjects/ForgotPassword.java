package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword
{
	public WebDriver driver;
	
	By email =By.cssSelector("[type='email']");
	By instruction=By.cssSelector("[name='commit']");
	
	
  	public ForgotPassword(WebDriver driver) //constructor
  	{
		this.driver=driver;
	}   

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getInstruction()
	{
		return driver.findElement(instruction);
	}
	
	
}
