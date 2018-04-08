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

public class LogoutTest {
	WebDriver driver;


	
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
	public void SignoutTest () {
		BaseTest bt = new BaseTest (driver);
		HomePage hp = new HomePage (driver);
		DashboardPage dp = new DashboardPage (driver);
		

		// precondition - Login Successful : call PositiveLoginTest from LoginTest.java
		bt.PositiveTest();
		dp.signOut().click();
		System.out.println("-------attempted signout------");
		// check if the signout gets through
		if (dp.signOut().getText().equals("Sign out")){
			System.out.println("-------test fail------");
		};
		// if sign out text exist, test fail
		Assert.assertFalse("Testfail", dp.signOut().getText().equals("Sign out"));
		//Assert.assertTrue("Testfail", dp.signOut().getText().equals("Sign out"));
	}
	
	
}

