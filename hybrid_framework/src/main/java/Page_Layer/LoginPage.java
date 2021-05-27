package Page_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

import Util_package.Javascriptexe;

public class LoginPage  extends  baseClass {
	
	// POM with page story

		@FindBy(name = "txtUsername")
		WebElement username;

		@FindBy(id = "txtPassword")
		WebElement password;

		@FindBy(xpath = "//input[@type='submit']")
		WebElement loginButton;

		public LoginPage() {
			PageFactory.initElements(EventDriver, this);
		}

		// assiociated methods
		public void loginFunctionality(String uname, String pass) {
			username.sendKeys(uname);
			password.sendKeys(pass);
			Javascriptexe.ClickonElementUsingJS(loginButton);
		}

  }
 
 
 
