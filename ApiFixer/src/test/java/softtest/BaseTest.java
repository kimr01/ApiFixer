package softtest;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	public WebDriver driver;
	
	public BaseTest (WebDriver driver) {
		this.driver = driver;
		
	}
	

	public void PositiveTest () {
		
		HomePage hp = new HomePage (driver);
		DashboardPage dp = new DashboardPage (driver);
		
		// Assumption - correct UID = 'test1' correct Password = 'password'
		driver.get(hp.baseURL);
		hp.setUsername().sendKeys("test1");
		hp.setPassword().sendKeys("password");
		hp.submit().click();
		System.out.println("-------attempted log in------");
		// check if its get through
		if (dp.StringDashboard().getText().equals("Dashboard")){
			System.out.println("-------Login Successful-----");
		};
	
			
	}
	
	//  Read from api.fixer webPage and write to File
	public String readWriteWebContent (String inURL, String outFile) throws IOException {
		
		//URL url = new URL("http://api.fixer.io/latest?base=GBP");
		URL url = new URL(inURL);
		URLConnection conn = url.openConnection();

		// open the stream and put it into BufferedReader
		BufferedReader br = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

		String inputLine;

		//save to this filename
		String fileName = outFile; // add DateTime for File such as 20180412.txt
		File file = new File(fileName);

		if (!file.exists()) {
			file.createNewFile();
		}

		//use FileWriter to write file
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		while ((inputLine = br.readLine()) != null) {
			bw.write(inputLine);
		}

		bw.close();
		br.close();

		System.out.println("Done");

		return null;
	}

	
	public String fnGetRate (String currency, String inputFileName){
		
		File file = null;
		String filePath = inputFileName;
		FileInputStream fis = null;
		BufferedReader br =null;

		final int INDEXOFSTARTRATE = 5;  // first value of rate from Currency Symbol
		final int INDEXOFENDRATE = 6;  // last value of rate from first value of rate
		final int INDEXOFENDRATEOFIDR = 7;  // HANDLE IDR - 7 DIGIT VALUE
		final int INDEXOFENDRATEOFPHP = 5;  // HANDLE PHP - 5 DIGIT VALUE
		String Rate = null;

		
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(new InputStreamReader(fis));

		String strLine = null;
		
		try {
			while((strLine = br.readLine()) !=null) {
				
				System.out.println(strLine);
				
				System.out.println("position: " + strLine.indexOf(currency)); 
				// handle IDR RATE - 7 digits
				if (currency=="IDR") {
					Rate = strLine.substring(strLine.indexOf(currency)+INDEXOFSTARTRATE, strLine.indexOf(currency)+INDEXOFSTARTRATE+INDEXOFENDRATEOFIDR); 
					System.out.println("rate = " + Rate);
					// handle PHP RATE - 5 digits	
				} else if (currency == "PHP") {
					Rate = strLine.substring(strLine.indexOf(currency)+INDEXOFSTARTRATE, strLine.indexOf(currency)+INDEXOFSTARTRATE+INDEXOFENDRATEOFPHP); 
					System.out.println("rate = " + Rate);
					//  handle NORMAL RATE - 6 digits
				} else {
				Rate = strLine.substring(strLine.indexOf(currency)+INDEXOFSTARTRATE, strLine.indexOf(currency)+INDEXOFSTARTRATE+INDEXOFENDRATE); 
				System.out.println("rate = " + Rate);
				}
			//return Rate;	
			}
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		return Rate;
		
		

		

		}

}
