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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;





public class base {

	public static WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\omar zatarain\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
		if (browserName.equals("chrome"))
		{
			//Execute in Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
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
	public void getSchreenshot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Selenium\\Screenshots\\"+result+"Screenshot.png"));
	}
}
