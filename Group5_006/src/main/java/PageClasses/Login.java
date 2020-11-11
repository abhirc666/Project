package PageClasses;
//Author-- Abhimanyu
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class Login extends BaseClass{
	static Properties prop = readProperties();

	public Login(WebDriver driver) {
		BaseClass.driver=driver;
	}
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//input[@name='passwd']")
	public WebElement password;
	
	
	@Test
	public void email() {
	
		//enter email
		email.sendKeys(prop.getProperty("maill"));
		submit.click();
		timewait(5);
	    
	}
	@Test
	public ChoiceProject password() {
		//enter password
		password.sendKeys("120130@Manu");
		submit.click();
		timewait(10);
		System.out.println("Successfull login");
		
		return PageFactory.initElements(driver, ChoiceProject.class);
	}
}
