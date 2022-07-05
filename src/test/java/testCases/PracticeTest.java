package testCases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class PracticeTest extends base {
	public WebDriver driver;
	public static  Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initializeTest() throws IOException
	{

		log.info("Starting beforeTest for PracticeTestTitle..");
		driver=initializeDriver();
		log.info("initialized driver for PracticeTestTitle...");
		driver.get("https://2022devadfs.manhdevscale.com/scale/");
		
		log.info("opening url for for PracticeTestTitle..");
		log.info("Ending beforeTest for PracticeTestTitle..");
		
	}
	
	@Test
	public void PracticeTestTitle() throws IOException
	{
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void tearDown()
	{

		log.info("Starting...@AfterTest ValidateTitleTest");
		driver.close();
		log.info("Ending...@AfterTest ValidateTitleTest");
	
	}
	
}
