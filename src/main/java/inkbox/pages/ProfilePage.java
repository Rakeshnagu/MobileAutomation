package inkbox.pages;

import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProfilePage {

    final static Logger logger = Logger.getLogger(ProfilePage.class);

    By rewardsMenu = By.xpath("//a[text()='Rewards']");
    By chapter1 = By.xpath("//div[@id='rewards']//p[normalize-space()='Chapter 1']");
    By chapter2 = By.xpath("//div[@id='rewards']//p[normalize-space()='Next Level: Chapter 2']");
    By redeemableRewards = By.xpath("(//p[normalize-space()='Redeemable Rewards'])[1]");

    By currentPassword = By.xpath("//input[@id='currentPassword']");
    By newPassword = By.xpath("//input[@id='newPassword']");
    By confirmPassword = By.xpath("//input[@id='confirmPassword']");
    By savePasswordButton = By.xpath("//button[@form='password_form']");
    By changePasswordHeading = By.xpath("//h1[normalize-space()='Change Password']");

    public void clickReward() {
        try {
            Utilities.click(rewardsMenu);
            Utilities.checkPageIsReady();
        } catch (Exception ex) {
            Assert.fail("Unable to click reward menu");
        }
    }

    public boolean checkChapter1Exist(){
        return Utilities.elementExist(chapter1);
    }

    public boolean checkChapter2Exist(){
        return Utilities.elementExist(chapter2);
    }

    public boolean checkRedeemableRewardsExist(){
        return Utilities.elementExist(redeemableRewards);
    }

    public void changePasswordWithCharLessThan8(){
        Utilities.checkPageIsReady();
        Assert.assertTrue(Utilities.elementExist(changePasswordHeading),"User is not on change password heading");

        Utilities.type(currentPassword,Utilities.readPropertyFile("password"));
        Utilities.type(newPassword,"1234567");
        Utilities.type(confirmPassword,"1234567");
        Utilities.click(savePasswordButton);
    }

    public boolean checkChangePasswordHeadingExist(){
        return Utilities.elementExist(changePasswordHeading);
    }

}
