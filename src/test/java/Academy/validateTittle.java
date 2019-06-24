package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;


public class validateTittle extends base{

	@Test
	public void basePageNavigation() throws IOException
	{
		driver = InitializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage l = new LandingPage(driver);
		// Compare the text from the browser with the actual text
		Assert.assertEquals(l.getTittle().getText(), "FEATURED COURSES123");
		
		
		
	}
	
}
