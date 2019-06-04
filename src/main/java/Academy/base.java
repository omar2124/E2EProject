package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {

	public void InitializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\omar zatarain\\eclipse-workspace\\E2EProject\\src\\main\\java\\Academy\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName=="chrome")
		{
			//Execute in Chrome driver
		}
		else if (browserName=="firefox")
		{
			//Execute in Firefox
		}
		else if (browserName=="ie")
		{
			//Execute in Internet Explorer
		}
	}
}
