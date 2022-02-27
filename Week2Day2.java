import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2 {
    
	static ChromeDriver driver;
	@SuppressWarnings("deprecation")
	static void initializeChrome() {

		// it helps to avoid manual chrome driver path setup
		WebDriverManager.chromedriver().setup();

		// initialize chrome
		driver = new ChromeDriver();

		// maximize screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	static boolean login() {

		/**
		 * login to application
		 */
		boolean flag = true;
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		if (title.contains("Leaftaps")) {
			flag = true;
		}
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		return flag;
	}
	
	static void navigateToLeadTab() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	}
	
	static void searchLead() {
	  driver.findElement(By.xpath("//label[text()='First name:']/parent::div[@class='x-form-item x-tab-item']//input[@name='firstName']")).sendKeys("Test");
	  driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
	  driver.findElement(By.xpath("(//div[@class='x-grid3-scroller']//table[@class='x-grid3-row-table']//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a[@class='linktext'])[1]")).click();
	  driver.findElement(By.linkText("Edit")).click();
	  driver.findElement(By.id("updateLeadForm_companyName")).clear();
	  driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TEST12345");
	  driver.findElement(By.className("smallSubmit")).click();
	  boolean res = driver.getPageSource().contains("TEST12345");
	  System.out.println(res + " updated");
	  driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Open Chrome
		  initializeChrome();
	      System.out.println("Chrome Loaded");
	      
	      // Login application
	      boolean isLoggedIn = login();
	      System.out.println("Application logged in " + isLoggedIn);
	      Thread.sleep(5000);
	      
	      // Navigate to testlead tab
	      navigateToLeadTab();
	      System.out.println("application Navigates to find lead tab");
	      searchLead();
	}

}
