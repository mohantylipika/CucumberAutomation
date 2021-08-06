package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	// Creating a driver object referencing WebDriver interface
	WebDriver driver;

	@Given("login page is opened")
	public void login_page_is_opened() {
		String project_path = System.getProperty("user.dir");
		System.out.println(project_path);
		System.setProperty("webdriver.chrome.driver", project_path + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://example.testproject.io/web/");
	}

	@When("^user enters valid (.*) and valid (.*)$")
	public void user_enters_valid_username_and_valid_password(String username, String password)
			throws InterruptedException {
		System.out.println("######User enters valid user and valid password");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(500);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@id='login']")).click();
	}

	@Then("^(.*) is navigated to home page$")
	public void user_is_navigated_to_home_page(String username) {

		String exp_text = "Hello " + username + ", " + "let's complete the test form:";
		String act_text = driver.findElement(By.xpath("//p[@id='greetings']")).getText();
		Assert.assertEquals(exp_text, act_text);
		// Closing the browser
		driver.quit();

	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		String exp_text = "Password is invalid";
		String act_text = driver.findElement(By.xpath("//div[contains(text(),'Password is invalid')]")).getText();
		Assert.assertEquals(exp_text, act_text);
		driver.quit();

	}

}
