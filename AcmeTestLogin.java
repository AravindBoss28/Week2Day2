package selenium;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTestLogin {

	WebDriver driver;
	String emailXpath = "//div[@class='controls']/input[@type='email']";
	String pwdXpath = "//div[contains(@class,'controls')]/input[@type='password']";
	String loginBtn = "//button[contains(text(),'Login')]";
	String logout = "Log Out";

	private void loadAndInitialize(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	private void login(String... s) {
		driver.findElement(By.xpath(emailXpath)).sendKeys(s[0]);
		driver.findElement(By.xpath(pwdXpath)).sendKeys(s[1]);
		driver.findElement(By.xpath(loginBtn)).click();
	}

	private void verifyPageTitle(String expectedTitle) {
		String ActualTitle = driver.getTitle();
		assertEquals(expectedTitle, ActualTitle);
		System.out.println(ActualTitle);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully verified");
	}

	private void logoutAndClose() {
		driver.findElement(By.linkText(logout));
		driver.close();
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		AcmeTestLogin al = new AcmeTestLogin();
		al.loadAndInitialize("https://acme-test.uipath.com/login");
		al.login("kumar.testleaf@gmail.com", "leaf@12");
		al.verifyPageTitle("ACME System 1 - Dashboard");
        al.logoutAndClose();
	}

}
