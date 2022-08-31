package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimViewEmployeeListPage {
	
	WebDriver driver;
	public PimViewEmployeeListPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement headerBreadCurumElement;
	
	public WebElement headerBreadCurumElement(){
		return headerBreadCurumElement;
	}
	

}
