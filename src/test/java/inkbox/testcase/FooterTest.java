package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseClass {

    @Test(retryAnalyzer= RetryListener.class, enabled = true, description = "Validate Bold Text of footer with 'Excellent' Star Reviews and Trustpilot text")
    public void C21937_ValidateBoldTextFooter_ExcellentStarTrustPilot(){
        Assert.assertTrue(footer.checkPoweredByExist(),"Bold Text of footer with 'Excellent' Star Reviews and Trustpilot text not present");
    }

    @Test(retryAnalyzer= RetryListener.class, enabled = true, description = "Validate about Features under the \"About INKBOX\" whether they navigate to required page or not")
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
}