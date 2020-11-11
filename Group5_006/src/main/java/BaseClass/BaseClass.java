package BaseClass;
//Author --- Shalu Choudhary
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.Login;
import Utilities.ExtentReportManager;

public class BaseClass {

	public static WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	static Properties prop = readProperties();
  
	//invoke browser
	@Parameters("browser")
	@Test(priority=0)
	public void invokebrowser(String browser) {
		try {
		
			if(browser.equalsIgnoreCase("chrome"))
			{
		     	System.setProperty("webdriver.chrome.driver",prop.getProperty("chrome_path"));
		        driver=new ChromeDriver();
		       }
			
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",prop.getProperty("firefox_path"));
		        driver=new FirefoxDriver();
			     }
		     }catch(Exception e) {
		    	 System.out.println(e.getMessage());
		     }
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	
	//handle property file 
	public static Properties readProperties() {
		File file = new File("config.properties");
		  
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	//URL 
	public Login openUrl() {
		 String URL = prop.getProperty("URL");
	     driver.get(URL);
	     return PageFactory.initElements(driver, Login.class);
	}
	
	//Title validation
	public static boolean getTitle(String expectedTitle) {
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		return true;
	}
	
	//threadsleep wait
	public void timewait(int time) {
			try {
				Thread.sleep(time*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//alert 
	public void alert() {
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	//close browser
	@AfterSuite
	public void close() {
		
		driver.close();
		report.flush();
		System.out.println("report flush");
	}
	

	}

