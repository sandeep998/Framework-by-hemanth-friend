package com.fankick.reportutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import fankick.utilities.FileConstants;
import fankick.utilities.SeleniumUtilis;

public class ReportUtils extends SeleniumUtilis implements FileConstants
{
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	static String reportDir = "";
    static String reportName = "";
    
	@BeforeSuite(alwaysRun = true)
	public void startReport()
	{
		File file = new File("./Reports");
		if (!file.exists())
		{
			file.mkdir();
		}
		reportName = "TestReport_"+randomStrig() + ".html";
		String string = "./Reports/" + reportName;
		reportDir = string;
		htmlReporter = new ExtentHtmlReporter(string);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("");
		htmlReporter.config().setReportName("Fankick");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws Exception
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
           String screenshotPath = getScreenshot(getDriver(), result.getName());
          logger.addScreenCaptureFromPath(screenshotPath.replace("./Reports", ""));
		} else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
//		SeleniumUtils.quitDriver();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination =  "./Reports/" + screenshotName + dateName+ ".png";
		String f = screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return f;
	}
	
	public void getMethodName()
	{
		final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
		final String s = e.getClassName();
		String methodName = s.substring(s.lastIndexOf('.') + 1, s.length()) + " | " + e.getMethodName();
		logger = extent.createTest(methodName);
	}

	public void pass(String message)
	{
		logger.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}
	public void Comment(String message)
	{
		logger.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
	}
	
	public void fail(String message)
	{
		logger.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static String randomStrig()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("ddmmSsS");
		Date date = new Date();
		return formatter.format(date);
	}

	@AfterSuite(alwaysRun = true)
	public void endReport() throws Exception
	{
		extent.flush();
		String reportDoc = FileUtils.readFileToString(new File(reportDir), "utf-8");
		Document response = Jsoup.parse(reportDoc);
		Elements e = response.select("div.col.s12.m6.l6.np-h");
		Elements e1 = response.select("div.col.s2");
		Elements e2 = response.select("span.label.blue.darken-3");
		response.select("a.brand-logo.blue.darken-3").remove();
		response.select("span.label.start-time").remove();
		response.select("span.label.end-time").remove();
		for (int i = 0; i < e.size(); i++)
		{
			if (i == 1)
			{
				e.get(i).remove();
				e1.get(i).remove();
				e2.get(i).remove();
				break;
			}
		}
		String dateName = new SimpleDateFormat("ddMMyyyymmss").format(new Date());
		File f = new File(reportDir);
		FileUtils.writeStringToFile(f, response.outerHtml(), "UTF-8");
//		EmailUtility.sendEmail("Automation Report - "+dateName, reportDir, reportName);
	}
}
