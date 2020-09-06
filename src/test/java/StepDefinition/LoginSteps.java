package StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	
	
	WebDriver driver =null;
	
	@Given("^browser is open$")
	public void browser_is_open()throws Throwable {
		
		System.out.println("Inside Step -browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
	  System.setProperty("webdriver.gecko.driver",projectPath+"/src/test/resources/drivers/geckodriver.exe");
	    
	//  System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
	    
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}  
	 @And("^user is on login page$")
	 
	   public void user_is_on_login_page() throws Throwable {
		 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
		driver.get("https://test.amplifypro.life/");
		driver.manage().window().maximize();
	}

	
	@When("^Dismiss the Cookie dialogs$")
	
	public void dismiss_the_Cookie_dialogs() throws Throwable {
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='button secondary']")).click();
	    
	}
	
	
	@When("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='button tertiary login_button']")).click();
		
	}
	
	@When("^user enter (.*) and (.*)")
	
	public void user_enter_username_and_password(String username,String password) throws InterruptedException {
		
		
	   //driver.findElement(By.xpath("//form[@class='login_form']//input[@name='username']")).clear();
	   
	   driver.findElement(By.xpath("//form[@class='login_form']//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//form[@class='login_form']//input[@class='button']")).click();
	}

	
	@Then("^user is navigated to the home page$")
	
	public void user_is_navigated_to_the_home_page() throws Throwable {
		String ExpectedSuccessfulMessage = "WELCOME";
		String ActualSuccessfulMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]")).getText();
	
		if(( ActualSuccessfulMessage.contains(ExpectedSuccessfulMessage)))
		{
		System.out.println("Welcome Page Successfully validated -->" + ActualSuccessfulMessage);
		}
		else{
		System.out.println("Welcome Page not Successfully validated -->" + ActualSuccessfulMessage);
		}
			
				driver.close();
	}
	}

	    
	
