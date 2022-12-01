package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchcustomer {

	WebDriver driver;
	
	public Searchcustomer(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id="SearchEmail")
	WebElement email;
	
	@FindBy(id="search-customers")
	WebElement searchbtn;
	
	@FindBy(id="SearchFirstName")
	WebElement Fname;
	
	@FindBy(id="SearchLastName")
	WebElement Lname;
	
	
	public void enteremailadd(String emailadd)
	{
		email.sendKeys(emailadd);
	}
	
	public void clickonSearch() throws InterruptedException
	{
		searchbtn.click();
		Thread.sleep(3000);
	}
	
	public void enterfisrtname(String fisrtNm)
	{
		Fname.sendKeys(fisrtNm);
	}
	
	public void enterlastName(String lastNm)
	{
		Lname.sendKeys(lastNm);
	}
	
	
}
