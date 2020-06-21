package testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.MyUtils;

public class FirstTest extends MyUtils  {
	
	String testSite = "https://www.google.com/";
	//start the grid. Once its running, it can be accessed via
	//http://localhost:4444/grid/console
	
	@Test(priority = 1)
	public void testGoogle() throws IOException {
		
		ExtentTest test = extent.createTest("TESTCASE 1 : Test of Selenium Grid + Docker");
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.google.com/");
		
		Wait();
		test.log(Status.PASS, "Test Test");
		MyUtils.takeScreenshot(driver, test);
		driver.quit();
			
		
	}
	
	@Test(priority = 2)
	public void testYahoo() throws IOException {
		
		ExtentTest test = extent.createTest("TESTCASE 1 : Test of Selenium Grid + Docker");
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.yahoo.com/");
		
		Wait();
		test.log(Status.PASS, "Test Test");
		MyUtils.takeScreenshot(driver, test);
		driver.quit();
				
	}
	
	@Test(priority = 3)
	public void testYoutube() throws IOException {
		
		ExtentTest test = extent.createTest("TESTCASE 1 : Test of Selenium Grid + Docker");
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.youtube.com/");
		
		Wait();
		test.log(Status.PASS, "Test Test");
		MyUtils.takeScreenshot(driver, test);
		driver.quit();
				
	}
	
	@Test(priority = 4)
	public void testFacebook() throws IOException {
		
		ExtentTest test = extent.createTest("TESTCASE 1 : Test of Selenium Grid + Docker");
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.facebook.com/");
		
		Wait();
		test.log(Status.PASS, "Test Test");
		MyUtils.takeScreenshot(driver, test);
		driver.quit();
				
	}
	
	
	

}
