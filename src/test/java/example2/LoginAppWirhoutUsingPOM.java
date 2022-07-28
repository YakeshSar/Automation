package example2;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAppWirhoutUsingPOM {

	static WebDriver driver;
	WebElement element;
	


	@BeforeClass
	static public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void validCredentials() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		Date date = new Date();
		System.out.println(date);
		driver.get("http://adactinhotelapp.com/index.php");
		;
		driver.findElement(By.id("username")).sendKeys("Yakesh97");
		driver.findElement(By.id("password")).sendKeys("yake@SAR150720");
		driver.findElement(By.id("login")).click();
		String value = driver.findElement(By.id("username_show")).getAttribute("value");
		Assert.assertEquals("Hello Yakesh97!", value);
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println(date);
	}

	@Test(timeout = 1000)
	public void inVaildCredentials() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		Date date = new Date();
		System.out.println(date);
		driver.get("http://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys("Yakesh97");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("login")).click();
		String text = driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[5]/td[2]/div/b"))
				.getText();
		boolean expected = text.contains("Invalid");
		assertEquals(true, expected);
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println(date);
	}

	@AfterClass
	static public void closeBrowser() {
		driver.close();
	}
}
