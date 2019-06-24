package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\omar zatarain\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			//Execute in Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			//Execute in Firefox
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("ie"))
		{
			//Execute in Internet Explorer
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
}
