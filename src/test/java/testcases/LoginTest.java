package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReadExcelData;
import pom.LoginPage;
import pom.PimViewEmployeeListPage;
import resources.Base;

public class LoginTest extends Base {

	// Properties prop;
	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "dataProvider")
	public void loginTest(String email, String password) throws IOException, InterruptedException {

		

		LoginPage lp = new LoginPage(driver);
		lp.userNameTextBox().sendKeys(email);
		log.debug("Email addressed got entered");
		lp.passwordTextBox().sendKeys(password);
		log.debug("Password addressed got entered");
		lp.submitButton().click();
		log.debug("Clicked on Login Button");
		Thread.sleep(3000);
		PimViewEmployeeListPage pel = new PimViewEmployeeListPage(driver);

		try {
			boolean displayed = pel.headerBreadCurumElement().isDisplayed();

			if (displayed) {
				Assert.assertTrue(true);
				log.debug("User got logged in");
				log.info("Login Test got passed");
			}

		} catch (Exception e) {
			Assert.assertFalse(false);
			log.debug("User did'nt logged in");
			log.error("Login Test got failed");
		}

		// Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] dataProvider() throws Exception {
		String filePath="C:\\Users\\Lenovo\\sws\\FrameWorkProject\\TestData.xlsx";
		String sheet="Sheet1";
		Object[][] data = ReadExcelData.getTableArray(filePath, sheet);
		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		log.debug("Browser got closed");
	}

	@BeforeMethod
	public void openBrowser() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = intializeBrowser();
		log.debug("Browser Got Launched");
		enterUrl();
		log.debug("Navigated to Application URL");
	}

}
