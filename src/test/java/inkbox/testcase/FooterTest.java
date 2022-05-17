package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FooterTest extends BaseClass {

    @Test(retryAnalyzer = RetryListener.class, enabled = true, description = "Validate Bold Text of footer with 'Excellent' Star Reviews and Trustpilot text")
    public void C21937_ValidateBoldTextFooter_ExcellentStarTrustPilot() {
        Assert.assertTrue(footer.checkPoweredByExist(), "Bold Text of footer with 'Excellent' Star Reviews and Trustpilot text not present");
    }

    @Test(retryAnalyzer = RetryListener.class, enabled = true, description = "Validate about Features under the \"About INKBOX\" whether they navigate to required page or not")
    public void Validate_About_INKBOX_InFooter() {
        footer.Validate_About_Linkbox_Footer();
    }

    @Test(retryAnalyzer = RetryListener.class, enabled = true, description = "Validate about Features under \"Other\" whether they're navigating the desired page.")
    public void C21943_Validate_OthersInFooter() {
        footer.Validate_Other_Footer();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "Validate about Features under \"Customer Care \" whether they navigating the desired page")
    public void C21942_Validate_Customer_Care_InFooter() {
        footer.Validate_Customer_Care_Footer();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "Validate bottom of Footer Text Logo 'INKBOX' year of Copyrights ,Proudly Made in North America ,Currency , Terms of Service and Privacy Policy")
    public void C21945_Validate_BottomFooter_TextLogo() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(footer.checkLogoExist(), "logo is not present in the footer");
        softAssert.assertTrue(footer.checkCopyrightTextExist(), " Copyright © 2022 inkbox ink inc. Proudly Made In North America -- text is missing on footer");
        softAssert.assertTrue(footer.checkPrivacyPolicyExist(), "privacy policy text missing");
        softAssert.assertTrue(footer.checkTermsOfServiceExist(), "terms of service text missing");
        softAssert.assertAll();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "validate and click on Terms of Service and Privacy Policy navigate to their respective page")
    public void C21948_Terms_of_Service_and_Privacy_Policy() {
        footer.clickTermsOfService();
        footer.clickPrivacyPolicyText();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "Validate the email box by giving credentials to subscription")
    public void C21940_Validate_EmailBox_InFooter() throws InterruptedException {
        footer.validate_EmailField_Footer();
    }

    @Test(enabled = false, retryAnalyzer = RetryListener.class, description = "validate social media partnership Inbox features directing towards location(instagram ,facebook etc..,)")
    public void C21944_SocialMedia_Validation()  {
        footer.Validate_SocialMedia_Footer();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "Validate and click on text \" More Questions ? Visit the Help & FAQ center navigate to required page")
    public void C21951_ValidateTextMoreQuestions(){
        footer.checkMoreQuestionExist();
        footer.navigateToHelpAndFaq();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "validate and click (+) sign to verify the answer below with (-) sign.")
    public void C21950_VerifyAnswer(){
        footer.validateFaQ();
    }

    @Test(retryAnalyzer = RetryListener.class, description = "validate and click currencies to change from one to each other in the application")
    public void C21947_ValidateAndClickCurrenciesToChangeFromOneToEachOther(){
        geolocation.validateCurrencyGettingSelected();
    }




}