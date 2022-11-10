package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	public WebDriver driver;
	
	By signin =By.cssSelector("a[href*='sign_in']");
	By title =By.xpath("//*[@id='content']/div/div/h2[1]");
	By title1=By.cssSelector("div[class*='video-banner'] h3");
	By Navigation =By.cssSelector("ul.nav.navbar-nav.navbar-right");
	By letter= By.xpath("//button[contains(text(),'NO THANKS')]");
	By register= By.xpath("//span[contains(text(),'Register')]");
	
  	public LandingPage(WebDriver driver) //constructor
  	{
		this.driver=driver;
	}   

	public LoginPage getSignin()
	{
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getTitle1()
	{
		return driver.findElement(title1);
	}
	
	public WebElement getNavigation()
	{
		return driver.findElement(Navigation);
	}
	
	public WebElement cancelLetter()
	{
		return driver.findElement(letter);
	}
	
	public int getLetterSize()
	{
		return driver.findElements(letter).size();
	}
	
	public RegisterPage getRegister()
	{
		driver.findElement(register).click();
		return new RegisterPage(driver);
	}



}
