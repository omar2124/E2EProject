package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.cssSelector("input[id='user_email']");
	By password = By.xpath("//input[@name='user[password]']");
	By login = By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Email()
	{
		return driver.findElement(email);
	}
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	public WebElement LogIN()
	{
		return driver.findElement(login);
	}
}
