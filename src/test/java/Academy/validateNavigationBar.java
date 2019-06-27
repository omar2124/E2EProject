package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;


public class validateNavigationBar extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		// Compare the text from the browser with the actual text
		Assert.assertTrue(l.getNavigatioBar().isDisplayed());
		log.info("Navigation bar is displayed");
		//Assert.assertFalse(l.getNavigatioBar().isDisplayed());	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
