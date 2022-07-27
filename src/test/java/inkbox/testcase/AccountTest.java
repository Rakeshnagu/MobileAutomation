package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseClass {

    @Test(retryAnalyzer = RetryListener.class, description = "Verifying Redeem reward on account\n")
    public void C4908_VerifyingRedeemRewardOnAccount() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        homePage.navigateToYourProfile();
        profilePage.clickReward();
        Assert.assertTrue(profilePage.checkChapter1Exist(),"Chapter 1 element doesn't exist");
        Assert.assertTrue(profilePage.checkChapter2Exist(),"Chapter 2 element doesn't exist");
        Assert.assertTrue(profilePage.checkRedeemableRewardsExist(),"Redeemable rewards element doesn't exist");
    }

    @Test(retryAnalyzer = RetryListener.class, description = "Verify Change Password Less Than 8Char")
    public void C5064_Verify_ChangePassword_LessThan8Char() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        homePage.navigateToYourProfile();
        homePage.clickChangePassword();
        profilePage.changePasswordWithCharLessThan8();

        Assert.assertTrue(profilePage.checkChangePasswordHeadingExist(), "Password should not be set when password length is less than 8 char");
    }

}