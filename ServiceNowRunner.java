package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/Feature/ServiceNow.feature",glue={"Steps_ServiceNow","Hooks_Servicenow"},monochrome = true,publish = true,tags="@smoke and @functional")
public class ServiceNowRunner extends AbstractTestNGCucumberTests {

}
