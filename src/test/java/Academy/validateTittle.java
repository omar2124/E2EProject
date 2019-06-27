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


public class validateTittle extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		// Compare the text from the browser with the actual text
		Assert.assertEquals(l.getTittle().getText(), "FEATURED COURSES");
		log.info("Successfully Validated text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
