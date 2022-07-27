package inkbox.modules;

import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Footer {

    final static Logger logger = Logger.getLogger(Footer.class);

    By poweredBy = By.xpath("//iframe[@title='Customer reviews powered by Trustpilot']");
    By privacyPolicy = By.xpath("//a[contains(@href,'privacy-policy')]");
    By termsOfService = By.xpath("//a[contains(@href,'terms-of-service')]");
    By copyrightText = By.xpath("//p[contains(text(),' inc. Proudly Made In North America')]");
    By logo = By.xpath("//p[contains(text(),' inc. Proudly Made In North America')]/../a");

    By subscribeEmailArrow = By.xpath("//input[@id='subscribe_email_default']/following-sibling::button");
    By subscribeEmailTextbox = By.xpath("//input[@id='subscribe_email_default']");
    By subscribeStatusMsg = By.xpath("//div[@x-show='showAlert']/descendant::li");

    By Facebook = By.xpath("//footer/descendant::span[text()='Facebook'][1]/following-sibling::*[name()='svg']");
    By instagram = By.xpath("//span[text()='Instagram']");
    By Pinterest = By.xpath("((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[1]");
    By YouTube = By.xpath("((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[3]");
    By Twitter = By.xpath("//footer/descendant::span[text()='Twitter'][1]/following-sibling::*[name()='svg']");
    By Tiktok = By.xpath("((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[5]");

    By helpAndFaq = By.xpath("//a[@class='underline']");
    By moreQuestion = By.xpath("//a[@class='underline']/..");
    By faqQuestion = By.xpath("//div[contains(@class,'faq-container')]//div[contains(@class,'faq-question faq-key-')]");

    By tracking = By.xpath("//a[normalize-space()='Tracking']");
    By contactUs = By.xpath("//a[contains(text(),'Contact Us')]");
    By frequentlyAskedQuestions = By.xpath("//h3[normalize-space()='Frequently Asked Questions']");


    public boolean checkPrivacyPolicyExist() {
        return Utilities.elementExist(privacyPolicy);
    }

    public boolean checkFrequentlyAskedQuestionsExist() {
        return Utilities.elementExist(frequentlyAskedQuestions);
    }

    public boolean checkTrackingExist() {
        return Utilities.elementExist(tracking);
    }

    public boolean checkContactUsExist() {return Utilities.elementExist(contactUs);}
    public boolean validateTracking() {
        Utilities.ScrollDown();
        Utilities.click(tracking);
        return Utilities.getCurrentUrl().contains("/tracking")?true:false;
    }

    public boolean validateContactUs() {
        Utilities.ScrollDown();
        Utilities.click(contactUs);
        return true;//Utilities.getCurrentUrl().contains("/tracking")?true:false;
    }

    public boolean checkTermsOfServiceExist() {
        return Utilities.elementExist(termsOfService);
    }

    public boolean checkCopyrightTextExist() {
        return Utilities.elementExist(copyrightText);
    }

    public void clickTermsOfService() {
        Utilities.ScrollDown();
        Utilities.checkPageIsReady();
        Utilities.javascriptClick(termsOfService);
        if (!Utilities.getCurrentUrl().contains("terms-of-service")) {
            Assert.fail("Not redirecting to 'Terms of Service' page, When we click on 'Terms of Service' link in footer");
        } else
            DriverManager.getWebdriver().navigate().back();
    }

    public void clickPrivacyPolicyText() {
        Utilities.ScrollDown();
        Utilities.checkPageIsReady();
        Utilities.javascriptClick(privacyPolicy);
        if (!Utilities.getCurrentUrl().contains("privacy-policy")) {
            Assert.fail("Not redirecting to 'Privacy Policy' page, When we click on 'Privacy Policy' link in footer");
        }
    }

    public boolean checkLogoExist() {
        return Utilities.elementExist(logo);
    }

    public boolean checkPoweredByExist() {
        return Utilities.elementExist(poweredBy);
    }

    public void Validate_About_Linkbox_Footer() {
        // About Linkbox validation
        String[] About_Inkbox_Array = {"Our Story", "Reviews", "Careers", "Press"};
        Utilities.ScrollDown();

        List<WebElement> About_Inkbox_elements = Utilities.webElementList(By.xpath("//h4[contains(text(),'About Inkbox')]/following-sibling::ul/descendant::a"));
        for (int i = 0; i < About_Inkbox_elements.size(); i++) {
            String elementName = null;
            String Url = null;
            int visible = 0;
            for (int j = 0; j < About_Inkbox_elements.size(); j++) {
                int k = j + 1;
                String xpath = "(//h4[contains(text(),'About Inkbox')]/following-sibling::ul/descendant::a)[" + k + "]";
                elementName = Utilities.getText(By.xpath(xpath));

                if (elementName.equalsIgnoreCase(About_Inkbox_Array[i])) {
                    visible = 1;
                    Utilities.click(By.xpath(xpath));
                    Utilities.checkPageIsReady();
                    Url = Utilities.getCurrentUrl();
                    DriverManager.getWebdriver().navigate().back();
                    Utilities.checkPageIsReady();
                    break;
                }
            }
            String ename = elementName;
            elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
            String correntURL = Url;
            Url = Url.toLowerCase().replace(" ", "").replace("-", "");
            if (visible == 1) {
                if (!Url.contains(elementName)) {
                    Assert.fail(ename + " : under About Inkbox is redirected to :" + correntURL);
                }
            } else {
            }
        }
    }


    public void Validate_Other_Footer() {
        // Other Validation
        String[] Other_Array = {"Partnerships", "Bulk Orders", "Student Discount", "Affiliate Program"};
        Utilities.ScrollDown();
        List<WebElement> Other_elements = Utilities.webElementList(By.xpath("//h4[contains(text(),'Other')]/following-sibling::ul/descendant::a"));
        for (int i = 0; i < Other_Array.length; i++) {
            String elementName = null;
            String Url = null;
            int visible = 0;
            for (int j = 0; j < Other_elements.size(); j++) {
                int k = j + 1;
                String xpath = "(//h4[contains(text(),'Other')]/following-sibling::ul/descendant::a)[" + k + "]";
                elementName = Utilities.getText(By.xpath(xpath));

                if (elementName.equalsIgnoreCase(Other_Array[i])) {
                    visible = 1;
                    Utilities.click(By.xpath(xpath));
                    Utilities.checkPageIsReady();
                    Url = Utilities.getCurrentUrl();
                    DriverManager.getWebdriver().navigate().back();
                    Utilities.checkPageIsReady();
                    break;
                }
            }
            String ename = elementName;
            elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
            String correntURL = Url;
            Url = Url.toLowerCase().replace(" ", "").replace("-", "");
            if (visible == 1) {
                if (ename.equalsIgnoreCase("Affiliate Program")) {
                    if (!correntURL.contains("https://signup.linkshare.com/publishers/registration/")) {
                        Assert.fail(ename + " : under Others is redirected to :" + correntURL);
                    }
                } else {
                    if (!Url.contains(elementName)) {
                        Assert.fail(ename + " : under Others is redirected to :" + correntURL);
                    }
                }

            } else {
                Assert.fail(Other_Array[i] + " : is not visible on Footer");
            }
        }

    }


    public void Validate_Customer_Care_Footer() {

        // Customer Care Validation

        String[] Customer_Care_Array = {"Shipping", "Returns", "Help & FAQ"};
        Utilities.ScrollDown();
        List<WebElement> Customer_Care_elements = Utilities.webElementList(By.xpath("//h4[contains(text(),'Customer Care')]/following-sibling::ul/descendant::a"));
        for (int i = 0; i < Customer_Care_Array.length; i++) {
            Utilities.ScrollDown();
            String elementName = null;
            String Url = null;
            int visible = 0;
            for (int j = 0; j < Customer_Care_elements.size(); j++) {
                int k = j + 1;
                String xpath = "(//h4[contains(text(),'Customer Care')]/following-sibling::ul/descendant::a)[" + k + "]";
                elementName = Utilities.getText(By.xpath(xpath));

                if (elementName.equalsIgnoreCase(Customer_Care_Array[i])) {
                    visible = 1;
                    Utilities.click(By.xpath(xpath));
                    Utilities.checkPageIsReady();
                    Url = Utilities.getCurrentUrl();
                    DriverManager.getWebdriver().navigate().back();
                    break;
                }

            }
            String ename = elementName;
            elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
            String correntURL = Url;
            Url = Url.toLowerCase().replace(" ", "").replace("-", "");
            if (visible == 1) {
                if (ename.equalsIgnoreCase("Help & FAQ") || ename.equalsIgnoreCase("Contact Us")) {
                    if (ename.equalsIgnoreCase("Contact Us")) {
                        String urllink = DriverManager.getWebdriver().findElement(By.xpath("//li/a[contains(text(),'Contact Us')]")).getAttribute("href");
                        if (!urllink.contains("mailto:info@getinkbox.com")) {
                            Assert.fail(ename + " : under Customer Care is redirected to :" + urllink);
                        }
                    } else {
                        if (!correntURL.contains("https://help.inkbox.com/")) {
                            Assert.fail(ename + " : under Customer Care is redirected to :" + correntURL);
                        }
                    }

                } else {
                    if (!Url.contains(elementName)) {
                        Assert.fail(ename + " : under Customer Care is redirected to :" + correntURL);
                    }
                }

            } else {
                Assert.fail(Customer_Care_Array[i] + " : is not visible on Footer");
            }
        }
    }


    public void validate_EmailField_Footer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Utilities.ScrollDown();
        Utilities.checkPageIsReady();

        Utilities.type(subscribeEmailTextbox, "abc@gmail.com");
        Utilities.javascriptClick(subscribeEmailArrow);
        Thread.sleep(3000);
        String message = DriverManager.getWebdriver().findElement(subscribeStatusMsg).getText();
        if (!message.contains("Successfully subscribed to our email list!")) {
            softAssert.fail("Successfully subscribed to our email list! message didn't came");
        }
        softAssert.assertAll();
    }


    public void Validate_SocialMedia_Footer() {
        SoftAssert softAssert = new SoftAssert();
        Utilities.ScrollDown();
        Utilities.click(instagram,1);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("instagram.com")) {
            softAssert.fail("Not redirecting to 'instagram' page, When we click on 'instagram' link in footer");
        }

        // controlHelper.SwitchToParent();

        Utilities.ScrollDown();
        Utilities.click(Pinterest);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("www.pinterest.ca")) {
            softAssert.fail("Not redirecting to 'pinterest' page, When we click on 'pinterest' link in footer");
        }

        Utilities.ScrollDown();
        Utilities.click(Facebook);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("www.facebook.com")) {
            softAssert.fail("Not redirecting to 'Facebook' page, When we click on 'Facebook' link in footer");
        }

        Utilities.ScrollDown();
        Utilities.click(YouTube);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("www.youtube.com")) {
            softAssert.fail("Not redirecting to 'YouTube' page, When we click on 'YouTube' link in footer");
        }

        Utilities.ScrollDown();
        Utilities.click(Twitter);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("twitter.com")) {
            softAssert.fail("Not redirecting to 'Twitter' page, When we click on 'Twitter' link in footer");
        }

        Utilities.ScrollDown();
        Utilities.click(Tiktok);
        Utilities.SwitchToChildWindow();
        if (!Utilities.getCurrentUrl().contains("www.tiktok.com")) {
            softAssert.fail("Not redirecting to 'Tiktok' page, When we click on 'Tiktok' link in footer");
        }
        softAssert.assertAll();
    }

    public void checkMoreQuestionExist(){
        Assert.assertTrue(Utilities.elementExist(moreQuestion),"More Question doesn't exist");
    }

    public void navigateToHelpAndFaq(){
        Utilities.ScrollDown();
        Utilities.ScrollDown();
        Utilities.click(helpAndFaq);
        Utilities.checkPageIsReady();
        Assert.assertTrue(Utilities.getCurrentUrl().contains("help.inkbox.com"),"User navigated to worng page " + Utilities.getCurrentUrl());
    }

    public void validateFaQ(){
        Utilities.ScrollDown();
        List<WebElement> element = Utilities.webElementList(By.xpath("//div[contains(@class,'faq-container')]//div[contains(@class,'faq-question faq-key-')]"));
        Utilities.checkPageIsReady();
        for (int i =0; i<element.size(); i++){
            Assert.assertTrue(Utilities.elementExist(By.xpath("//div[contains(@class,'faq-container')]//div[contains(@class,'faq-question faq-key-')]/../div[contains(@class,'faq-answer-"+i+"') and contains(@class,'hidden')]/span")),"faq should be in closed state");
            Utilities.javascriptClick(element.get(i));
            Assert.assertFalse(Utilities.elementExist(By.xpath("//div[contains(@class,'faq-container')]//div[contains(@class,'faq-question faq-key-')]/../div[contains(@class,'faq-answer-"+i+"') and contains(@class,'hidden')]/span")),"faq should be in open state");
        }

    }
}