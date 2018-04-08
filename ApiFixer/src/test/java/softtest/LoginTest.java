package softtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest {
	WebDriver driver;

	//HomePage hp = new HomePage (driver);
	//DashboardPage dp = new DashboardPage (driver);
	 
	@BeforeTest
	public void setup () {
		System.setProperty("webdriver.chrome.driver","C:\\Dev\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("------------BeforeTest done-------");
	}
	
	@AfterTest
	public void tearDown () {
		driver.quit();
		driver = null;
		System.out.println("------------AfterTest done-------");
	}
	
	
	
	@Test  
	public void PositiveLoginTest () {
		
		HomePage hp = new HomePage (driver);
		DashboardPage dp = new DashboardPage (driver);
		
		// Assumption - correct UID = 'test1' correct Password = 'password'
		driver.get(hp.baseURL);
		hp.setUsername().sendKeys("test1");
		hp.setPassword().sendKeys("password");
		hp.submit().click();
		System.out.println("-------attempted log in------");
		// check if it get through
		if (dp.StringDashboard().getText().equals("Dashboard")){
			System.out.println("-------test pass------");
		};
		Assert.assertEquals(dp.StringDashboard().getText(), "Dashboard");
		
		
	}
	@Test
	public void NegativeUIDPasswordLoginTest () {
		// Use - invalid username
		
		HomePage hp = new HomePage (driver);
		DashboardPage dp = new DashboardPage (driver);
        
		
		driver.get(hp.baseURL);
		hp.setUsername().sendKeys("DDDDD");
		hp.setPassword().sendKeys("1234566");
		hp.submit().click();
		System.out.println("-------attempted log in------");
		// check if it get through
		if (dp.StringDashboard().getText().equals(dp.txtDashboard)){
			System.out.println("-------test fail------");
		};
		Assert.assertEquals(dp.StringDashboard().getText(), dp.txtDashboard);

	}
	
	@Test    
	public void NegativeEmptyUIDPasswordLoginTest () {
		// Use - invalid username

		HomePage hp = new HomePage (driver);
		DashboardPage dp = new DashboardPage (driver);
	    
		//driver.get(hp.baseURL);  // http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com
		driver.get("http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com");
		
		hp.setUsername().sendKeys("");
		hp.setPassword().sendKeys("");
		hp.submit().click();
		System.out.println("-------attempted log in------");
		// check if it get through
		if (dp.StringDashboard().getText().equals(dp.txtDashboard)){
			System.out.println("-------test fail------");
		};
		Assert.assertEquals(dp.StringDashboard().getText(), dp.txtDashboard);
		
	}

	
}

