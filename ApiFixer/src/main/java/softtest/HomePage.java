package softtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String baseURL = "http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com";

	@FindBy(xpath="//input[@placeholder='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;

	

	public WebElement setUsername () {
		return username;
	}
	
	public WebElement setPassword () {
		return password;
	}
	
	public WebElement submit () {
		return submit;
	}
	


}
