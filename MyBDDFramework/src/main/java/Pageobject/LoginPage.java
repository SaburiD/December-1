package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement usn;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutbtn;
	
	public void enterEmail(String emailaddress)
	{
		usn.clear();
		usn.sendKeys(emailaddress);
	}
	
	public void enterpsw(String password)
	{
		pass.clear();
		pass.sendKeys(password);
	}
	
	public void clickbtn()
	{
		Loginbtn.click();
	}
	
	public void logout()
	{
		logoutbtn.click();
	}
}
