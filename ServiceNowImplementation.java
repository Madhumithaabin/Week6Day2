package Hooks_Servicenow;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Steps_testcase.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowImplementation extends BaseClass{
@Before
public void preCondition()
{	WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://dev96375.service-now.com/navpage.do");
WebElement frame = driver.findElement(By.id("gsft_main"));
driver.switchTo().frame(frame);
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("Abinjenny@96");
driver.findElement(By.id("sysverb_login")).click();
driver.switchTo().defaultContent();
driver.findElement(By.id("filter")).sendKeys("incident");
	
}
@After
public void postCondition()
{
	driver.close();
}
}
