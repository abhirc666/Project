package PageClasses;
//Author --Shalu Choudhary (prio_sel() & release())
//Author --Ronak (sprint() & appraisal() & DefectActivity() & appraisal1())
//Author --Sumit(DefectActivity1())

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class Priority extends BaseClass {
    
	

	@FindBy(xpath="//input[@name='SaveBtn']")
	public WebElement save;
	@FindBy(xpath="//select[@name='CM_Priority']")
	public WebElement priority;
	
	@FindBy(xpath="//select[@name='CM_Release']")
	public WebElement rele;
	
	@FindBy(xpath="//select[@name='DN_Sprint']")
	public WebElement sprint;

	@FindBy(xpath="//select[@name='DN_AppraisalType']")
	public WebElement appr;
	@FindBy(xpath="//*[@id='StandardCode']")
	public WebElement def;
	
	public Priority(WebDriver driver) {
		BaseClass.driver=driver;
	}
	@Test
	public void prio_sel() {
		//priority testcases
		priority.click();
		driver.findElement(By.xpath("//*[@id='CM_Priority']/option[1]")).click();
		save.click();
		alert();
		timewait(5);

		priority.click();
		driver.findElement(By.xpath("//*[@id='CM_Priority']/option[2]")).click();
		save.click();
		alert();
		timewait(5);

	}

	@Test
	public void release() {
		//release field
		rele.click();
		driver.findElement(By.xpath("//*[@id='CM_Release']/option[1]")).click();
		save.click();
		alert();
		timewait(5);

		rele.click();
		driver.findElement(By.xpath("//*[@id='CM_Release']/option[3]")).click();
		save.click();
		alert();
		timewait(5);

	}
	
	@Test
	public void sprints() {
		//sprint field
		sprint.click();
		driver.findElement(By.xpath("//*[@id='DN_Sprint']/option[1]")).click();
		save.click();
		alert();
		timewait(5);

		sprint.click();
		driver.findElement(By.xpath("//*[@id='DN_Sprint']/option[2]")).click();
		save.click();
		alert();
		timewait(5);

	}

	@Test
	public void appraisal() {
		//appraisal field
		appr.click();
		driver.findElement(By.xpath("//*[@id='DN_AppraisalType']/option[1]")).click();
		save.click();
		alert();
		appr.click();
		driver.findElement(By.xpath("//*[@id='DN_AppraisalType']/option[2]")).click();
		save.click();
		alert();
	
	}
	
	
	@Test
	public void DefectActivity(){
		//DefectActivity field
		def.click();
		driver.findElement(By.xpath("//*[@id='StandardCode']/option[1]")).click();
		save.click();
		alert();
		def.click();
		driver.findElement(By.xpath("//*[@id='StandardCode']/option[2]")).click();
		save.click();
		alert();
	}
	
	@Test
	public void appraisal1() {
		//Select Testing Appraisal
		appr.click();
		driver.findElement(By.xpath("//*[@id='DN_AppraisalType']/option[3]")).click();
		save.click();
		alert();
	}
	
	@Test
	public void DefectActivity1(){
		//get size of DefectActivities under Testing Appraisal
		def.click();
		driver.findElement(By.xpath("//*[@id='StandardCode']/option[1]")).click();
		save.click();
		alert();
		def.click();
		List<WebElement> list1=driver.findElements(By.xpath("//*[@id='StandardCode']/option"));
		System.out.println(list1.size());
		save.click();
		alert();
		driver.findElement(By.xpath("//*[@id='StandardCode']/option[2]")).click();
		save.click();
		alert();
	}
	
	@Test
	public Reporting defect_detection() {

		return PageFactory.initElements(driver, Reporting.class);
	}
}
