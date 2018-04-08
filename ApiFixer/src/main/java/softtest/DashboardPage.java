package softtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor st
	}

	
	
	// dashboard URL
	String DashboardURL = "http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com/dashboard.html?";

	// dashboard verification TEXT - Dashboard
    @FindBy(xpath="//h1[@class='h2'][contains(text(),'Dashboard')]")
	WebElement txtDashboard;
    
	// Sign out link
	@FindBy(xpath="//a[@class='nav-link']")
	WebElement signout;
	
	//web Elements Keypairs: Currency symbol and FX rate
	@FindBy(xpath="//html//tr[1]/td[1]")
	WebElement currencyAUD;
	@FindBy(xpath="//html//tr[1]/td[2]")
	WebElement rateAUD;
	
	@FindBy(xpath="//html//tr[2]/td[1]")
	WebElement currencyBGN;
	@FindBy(xpath="//html//tr[2]/td[2]")
	WebElement rateBGN;	
	
	@FindBy(xpath="//html//tr[3]/td[1]")
	WebElement currencyBRL;
	@FindBy(xpath="//html//tr[3]/td[2]")
	WebElement rateBRL;
	
	@FindBy(xpath="//html//tr[4]/td[1]")
	WebElement currencyCAD;
	@FindBy(xpath="//html//tr[4]/td[2]")
	WebElement rateCAD;
	
	@FindBy(xpath="//html//tr[5]/td[1]")
	WebElement currencyCHF;
	@FindBy(xpath="//html//tr[5]/td[2]")
	WebElement rateCHF;
	
	@FindBy(xpath="//html//tr[6]/td[1]")
	WebElement currencyCNY;
	@FindBy(xpath="//html//tr[6]/td[2]")
	WebElement rateCNY;
	
	@FindBy(xpath="//html//tr[7]/td[1]")
	WebElement currencyCZK;
	@FindBy(xpath="//html//tr[7]/td[2]")
	WebElement rateCZK;
	
	
	@FindBy(xpath="//html//tr[8]/td[1]")
	WebElement currencyDKK;
	@FindBy(xpath="//html//tr[8]/td[2]")
	WebElement rateDKK;
	
	@FindBy(xpath="//html//tr[9]/td[1]")
	WebElement currencyEUR;
	@FindBy(xpath="//html//tr[9]/td[2]")
	WebElement rateEUR;
	
	@FindBy(xpath="//html//tr[10]/td[1]")
	WebElement currencyHKD;
	@FindBy(xpath="//html//tr[10]/td[2]")
	WebElement rateHKD;
	
	
	// text Bashboard
	public WebElement StringDashboard () {
		return txtDashboard;
	}
	// signout link
	public WebElement signOut () {
		return signout;
	}
	
	
	// currency Symbol Elements
	public WebElement AUD () {
		return currencyAUD;
	}
	
	public WebElement BGN () {
		return currencyBGN;
	}
	
	public WebElement BRL () {
		return currencyBRL;
	}
	
	public WebElement CAD () {
		return currencyCAD;
	}
	public WebElement CHF () {
		return currencyCHF;
	}
	
	public WebElement CNY () {
		return currencyCNY;
	}
	
	public WebElement CZK () {
		return currencyCZK;
	}
	
	public WebElement DKK () {
		return currencyDKK;
	}
	
	public WebElement EUR () {
		return currencyEUR;
	}
	public WebElement HKD () {
		return currencyHKD;
	}
	
	// Currency exchange rate 
	public WebElement AUDrate () {
		return rateAUD;
	}
	
	public WebElement BGNrate () {
		return rateBGN;
	}
	
	public WebElement BRLrate () {
		return rateBRL;
	}
	
	public WebElement CADrate () {
		return rateCAD;
	}
	public WebElement CHFrate () {
		return rateCHF;
	}
	
	public WebElement CNYrate () {
		return rateCNY;
	}
	
	public WebElement CZKrate () {
		return rateCZK;
	}
	
	public WebElement DKKrate () {
		return rateDKK;
	}
	
	public WebElement EURrate () {
		return rateEUR;
	}
	public WebElement HKDrate () {
		return rateHKD;
	}
	
	
}
