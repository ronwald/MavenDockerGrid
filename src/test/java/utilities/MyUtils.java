package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyUtils {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	WebDriver driver;
	
	
	public static void Wait() {	
		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	
	@Parameters({ "OS", "browser" })
	@BeforeTest
	public void startReport(String OS, String browser) {
		
		//initialize html report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		//initialize extent reports and attach the html reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		 //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);
        
		
		//configure the look and feel of the report
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("Test Report");
				
	}
	
	@AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    }
	
	
	public static void takeScreenshot(WebDriver driver, ExtentTest test) throws IOException {
		
		//driver.manage().window().maximize();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Workspace\\DockerGridTest\\test-output\\screenshot.png"));
		//FileUtils.copyFile(scrFile, new File("C:\\Workspace\\DockerGridTest\\test-output\\screenshot" +  System.currentTimeMillis() +".png"));
		


		test.addScreenCaptureFromPath("C:\\Workspace\\DockerGridTest\\test-output\\screenshot" +  System.currentTimeMillis() +".png");
	
			
	}
	
	

}
