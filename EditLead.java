package Steps_testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass{
	
	@Given("Click the FindLeads link to search")
	public void findLead() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

@And("Click the Phoneno Button")
	public void clickPhone() {
	driver.findElement(By.xpath("//span[text()='Phone']")).click();

	}

	@And("Enter the phonenumber for edit as {string}")
	public void enterPhone(String pNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNumber);

	}

	@And("Click the FindLeads button to fetch the details")
	public void clickfindlead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}
	@Then("Click the first row leadid when the result is displayed")
	public void clickLead() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@And("Click the editlead button")
	public void clickEditLead() {
		driver.findElement(By.linkText("Edit")).click();

	}
	@Given("Enter the company name as {string}")
	public void updatecompanyname(String cmpName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cmpName);
		
	}
	@Given("Click the submit button")
	public void clickSubmit() {

		driver.findElement(By.name("submitButton")).click();

	}

	@Then("lead is edited successfully")
	public void editleadsucess() {
		String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("Sucessfully edited the lead");

		} else {
			System.out.println("lead is not edited");

		}

	}
	
	
}






