package inkbox.pages;

import inkbox.modules.HamburgerMenu;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class LoginSignUpPage extends HamburgerMenu {

    By email = By.xpath("//*[@id='login-email-field' and @form='accountLoginForm_login_home']");
    By password = By.xpath("//*[@id='login-password-field']");
    By loginBtn = By.xpath("//*[@id='accountLoginForm_login_home']/div/button");

    By signup = By.xpath("//p[contains(@class,'signup-toggle')]/span");
    By signUpButton = By.xpath("//button[@form='createAccountForm_login_home']");
    By emailSignUp = By.xpath("//form[@id='createAccountForm_login_home']//input[@id='signup-email-field']");
    By passwordSignUp = By.xpath("//form[@id='createAccountForm_login_home']//input[@id='signup-password-field']");
    By errorEmailAlreadyExist = By.xpath("//li[normalize-space()='The email has already been taken.']");
    By errorCredentialDoNotMatch = By.xpath("//li[normalize-space()='These credentials do not match our records.']");

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

    public void loginToInkBox() {
        navigateToLoginSignUpPage();
        enterLoginCredential();
    }

    public boolean errorEmailAlreadyExist() {
        return Utilities.getListSize(errorEmailAlreadyExist) > 0 ? true : false;
    }

    public void signUpWithLoginCredential() {
        Utilities.type(emailSignUp, Utilities.readPropertyFile("email"));
        Utilities.type(passwordSignUp, Utilities.readPropertyFile("password"));
        Utilities.javascriptClick(signUpButton);
    }

    public void enterLoginCredential(String emailStr, String passwordStr) {
        Utilities.type(email, emailStr);
        Utilities.type(password, passwordStr);
        Utilities.javascriptClick(loginBtn);
    }

    public boolean errorCredentialDoNotMatch() {
        return Utilities.getListSize(errorCredentialDoNotMatch) > 0 ? true : false;
    }
}
