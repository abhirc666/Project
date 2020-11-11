package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
	//public static ExtentHtmlReporter htmlReporter;
			public static ExtentReports report;
			
			public static ExtentReports getReportInstance(){
				
				if(report == null){
					String reportName = DateUtil.getTimeStamp() + ".html";
					ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( "Lakshay Chaudhary" + reportName);
					report =  new ExtentReports();
					report.attachReporter(htmlReporter);
					
					report.setSystemInfo("OS", "Windows 10");
					report.setSystemInfo("Environment", "UAT");
					report.setSystemInfo("Build Number", "10.8.1");
					report.setSystemInfo("Browser", "Chrome");
					report.setSystemInfo("AuthorName","Lakshay Chaudhary");
					
					htmlReporter.config().setDocumentTitle("Automation Results");
					htmlReporter.config().setReportName("Test Report");
					htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
					htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
				}
				
				return report;
			}
}
