package example3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

		WebDriver driver;
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
		}
		
		@CacheLookup
		@FindBy(id ="username") WebElement username;
		
		@CacheLookup
		@FindBy(id ="password") WebElement password;
		
		@CacheLookup
		@FindBy(id ="login") WebElement loginButton;
	
		@CacheLookup
		@FindBy(id="username_show") WebElement userValidation;
		
		public void loginCrendtials(String user, String pass) {
			username.sendKeys(user);
			password.sendKeys(pass);
			loginButton.click();
		}
		
		public String getUserName() {
			return userValidation.getAttribute("value");
		}
}
