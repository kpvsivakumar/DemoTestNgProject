package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utility.ExtentReporter;
import resources.Base;

public class Listeners extends Base implements ITestListener{
	
	public WebDriver driver;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onFinish(ITestContext result) {
		extentReport.flush();
		
	}

	@Override
	public void onStart(ITestContext result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName()+" execution started");
		extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//extentTest.log(Status.PASS,"Test Passed");
		extentTestThread.get().log(Status.PASS,"Test Passed");
		String testName = result.getName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String screenshotFilePath = takeScreenShots(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
