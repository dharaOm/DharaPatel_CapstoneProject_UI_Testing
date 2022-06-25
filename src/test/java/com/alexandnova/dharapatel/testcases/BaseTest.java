package com.alexandnova.dharapatel.testcases;

import com.alexandnova.dharapatel.library.SelectBrowser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {

    static WebDriver driver;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    static{
        driver= SelectBrowser.StartBrowser("Chrome");
    }

    @BeforeSuite
        public void setUpReport() {

            //create the HtmlReporter in that path by the name of  MyOwnReport.html
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Dhara_Patel_Capstone_Project.html");
            extent = new ExtentReports();

            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "LAPTOP-FRSD91H0");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User Name", "Dhara Patel");
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("AlexAndNova Automation Testing report");
            htmlReporter.config().setReportName("AlexAndNova Test Automation Reports ");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.DARK);
        }

    @BeforeMethod
    public void setUpTestsReport(Method method) throws IOException {
        String methodName = method.getName();
        test = extent.createTest(methodName);
        test.addScreenCaptureFromPath(methodName + ".png");
    }
    @AfterMethod
    public void recordTestResults(ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE)
        {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshotFile, new File("test-output/xml/" +result.getName() +".png"));
            test.log(
                    Status.FAIL
                    ,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshotFile, new File("test-output/screenshots/" +result.getName() +".png"));
            test.log(Status.PASS, result.getTestName());
        }
        else
        {
            test.log(Status.SKIP, result.getTestName());
        }
    }
    @AfterSuite
    public void tearDown()
    {
       extent.flush();
        //driver.quit();
    }
}
