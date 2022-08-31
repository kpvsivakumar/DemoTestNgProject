package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReadExcelData;
import pom.DemoGuruCreditialsGettingPage;
import pom.DemoGuruLandingPage;
import resources.Base;

public class DemoGuruCredentialsGettingTest extends Base {
	
	public WebDriver driver;
	
	@Test(dataProvider="setData")
	public void testDemoGuruCredentialsGettingTest(String email) throws InterruptedException{
		DemoGuruLandingPage dglp= new DemoGuruLandingPage(driver);
		dglp.emailInputBox().sendKeys(email);
		dglp.submittButton().click();
		Thread.sleep(3000);
		DemoGuruCreditialsGettingPage dgcgp= new DemoGuruCreditialsGettingPage(driver);
		try{
			if(dgcgp.accessDetailstoDemoSite().isDisplayed())
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.assertFalse(false);
		}
	}
	
	@BeforeMethod
	public void openApplication() throws IOException{
		driver=intializeBrowser();
		driver.get("http://demo.guru99.com/");
	}
	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
	@DataProvider
	public Object[][] setData() throws Exception{
		/*String filePath="C:\\Users\\Lenovo\\sws\\FrameWorkProject\\TestData.xlsx";
		String sheet="Sheet2";
		Object[][] data= ReadExcelData.getTableArray(filePath, sheet);*/
		Object[][] data={{"kpvsivakumar439@gmail.com"},{"siva"},{"kumar"}};
		return data;
	}
}
