package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage
{
	public WebDriver driver;
	
	By fname =By.cssSelector("#user_name");
	By remail =By.cssSelector("#user_email");
	By rpass =By.cssSelector("#password");
	By rsignup =By.cssSelector("[value='Sign up']");
	By logo= By.xpath("/html/body/header/div[2]/div/div/div[2]/nav/div[2]/ul/li[9]/a/span");
	By logout= By.xpath("/html/body/header/div[2]/div/div/div[2]/nav/div[2]/ul/li[9]/ul/li[7]/a");
	
  	public RegisterPage(WebDriver driver) //constructor
  	{
		this.driver=driver;
	}   

	
	public WebElement getFirstName()
	{
		return driver.findElement(fname);
	}
	
	public WebElement getRegisterEmail()
	{
		return driver.findElement(remail);
	}
	
	public WebElement getRegisterPassword()
	{
		return driver.findElement(rpass);
	}
	
	public WebElement getSignUp()
	{
		return driver.findElement(rsignup);
	}
	
	public WebElement getLogo()
	{
		return driver.findElement(logo);
	}
	
	public WebElement getLogOut()
	{
		return driver.findElement(logout);
	}
	
	

}
