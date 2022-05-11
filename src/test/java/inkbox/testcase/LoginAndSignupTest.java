package inkbox.testcase;

import inkbox.wrapper.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import inkbox.modules.HamburgerMenu;
import inkbox.pages.HomePage;
import inkbox.pages.LoginSignUpPage;
import inkbox.wrapper.BaseClass;

public class LoginAndSignupTest extends BaseClass {

    @Test(enabled = true, description = "Validating login feature")
    public void C4878_Loginfeature() {
            hamburgerMenu.navigateToLoginSignUpPage();
            loginSignUpPage.enterLoginCredential();

        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");
    }

    @Test(enabled = true, description = "Validating signup feature")
    public void C4879_SignUp() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.clickSignUp();
        loginSignUpPage.signUpNewUser();

        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");
    }

    @Test(enabled = true, description = "Signup with existing user to verify if an error message is displayed")
    public void C5059_SignupWithExistingUserToVerifyIfAnErrorMessageIsDisplayed() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.clickSignUp();
        loginSignUpPage.signUpWithLoginCredential();

        Assert.assertTrue(loginSignUpPage.errorEmailAlreadyExist(), "Error message is not coming when using exiting email id");
    }

    @Test(enabled = true, description = "Login with incorrect credentials")
    public void C5060_LoginWithIncorrectCredentials() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential(Utilities.readPropertyFile("email"), Utilities.readPropertyFile("email") + "123");

        Assert.assertTrue(loginSignUpPage.errorCredentialDoNotMatch(), "Error message is not coming when entered wrong login credential");
    }

    @Test(enabled = true, description = "Login with google")
    public void C4960_LoginWithGoogle(){
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.clickSignUp();
        loginSignUpPage.clickContinueWithGoogle();

    }

    @Test(enabled = true, description = "Login with existing user")
    public void C4959_LoginWithExistingUser() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();

        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");
    }

}