package PageClasses;
//Author -- Lakshay

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class ValidData extends BaseClass {
	
 
	@FindBy(xpath="//*[@id='cal_CM_DUEDATE']")
	public WebElement datte;
	@FindBy(xpath="//input[@name='SaveBtn']")
	public WebElement save;
	@FindBys(@FindBy(xpath="//*[@id='List']/table/tbody[2]/tr[1]/td[2]/select/option"))
	public List<WebElement> names;
	
	public ValidData(WebDriver driver) {
			BaseClass.driver=driver;
		
	}

	@Test
	public void data() {
		//valid date
		datte.click();
		List<WebElement> dattee=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		dattee.get(6).click();
		save.click();
		timewait(5);
	}
	
	@Test
	public void workflow() throws IOException {
		//workflow tab
		driver.findElement(By.name("KEY_Workflow")).click();
		timewait(5);
		
		driver.switchTo().frame("eform_seg_2095442");
		driver.findElement(By.xpath("//*[@name='selectsingleuser0']")).click();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
	 	//Create Excel Sheet
	    XSSFSheet sheet = workbook.createSheet("Details");
   	    //Iterate over the Data
	    Row row = sheet.createRow(0);
 	    row.createCell(0).setCellValue("SNo.");
 	    row.createCell(1).setCellValue("Names");
	 	    
	    for(int i=0;i<names.size();i++)
	 	    {
	 	    	row = sheet.createRow(i+1);
	 	    	row.createCell(0).setCellValue(i+1);
	 	    	row.createCell(1).setCellValue(names.get(i).getText());
	 	    	
	 	    }
	 	
	    //Write Down file on HardDisk
         FileOutputStream foss = new FileOutputStream(new File("initiator.xlsx"));
          workbook.write(foss);
	 	  System.out.println("Excel file is being created Successfully......Logging Out");
	
	
    }
	
	
}
