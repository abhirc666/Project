package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import PageClasses.Priority;
import PageClasses.Reporting;
import PageClasses.Login;
import PageClasses.ChoiceProject;
import PageClasses.ValidData;

public class Objects extends BaseClass{

	Login login;
	ChoiceProject prj;
	Priority prio;
	Reporting rep;
	ValidData valid;
	

	@Test(priority=1)
	public void scenario1() throws IOException, InterruptedException  {
		
		//Extent report 
		logger = report.createTest("Defect Module");	
		BaseClass base=new BaseClass();
	
		logger.log(Status.INFO, "Open https://pratesting.cognizant.com");
		base.openUrl();
	    logger.log(Status.PASS, "Site opened");
		
		login=base.openUrl();
		logger.log(Status.INFO, "Login by passing email");
		login.email();
		logger.log(Status.PASS, "Valid Email passed");
		
	    logger.log(Status.INFO, "Login by passing password");
		prj=login.password();
		logger.log(Status.PASS, "Valid password passed");

		logger.log(Status.INFO, "Open Defect Module under Agile Project");
		prj.project_select();
		logger.log(Status.PASS, "Defect MOdeule Opened");
	
	}
	@Test(priority=2)
	public void scenario2() {
		logger.log(Status.INFO, "Enter name & description");
	    prj.name("Defect1");
	    logger.log(Status.PASS, "name & description Entered and got an alert");
	
	    logger.log(Status.INFO, "Select severity");
		prio=prj.severity();
    	logger.log(Status.PASS, "Severity selected");
		
	    logger.log(Status.INFO, "Select major priority & none");
		prio.prio_sel();
		logger.log(Status.PASS, "Both priority testcases passed");
		
		logger.log(Status.INFO, "Select none & AutoRelease release");
		prio.release();
		logger.log(Status.PASS, "Both release testcases passed");

		logger.log(Status.INFO, "Select Sprint");
		prio.sprints();
		logger.log(Status.PASS, "Sprint Selected");

		logger.log(Status.INFO, "Select none & Review under appraisal");
		prio.appraisal();
		logger.log(Status.PASS, "Appraisal testcases passes");
		
		logger.log(Status.INFO, "Select Defect Activity");
		prio.DefectActivity();
		logger.log(Status.PASS, "Defect Activity Selected");
		
		logger.log(Status.INFO, "Select Testing Appraisal");
		prio.appraisal1();
		logger.log(Status.PASS, "Testing Appraisal Selected");
		
		logger.log(Status.INFO, "Check Defect Activities under Testing Appraisal");
		prio.DefectActivity1();
		logger.log(Status.PASS, "13 Defect Activities");
		
	
		rep=prio.defect_detection();
		
		logger.log(Status.INFO, "Select none & Cognizant Reporting Source");
		rep.reporting_Source();
		logger.log(Status.PASS, "Value is not set for Reporting & due date alert");
		
		logger.log(Status.INFO, "Due date field empty");
		rep.due_date_none();
		logger.log(Status.PASS, "Please enter due date alert");
		
		logger.log(Status.INFO, "Enter date with invalid format");
		rep.due_date_invalid();
		logger.log(Status.PASS, "Please enter the date in correct format-Alert");
		
		logger.log(Status.INFO, "Enter date");
		valid=rep.due_date_wrong();
		logger.log(Status.PASS, "Due date should be inbetween Current & Project end date");
	}
	@Test(priority=3)
	public void scenario3() throws IOException, InterruptedException  {
		logger.log(Status.INFO, "Enter valid date");
		valid.data();
		logger.log(Status.PASS, "Information save");
		
		logger.log(Status.INFO, "Click workflow button");
		valid.workflow();
		logger.log(Status.PASS, "List of names stored");
		
		
	}
}
