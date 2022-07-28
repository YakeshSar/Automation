package example3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest {

	static WebDriver driver;
	LoginPage lp;

	public LoginPageTest() {
		lp = PageFactory.initElements(driver, LoginPage.class);
	}

	@BeforeClass
	static public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constant.URL);
	}

	@Test
	public void verifyLogin() throws IOException {
		System.out.println("Starting test " + new Object() {}.getClass().getEnclosingMethod().getName());
		String username = ExcelUtil.getCellData(1, 0);
		String password = ExcelUtil.getCellData(1, 1);
		lp.loginCrendtials(username, password);
		if (lp.getUserName().contains("Yakesh97")) {
			ExcelUtil.setCellData("Pass", 1, 2);
		} else {
			ExcelUtil.setCellData("Fail", 1, 2);
		}
		System.out.println("Ending test " + new Object() {}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	static public void closeBrowser() {
		driver.close();
	}
}
