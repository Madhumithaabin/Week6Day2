package Steps_ServiceNow;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Assignments.IncidentList;
import Steps_testcase.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LearnServiceNowUpdate extends BaseClass {
	String incidentNum;
	String incNum;
	String urgencyname;
	String statename;

	@Given("Click Open Button to update incident")
	public void clickOpen() {
		driver.findElement(By.linkText("Open")).click();

	}

	@When("Frame will be opened")
	public void frameOpens() {
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

	}

	@Then("Click the first row from the displayed records to update")
	public void clickNew() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}

	@Given("Capture the Incindent number for confirm the updation")
	public void captureIncident() {

		incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
	}

	@And("Select the urgency as high")
	public void selectUrgency() {
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select = new Select(urgency);
		select.selectByValue("1");

	}

	@And("Select the status as improgress")
	public void selectStatus() {
		WebElement stateElement = driver.findElement(By.id("incident.state"));
		Select state = new Select(stateElement);
		state.selectByValue("2");

	}

	@When("Frame will be closed")
	public void frameCloses() {
		driver.switchTo().defaultContent();

	}

	@Then("Click the update button")
	public void clickUpdate() {
		driver.findElement(By.name("not_important")).click();

	}

	@Given("Click All Button to updated incident")
	public void clickAll() {
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

	}

	@And("Select the type of request as number")
	public void selectReqNumber() {
		WebElement typeReq = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select type = new Select(typeReq);
		type.selectByValue("number");

	}

	@Given("Enter the captured incident for the verification")
	public void incidentSearch() {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);

	}

	@Then("Capture the urgency and status of the incident")
	public void capturestatus() {

		urgencyname = driver.findElement(By.xpath("(//td[@class='vt'])[5]")).getText();
		statename = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		System.out.println(urgencyname);

		System.out.println(statename);
	}

	@And("verify if the data is properly updated")
	public void verify_Incident() {

		String exp = "High";
		String expstatus = "In Progress";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(urgencyname, exp);
		softAssert.assertEquals(statename, expstatus);

		System.out.println("incident is updated successful ");

		softAssert.assertAll();

	}

}
