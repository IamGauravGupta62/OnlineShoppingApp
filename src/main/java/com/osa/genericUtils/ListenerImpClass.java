package com.osa.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		//actual testscripts execution starts from here
		String MethodsName = result.getMethod().getMethodName();
		test=report.createTest(MethodsName);
		Reporter.log(MethodsName+"-----> Execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----Passed" );
		Reporter.log(MethodName+"----Testscript executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		WebDriverUtility wLib=new WebDriverUtility();
		try {
			String FaildScript = wLib.takeScreenShot(BaseClass.sdriver, MethodName);
            test.addScreenCaptureFromPath(FaildScript);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"----Failed");
		Reporter.log(MethodName+"----> Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"-----> Skipped");
		Reporter.log(MethodName+"----> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//create report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlreport.config().setDocumentTitle("SDET-1");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OnlineShoppingApplication");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "window-11");
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		report.setSystemInfo("Reporter Name ", "Gaurav");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
