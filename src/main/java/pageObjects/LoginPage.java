package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email =By.cssSelector("input[type='email']");
	By password =By.cssSelector("input[type='password']");
	By login =By.cssSelector("[name='commit']");
	By forgotPass= By.cssSelector("[href*='new/index']");
	
  	public LoginPage(WebDriver driver)
  	{
		this.driver=driver;
	}   

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public ForgotPassword forgot()
	{
		 driver.findElement(forgotPass).click();
		return new ForgotPassword(driver);
	}



}
