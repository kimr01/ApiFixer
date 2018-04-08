package softtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DashboardTest {
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
	public void notDisplayedCurrencyTest () {
		DashboardPage dp = new DashboardPage (driver);
		// All Currency Symbols found from api.fixer file
		String[] expectedCurrency = {"AUD","HKD","DKK","BGN","BRL","CAD","CHF","CNY","CZK","EUR","HKD","HRK","HUF","ILS","INR","ISK","JPY","KWR","MXN","MYR","NOK","NZD","PHP","PLN","RON","RUB","SEK","SGD","THB","TRY","USD","ZAR"};

		driver.get(dp.DashboardURL);
		ArrayList<String> actualCurrency = new ArrayList<String>();
		// add each currency displayed in Dashboard into array
		actualCurrency.add(dp.AUD().getText());
		actualCurrency.add(dp.BGN().getText());
		actualCurrency.add(dp.BRL().getText());
		actualCurrency.add(dp.CAD().getText());
		actualCurrency.add(dp.CHF().getText());
		actualCurrency.add(dp.CNY().getText());
		actualCurrency.add(dp.CZK().getText());
		actualCurrency.add(dp.DKK().getText());
		actualCurrency.add(dp.EUR().getText());
		actualCurrency.add(dp.HKD().getText());
		System.out.println("actualCurrency : " + actualCurrency);
		
		
		//System.out.println("arrayLength = " + expectedCurrency.length);

	       ArrayList<String> currencyNotDisplayed = new ArrayList<String>();

           for(int i = 0; i < expectedCurrency.length; i++)
               {
                   //if(!Arrays.asList(expectedCurrency[i]).contains(actualCurrency))
                   if(!Arrays.asList(actualCurrency).contains(expectedCurrency[i]))  
                	 currencyNotDisplayed.add(expectedCurrency[i]);
                   
               }
		
           //System.out.println("Currency Symbols not displayed are: " +currencyNotDisplayed);
           //System.out.println(" Currency Symbols Not Displayed = " + currencyNotDisplayed.size());
           Assert.assertEquals(0, currencyNotDisplayed.size());
           
	}
	
	
	@Test  
	public void displayCurrencyTest () throws InterruptedException {
		BaseTest bt = new BaseTest (driver);
		DashboardPage dp = new DashboardPage (driver);
		
		// pre-condition - Successful Login: call ???? from BaseTest
		bt.PositiveTest();
		// make sure Dashboard page displayedsyso
		System.out.println("Dashboard Text = " + dp.StringDashboard().getText());
		
		Assert.assertEquals(dp.StringDashboard().getText(), "Dashboard");
		
		
		// check AUD
		//Assert.assertEquals(dp.AUD().getText(), "USD");
		Thread.sleep(5000);
		System.out.println("AUD is expected = " + dp.AUD().getText());
		
		// check AUD
		Assert.assertEquals(dp.BGN().getText(), "BGN");
		System.out.println("BGN is expected = " + dp.BGN().getText());
		// check AUD
		Assert.assertEquals(dp.BRL().getText(), "BRL");
		System.out.println("BRL is expected = " + dp.BRL().getText());
		
		// check AUD
		Assert.assertEquals(dp.CAD().getText(), "CAD");
		
		// check AUD
		Assert.assertEquals(dp.CHF().getText(), "CHF");
		
		
		// check AUD
		Assert.assertEquals(dp.CNY().getText(), "CNY");
		
		// check AUD
		Assert.assertEquals(dp.CZK().getText(), "CZK");
		
		// check AUD
		Assert.assertEquals(dp.DKK().getText(), "DKK");
		
		// check AUD
		Assert.assertEquals(dp.EUR().getText(), "EUR");
		
		// check AUD
		Assert.assertEquals(dp.HKD().getText(), "HKD");		
		
	}
	
	@Test  
	public void displayCurrencyFxRateTest () throws InterruptedException, IOException {
		BaseTest bt = new BaseTest (driver);
		DashboardPage dp = new DashboardPage (driver);
		String inputFile = "C://temp//test.txt";
		// 1. Read api.fixer webpage: call a function
		bt.readWriteWebContent("http://api.fixer.io//latest?base=GBP", "C://temp//test.txt");
			
		// 2. capture each currency's Fx rate from saved file: call a function
		String AUDFxRateInFile = bt.fnGetRate ("AUD", inputFile);
		String BGNFxRateInFile = bt.fnGetRate ("BGN", inputFile);
		String BRLFxRateInFile = bt.fnGetRate ("BRL", inputFile);
		String CADFxRateInFile = bt.fnGetRate ("CAD", inputFile);
		String CHFFxRateInFile = bt.fnGetRate ("CHF", inputFile);
		
		String CNYFxRateInFile = bt.fnGetRate ("CNY", inputFile);
		String CZKFxRateInFile = bt.fnGetRate ("CZK", inputFile);
		String DKKFxRateInFile = bt.fnGetRate ("DKK", inputFile);
		String EURFxRateInFile = bt.fnGetRate ("EUR", inputFile);
		String HKDFxRateInFile = bt.fnGetRate ("HKD", inputFile);
		
		driver.get(dp.DashboardURL);
		Thread.sleep(5000);
		// 3. capture Dashboard Fx Rate
		String AUDFxRateInDashBoard = dp.AUDrate().getText();
		// 4. compare Step 2 and Step 3
		System.out.println("AUDFxRateInFile:" + AUDFxRateInFile + "AUDFxRateInDashBoard: "+ AUDFxRateInDashBoard );
		Assert.assertEquals(AUDFxRateInFile, AUDFxRateInDashBoard);
		
		//BGN
		String BGNFxRateInDashBoard = dp.BGNrate().getText();
		Assert.assertEquals(BGNFxRateInFile, BGNFxRateInDashBoard);
		//BRL
		String BRLFxRateInDashBoard = dp.BRLrate().getText();
		Assert.assertEquals(BRLFxRateInFile, BRLFxRateInDashBoard);
		//CAD
		String CADFxRateInDashBoard = dp.CADrate().getText();
		Assert.assertEquals(CADFxRateInFile, CADFxRateInDashBoard);
		//CHF
		String CHFFxRateInDashBoard = dp.CHFrate().getText();
		Assert.assertEquals(CHFFxRateInFile, CHFFxRateInDashBoard);
		//CNY
		String CNYFxRateInDashBoard = dp.CNYrate().getText();
		Assert.assertEquals(CNYFxRateInFile, CNYFxRateInDashBoard);
		//CZK
		String CZKFxRateInDashBoard = dp.CZKrate().getText();
		Assert.assertEquals(CZKFxRateInFile, CZKFxRateInDashBoard);
		//DKK
		String DKKFxRateInDashBoard = dp.DKKrate().getText();
		Assert.assertEquals(DKKFxRateInFile, DKKFxRateInDashBoard);
		
		//EUR
		String EURFxRateInDashBoard = dp.EURrate().getText();
		Assert.assertEquals(EURFxRateInFile, EURFxRateInDashBoard);
		//HKD
		String HKDFxRateInDashBoard = dp.HKDrate().getText();	
		Assert.assertEquals(HKDFxRateInFile, HKDFxRateInDashBoard);
	}	
	
	
}

