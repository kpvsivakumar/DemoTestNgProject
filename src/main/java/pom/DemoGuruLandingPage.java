package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoGuruLandingPage {

	public WebDriver driver;
	public DemoGuruLandingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='emailid']")WebElement emailInputBox;
	
	@FindBy(xpath="//input[@name='btnLogin']") WebElement submittButton;
	
	public WebElement emailInputBox()
	{
		return emailInputBox;	
	}
	
	

	public WebElement submittButton() 
	{
		
		return submittButton;
	}

	
	
}
