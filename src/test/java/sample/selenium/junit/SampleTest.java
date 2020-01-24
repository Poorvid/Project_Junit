package sample.selenium.junit;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	WebDriver driver;

	@Test
	public void checkcurrentURL() {
		// System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		// driver= new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("/index.php/auth/login"));
		driver.quit();

	}

	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin1");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();

		String status = driver.getCurrentUrl();
		Assert.assertTrue(status.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
		driver.quit();
	}

}
