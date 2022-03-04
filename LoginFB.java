package selenium;

import java.util.concurrent.TimeUnit;
import java.lang.SuppressWarnings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFB {
	static WebDriver  driver;
	@SuppressWarnings("deprecation")
	static void initializeAndLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	static void createNewAccount() {
	  driver.findElement(By.linkText("Create New Account")).click();
	  driver.findElement(By.name("firstname")).sendKeys("Arav0");
	  driver.findElement(By.name("lastname")).sendKeys("boss");
	  driver.findElement(By.name("reg_email__")).sendKeys("9611614787");
	  driver.findElement(By.id("password_step_input")).sendKeys("test1234ty!");
	  new Select(driver.findElement(By.id("day"))).selectByVisibleText("1");
	  new Select(driver.findElement(By.id("month"))).selectByIndex(5);
	  new Select(driver.findElement(By.id("year"))).selectByVisibleText("1990");
	  driver.findElement(By.xpath("//label[text()='Female']")).click();
	  System.out.println("Entered all the required details");
	  driver.close();
	}
	public static void main(String[] args) {
		initializeAndLogin();
		createNewAccount();
	}

}
