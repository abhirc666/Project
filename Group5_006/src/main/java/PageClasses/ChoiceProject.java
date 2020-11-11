package PageClasses;
//Author -- Shalu Choudhary (name() & severity())
//Author -- Abhimanyu (project_select())
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class ChoiceProject extends BaseClass  {
	

	
	public ChoiceProject(WebDriver driver){
		BaseClass.driver=driver;
	}

	@FindBy(xpath="//*[@id='projectIcon']/ul/li[1]")
	public WebElement agile;
	
	@FindBy(xpath="//span[@id='KEY_BUTTON_Add-btnEl']")
	public WebElement add;
	
	@FindBy(xpath="/html/body/form/table[2]/tbody/tr/td/div[1]/table/tbody/tr/td/table/tbody/tr[1]/td[5]/input[1]")
	public WebElement nam;

	@FindBy(xpath="//input[@name='SaveBtn']")
	public WebElement save;
	
	@FindBy(xpath="//select[@name='DN_Severity']")
	public WebElement sev;
	
	@FindBy(xpath="//*[@id='AddWorkflow']/form/div[1]")
	public WebElement exp;
	
	@Test
	public void project_select() {
		//Select Defect Module under AgileProject
	   System.out.println("Selct Agile Project");
	   Actions actions = new Actions(driver);
	   WebElement mainMenu = driver.findElement(By.xpath("//div[@class='left_menu_icon_overlay']"));
	   actions.moveToElement(mainMenu).perform();
	
	   timewait(2);
	   agile.click();
	  
	   Actions action = new Actions(driver);
	   WebElement exec= driver.findElement(By.xpath("//a[@id='LOCK_Execute']"));
	   action.moveToElement(exec).perform();
	   timewait(2);
	   driver.findElement(By.xpath("//*[@id='LOCK_Defects']")).click();
	   add.click();
	   System.out.println("ok");

	}
    
	@Test
	public void name(String name) {
		//Enter name & description
		timewait(2);
		driver.switchTo().frame("contentframe");
		nam.sendKeys(name);
		save.click();
		alert();
		timewait(5);
		driver.findElement(By.xpath("//textarea[@name='CM_Description']")).sendKeys("des");
	    save.click();
		alert();
		timewait(5);


	}
	
	@Test
	public Priority severity() {
        //priority field testcases
		sev.click();
		driver.findElement(By.xpath("//*[@id='DN_Severity']/option[2]")).click();
		save.click();
		alert();
		timewait(5);

		return PageFactory.initElements(driver,Priority.class);
	}
}
