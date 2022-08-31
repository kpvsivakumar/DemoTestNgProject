package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.GetDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver intializeBrowser() throws IOException{
		
		//Loading the properties file
		
		prop= new Properties();
		String path ="C:\\Users\\Lenovo\\sws\\FrameWorkProject\\src\\main\\java\\resources\\properties";
		FileInputStream fin= new FileInputStream(path);
		prop.load(fin);
		
		String brow=prop.getProperty("browser");
		if(brow.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(brow.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(brow.equalsIgnoreCase("edze")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void enterUrl(){
		String ur = prop.getProperty("url");
		driver.get(ur);
	}
	
	public String takeScreenShots(String testName, WebDriver driver) throws IOException{
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+GetDate.getDate()+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	}
	

}
