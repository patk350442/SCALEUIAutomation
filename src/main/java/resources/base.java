package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public  WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\pmandi\\eclipse-workspacetest\\PracticeAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			 
			driver=new RemoteWebDriver(new URL(""),caps);
			
		}
		else
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
		}
		else
		if(browserName.equalsIgnoreCase("IE"))
		{
				
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(src,dest);
	}

}
