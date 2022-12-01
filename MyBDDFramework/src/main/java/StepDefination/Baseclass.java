package StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pageobject.AddnewCustomer;
import Pageobject.LoginPage;
import Pageobject.Searchcustomer;

public class Baseclass {
public WebDriver driver;
	
	public LoginPage lp;
	public AddnewCustomer cust;
	public Searchcustomer search;
	public static Logger log;
	
	public String GenerateEmail()
	{
	return RandomStringUtils.randomAlphabetic(5);
	}
}
