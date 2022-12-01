package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pageobject.AddnewCustomer;
import Pageobject.LoginPage;
import Pageobject.Searchcustomer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdef extends Baseclass {
	
	
	@Before
	public void setup()
	{
		log=LogManager.getLogger("Stepdef");
		System.out.println("Setup method executed");
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    log.info("Setup1 method is Excuted.....");
	}
	
@Given("User Launch the Browser")
	public void user_launch_the_browser() {
	    lp= new LoginPage(driver);
	    cust= new AddnewCustomer(driver);
	    search=new Searchcustomer(driver);
	    log.info("Browser gets launch.....");
}
	
@When("user opens URL {string}")
	public void user_opens_url(String url) {
	
		driver.get(url);
		log.info("open URL");
	}

	@When("user enters the Email as {string} and password as {string}")
	public void user_enters_the_email_as_and_password_as(String emailaddress, String password) {
	lp.enterEmail(emailaddress);
	lp.enterpsw(password);
		log.info("Enter email address");
		log.info("Enter password");

	}

	@When("Click on login button")
	public void click_on_login_button() {
	   lp.clickbtn();
	   log.info("click on login button");

	   
	}

	@Then("title page should be {string}")
	public void title_page_should_be(String expectedTitle) {
	    String actualtitle=driver.getTitle();
	    
	    if(expectedTitle.equals(actualtitle))
	    {
	    	Assert.assertTrue(true);
	    	log.warn("Test Passed: title page matched");
	    }
	    else {
	    	Assert.assertTrue(false);
	    	log.warn("Test case failed : Title not matched....");

	    }
	}

	@When("user click on Logout link")
	public void user_click_on_logout_link() {
	
		lp.logout();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Homepagetitleexp) {
	String homePtitleact=driver.getTitle();
	if(Homepagetitleexp.equals(homePtitleact))
	{
		Assert.assertTrue(true);
		log.warn("Test Passed: title page matched");
	}
	else {
		Assert.assertTrue(false);
		log.warn("Test case failed : Title not matched....");
		
	}
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}

//////////////////ADD New Customer///////////////////////
@Then("user can view Dashboard")
public void user_can_view_dashboard() {
String acttitle=driver.getTitle();
String exptitle="Dashboard / nopCommerce administration";
 if(exptitle.equals(acttitle))
 {
	 Assert.assertTrue(true);
	 log.warn("Test case Passed : Title  matched....");

 }
 else {
	 Assert.assertTrue(false);
	 log.warn("Test case failed : Title not matched....");

 }
	
}

@When("user clicks on Customer menu")
public void user_clicks_on_customer_menu() {
cust.clickcustomer();
}

@When("click on customer menu item")
public void click_on_customer_menu_item() {
cust.clickcustomeritem();
}

@When("click on add new Button")
public void click_on_add_new_button() {
cust.Clickadd();
}

@Then("user can view Add new customer page")
public void user_can_view_add_new_customer_page() {
	String acttitle=driver.getTitle();
	String exptitle="Add a new customer / nopCommerce administration";
	 if(exptitle.equals(acttitle))
	 {
		 Assert.assertTrue(true);
	 }
	 else {
		 Assert.assertTrue(false);
	 }

}

@When("user enter cutomer info")
public void user_enter_cutomer_info() {
//cust.enteremail("Test123@gmail.com");
cust.enteremail(GenerateEmail()+"@gmail.com");
cust.enterPassword("admin123");
cust.enterFname("Karan");
cust.enterLname("Joshi");
cust.entergender("Male");
cust.enterdob("11/26/2012");
cust.entercompany("codestudio");

log.info("customer enter information");

}

@When("click on Save button")
public void click_on_save_button() {
	cust.clickonsave();
	
	log.info("Save information");
	
}

@Then("user can view confirmation message {string}")
public void user_can_view_confirmation_message(String expectedconfirmation) {

	String bodytagtext=driver.findElement(By.tagName("Body")).getText();
	if(bodytagtext.contains(expectedconfirmation))
	{
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

@BeforeStep
public void beforestepDemo()
{
	System.out.println("This is before Step....");
}

@AfterStep
public void AfterstepDemo()
{
	System.out.println("This is after step demo");
}


@After
public void tearDown(Scenario sc)
{
	System.out.println("Tear down method executed......");
	if(sc.isFailed()==true)
	{
		String file=".//Screenshots/failtest.png";
		TakesScreenshot ts= ((TakesScreenshot)driver);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(file);
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	driver.quit();
	log.info("Browser closed");
}

////////////////////Search customer via Email/////////////////////////////

@When("customer enter email")
public void customer_enter_email() {
search.enteremailadd("admin@yourStore.com");
	
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
search.clickonSearch();   
}

/////////////////////Search customer via name///////////////////////////////
@Then("customer enter firstname")
public void customer_enter_firstname() {
search.enterfisrtname("Victoria");    
}

@Then("customer enter Lastname")
public void customer_enter_lastname() {
	search.enterlastName("Terces");    

	

}


}
