package PageClasses;
//Author --Sumit(reporting_source() & due_date_none() &due_date_invalid())
//Author --Lakshay(due_date_wrong())
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class Reporting extends BaseClass {
	
	public Reporting(WebDriver driver) {
			BaseClass.driver=driver;
		
	}
	@FindBy(xpath="//*[@id='DN_ReportingSource']")
	public WebElement repo;
	@FindBy(xpath="//input[@name='SaveBtn']")
	public WebElement save;
	@FindBy(xpath="//*[@id='cal_CM_DUEDATE']")
	public WebElement date;
	
	@Test
	public void reporting_Source() {
		//Reporting Source testcases
		repo.click();
		driver.findElement(By.xpath("//*[@id='DN_ReportingSource']/option[1]")).click();
		save.click();
		alert();
		repo.click();
		driver.findElement(By.xpath("//*[@id='DN_ReportingSource']/option[2]")).click();
		save.click();
		alert();
		timewait(5);

    }
	@Test 
	public void due_date_none() {
	//leave empty duedate field
		date.click();
		driver.findElement(By.className("hasDatepicker")).sendKeys("");
		save.click();
		alert();
		timewait(5);
	}
	
	@Test
	public void due_date_invalid() {	
		//enter invalid format of duedate
		driver.findElement(By.className("hasDatepicker")).sendKeys("122320");
		save.click();
		alert();
		timewait(5);
	}
	
	@Test
	public ValidData due_date_wrong() {	
		//enter wrong date
		date.click();
		List<WebElement> datee=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		datee.get(1).click();
		save.click();
		alert();
		timewait(5);

		return PageFactory.initElements(driver, ValidData.class);
	}
	
}
