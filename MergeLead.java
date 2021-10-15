package Steps_testcase;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseClass {
	List<String> allhandles;
	String leadID;

	@Given("Click the MergeLeads link")
	public void mergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}

	@And("Click the from search button")
	public void clickFrom() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();

	}

	@When("New windows open,switch to new window")
	public void newWindowOpen() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));

	}

	@Then("Enter the firstname as {string}")
	public void enterFirstName(String fName) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
	}

	@And("Click the FindLeadslink button to search")
	public void findLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	@When("Records will be displayed in the table,capture the leadid from the table")
	public void captureLeadid() throws InterruptedException {
		Thread.sleep(1000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();

	}

	@Then("Click the first row leadid from the displayed table")
	public void clickLeadid() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@When("New windows closes,switch to old window")
	public void newWindowCloses() {
		driver.switchTo().window(allhandles.get(0));

	}

	@And("Click the to search button")
	public void clickTo() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

	}

	@And("Click the merge button")
	public void clickMerge() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

	}

	@When("Alert appears accept it")
	public void alertHandle() {
		driver.switchTo().alert().accept();

	}

	@And("Click the FindLeads button to verify")
	public void findLeadButton() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@Given("Enter the lead as captured before")
	public void findMergeLead() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);

	}

	@And("Click the FindLeadslink button to check")
	public void clickfindsLead() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Verify if the data is merged")
	public void verifyLeadMerge() throws InterruptedException {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text,"No records to display");
		
		softAssert.assertAll();

			System.out.println("Records are merged Successfully ");
		
	}

	/*
	 * @Test public void leadMerge() throws InterruptedException {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */}
