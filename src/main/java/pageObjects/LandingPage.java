package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By tittle = By.xpath("//*[@id=\"content\"]/div/div");
	By navbar= By.xpath("//nav[@class='navbar-collapse collapse']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTittle()
	{
		return driver.findElement(tittle);
	}
	public WebElement navBar()
	{
		return driver.findElement(navbar);
	}
	
	
}