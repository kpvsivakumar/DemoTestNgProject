package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}

	@FindBy(name = "username")
	WebElement userNameTextBox;
	
	@FindBy(name="password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	

	public WebElement userNameTextBox() {
		return userNameTextBox;
	}
	public WebElement passwordTextBox() {
		return passwordTextBox;
	}
	public WebElement submitButton() {
		return submitButton;
	}
	
	

}
