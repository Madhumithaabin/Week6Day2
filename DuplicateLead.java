package Steps_testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {

	String leadID;

	@Given("Click the FindLeadslink")
	public void findLead() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@And("Click the phoneno button")
	public void clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

	}

	@And("Enter the phoneno as {string}")
	public void enterPhone(String pNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNumber);

	}

	@And("Click the FindLead button to check")
	public void clickfindlead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}
	@Then("Click the first row leadid when displayed")
	public void clickLead() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@And("Click the duplicate button")
	public void duplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();

	}

	@Given("Click the submit link")
	public void clickSubmit() {

		driver.findElement(By.name("submitButton")).click();

	}

	@Then("Duplicate lead is created")
	public void duplicateleadsucess() {
		String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("Sucessfully duplicated the lead");

		} else {
			System.out.println("lead is not duplicated");

		}
	}

}
