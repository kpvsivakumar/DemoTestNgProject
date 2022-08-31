package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoGuruCreditialsGettingPage {
	
	public WebDriver driver;
	
	public DemoGuruCreditialsGettingPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@style='color:#800080;font-size:28px;font-weight:700;']")
	WebElement accessDetailstoDemoSite;
	
	public WebElement accessDetailstoDemoSite(){
		return accessDetailstoDemoSite;
	}
	

}
