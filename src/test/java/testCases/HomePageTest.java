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

public class HomePageTest extends base {
	
	public WebDriver driver;
	public static  Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializeTest() throws IOException
	{
		log.info("Starting beforeTest for HomePageTest..");
		driver=initializeDriver();
		log.info("initialized driver...");
		log.info("Ending beforeTest for HomePageTest..");
	}

	
	@Test(dataProvider="getData")
	public void homePageLogin(String username,String Password,String text) throws IOException
	{
		log.info("Opening url HomePageTest");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL HomePageTest");
		HomePage hp=new HomePage(driver);
		
		hp.popClose().click();
		hp.getLogin().click();
		log.info("clicked on login");
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getpassword().sendKeys(Password);
		log.info(text);
		lp.getlogin().click();
		log.info("successfully validated last step in homePageLogin test");
	}
	
	
	
	

	@AfterTest
	public void tearDown()
	{
		
		log.info("Starting...@AfterTest HomePageTest");
		driver.close();
		log.info("Ending...@AfterTest HomePageTest");
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="restricteduser@gmail.com";
		data[0][1]="Test123";
		data[0][2]="Restricted user";
		
		data[1][0]="nonrestricteduser@gmail.com";
		data[1][1]="Test123";
		data[1][2]="Non restricted user";
		
		
		return data;
	}
	

}
