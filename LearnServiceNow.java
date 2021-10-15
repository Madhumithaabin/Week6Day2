package Steps_ServiceNow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Steps_testcase.BaseClass;
import io.cucumber.java.en.*;

public class LearnServiceNow extends BaseClass {
	List<String> searc;
	String incidentNum;
	String incNum;

	@Given("Click the All button")
	public void clickAll() {

		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

	}

	@When("New frame opens")
	public void frameOpens() {
		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);

	}

	@Given("Click the New button")
	public void clickNew() {

		driver.findElement(By.xpath("//button[text()='New']")).click();
	}

	@Given("Click the Caller Id button")
	public void clickCaller() {
		driver.findElement(By.id("lookup.incident.caller_id")).click();

	}

	@Then("Close the frame is open")
	public void frameCloses() {
		driver.switchTo().defaultContent();
		Set<String> windowHandles = driver.getWindowHandles();
		searc = new ArrayList<String>(windowHandles);

	}

	@When("New window open")
	public void windowOpen() {
		driver.switchTo().window(searc.get(1));

	}

	@Then("Click the first person name")
	public void clickName() {
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();

	}

	@Given("switch back to normal window")
	public void windowClose() {
		driver.switchTo().window(searc.get(0));

	}

	@Given("Enter the decription as {string}")
	public void description(String desc) {
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(desc);

	}

	@And("capture the incident number")
	public void capture_Inc() {
		incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
	}

	@When("click the submit button")
	public void click_submit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

	@Given("Enter the captured incident number in the search number")
	public void incident_Search() {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
//return incidentNum;

	}

	@When("Details is displayed capture the Incident number displayed")
	public void captureIncident_Search() {
		incNum = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

	}

	@Then("verify the incident is created")
	public void verify_Incident() {

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(incidentNum, incNum);
		System.out.println("incident is created successful ");

		softAssert.assertAll();

	}

}
