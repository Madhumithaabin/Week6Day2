package Steps_ServiceNow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class LearnServiceNowIncident extends BaseClass {

	String assigned;
	String incidentNum;
	String incNum;
	List<String> newwindow;
	@Given("Click Open Button to search incident")
	public void clickOpen() {
		driver.findElement(By.linkText("Open")).click();

	}

	@When("New frame will be opened")
	public void frameOpens() {
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

	}

	@Then("Click the first row from the displayed records")
	public void clickRecord() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}

	@Given("capture the Incindent number for verification")
	public void captureIncident() {
		 incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
	}


	@Then("New frame will be closed")
	public void frameCloses() {
		driver.switchTo().defaultContent();

	}
	@When("Click the incident Assignment group search button")
	public void clickIncidentGroup() {

		driver.findElement(By.id("lookup.incident.assignment_group")).click();

	}
	@When("New window in opened")
	public void newWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		newwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newwindow.get(1));
	}
@Given("Enter s to search group")
public void enterSearch() {
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("s", Keys.ENTER);


}
@When("Click the software assignment group")
public void clickSoftware() {
	driver.findElement(By.xpath("//a[text()='Software']")).click();

}

@Then("switch back to old window")
public void windowClosed() {
	driver.switchTo().window(newwindow.get(0));

}
@Given("Enter the worknotes")
public void workNotes() {
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("testlead updation");

}

@When("Click the Assign button")
	public void clickAssign() {
	driver.findElement(By.name("not_important")).click();

	}



	@Given("Enter the incident number to check")
	public void incidentSearch() {

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);

	}

	@Then("captures the result for the search")
	public void captureResult() {
		assigned = driver.findElement(By.xpath("(//a[@class='linked'])[2]")).getText();

	}

	@And("verify if the incident assigned properly")
	public void verify_Incident() {

		if (assigned.equals("Software"))
			System.out.println("incident is assigned to software group");
		else
			System.out.println("incident is assigned not to software group");

	}
	


}
