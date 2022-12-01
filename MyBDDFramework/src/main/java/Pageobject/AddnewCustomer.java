package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddnewCustomer {

	WebDriver driver;
	
	public AddnewCustomer(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement linkcustomer;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customeritem;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addnew;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement pass;
	
	@FindBy(name="FirstName")
	WebElement Fname;
	
	@FindBy(name="LastName")
	WebElement Lname;
	
	@FindBy(id="Gender_Male")
	WebElement malegender;

	@FindBy(id="Gender_Female")
	WebElement femalegender;
	
	@FindBy(name="DateOfBirth")
	WebElement dob;
	
	@FindBy(name="Company")
	WebElement Cname;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement Save;
	
	
	public void clickcustomer()
	{
		linkcustomer.click();
	}
	
	public void clickcustomeritem()
	{
		customeritem.click();
	}
	public void Clickadd()
	{
		addnew.click();
	}
	
	public void enteremail(String emailaddress)
	{
		email.sendKeys(emailaddress);
	}
	
	public void enterPassword(String password)
	{
		pass.sendKeys(password);
	}
	
	public void enterFname(String firstname)
	{
		Fname.sendKeys(firstname);
	}
	
	public void enterLname(String lastname)
	{
		Lname.sendKeys(lastname);
	}
	
	public void entergender(String gender)
	{
		if(gender.equals("Male"))
		{
			malegender.click();
		}else if(gender.equals("Female"))
		{
			femalegender.click();
		}
		else {
			malegender.click();
		}
		
		}
	
	public void enterdob(String dobirth)
	{
		dob.sendKeys(dobirth);
	}
	
	public void entercompany(String companyname)
	{
		Cname.sendKeys(companyname);
	}
	
	public void clickonsave()
	{
		Save.click();
	}
	
	
	
}