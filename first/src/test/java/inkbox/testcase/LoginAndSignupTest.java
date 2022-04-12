package inkbox.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import inkbox.modules.HamburgerMenu;
import inkbox.pages.HomePage;
import inkbox.pages.LoginSignUpPage;
import inkbox.wrapper.BaseClass;

public class LoginAndSignupTest extends BaseClass {

	@Test(enabled = true, description = "Validating login feature")
	public void C4878_Loginfeature() {
		hamburgerMenu = new HamburgerMenu();
		loginSignUpPage = new LoginSignUpPage();
		homePage = new HomePage();

		hamburgerMenu.navigateToLoginSignUpPage();
		loginSignUpPage.enterLoginCredential();

		Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");
	}
	
	
	@Test(enabled = true, description = "Validating signup feature")
	public void C4879_SignUp() {
		hamburgerMenu = new HamburgerMenu();
		loginSignUpPage = new LoginSignUpPage();
		homePage = new HomePage();

		hamburgerMenu.navigateToLoginSignUpPage();
		loginSignUpPage.clickSignUp();
		loginSignUpPage.signUpNewUser();

		Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");
	}
}
