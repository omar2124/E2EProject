package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{

	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
	}
	
	@Test (dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Text) 
	{
		
		/* There are two ways to access the method from another class
		 * One is inheritance
		 * second is creating object to that class and invoke methods of it
		 */
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(Username);		
		lp.Password().sendKeys(Password);
		//System.out.println(Text);
		log.info(Text);
		lp.LogIN().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		Object[][] data = new Object[2][3];
		// 0th Row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User";
		// 1st Row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "67890";
		data[1][2] = "Non Restricted User";
		return data;
	}
}
