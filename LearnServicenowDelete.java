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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LearnServicenowDelete extends BaseClass {

	List<String> searc;
	String incidentNum;
	String incNum;

	@Given("Click Open Button")
	public void clickOpen() {

		driver.findElement(By.linkText("Open")).click();

	}

	@When("New frame is opened")
	public void frameOpens() {
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

	}

	@Then("Click the first row from the table")
	public void clickNew() {

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}

	@And("capture the incident number for the deletion")
	public void captureIncident() {

		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
	}

	@When("Click the delete button")
	public void clickDelete() {

		driver.findElement(By.id("sysverb_delete")).click();

	}

	@Then("click the okay button in the alert")
	public void clickalert() {
		driver.findElement(By.id("ok_button")).click();

	}

	@Then("Closed the frame")
	public void frameCloses() {
		driver.switchTo().defaultContent();

	}

	@Then("Enter the incident Number stored and search the details")
	public void incident_Search() {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);

	}

	@And("Verify if the incident is deleted")
	public void verify_Incident() {
		String deleteConfirm = driver.findElement(By.xpath("//tr[@class='list2_no_records']/td")).getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(deleteConfirm, "No records to display");
		System.out.println("incident is Deleted successful ");

		softAssert.assertAll();

	}

}
