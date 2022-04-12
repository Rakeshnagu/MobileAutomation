package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class LoginSignUpPage {

	By email = By.xpath("//*[@id='login-email-field' and @form='accountLoginForm_login_home']");
	By password = By.xpath("//*[@id='login-password-field']");
	By loginBtn = By.xpath("//*[@id='accountLoginForm_login_home']/div/button");

	By signup = By.xpath("//p[contains(@class,'signup-toggle')]/span");
	By signUpButton = By.xpath("//button[@form='createAccountForm_login_home']");
	By emailSignUp = By.xpath("//form[@id='createAccountForm_login_home']//input[@id='signup-email-field']");
	By passwordSignUp = By.xpath("//form[@id='createAccountForm_login_home']//input[@id='signup-password-field']");
	
	public void enterLoginCredential() {
		Utilities.type(email, Utilities.readPropertyFile("email"));
		Utilities.type(password, Utilities.readPropertyFile("password"));
		Utilities.javascriptClick(loginBtn);
	}

	public void clickSignUp() {
		Utilities.click(signup);
	}

	public void signUpNewUser() {
		Utilities.type(emailSignUp, Utilities.randomString() + "@inkbox.com");
		Utilities.type(passwordSignUp, Utilities.readPropertyFile("password"));
		Utilities.javascriptClick(signUpButton);
	}

}
