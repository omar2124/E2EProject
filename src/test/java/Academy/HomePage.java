package Academy;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base{

	@Test (dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Text) throws IOException
	{
		driver = InitializeDriver();
		driver.get("http://qaclickacademy.com");
		/* There are two ways to access the method from another class
		 * One is inheritance
		 * second is creating object to that class and invoke methods of it
		 */
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(Username);		
		lp.Password().sendKeys(Password);
		System.out.println(Text);
		lp.LogIN().click();
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
