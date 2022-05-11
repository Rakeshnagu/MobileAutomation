package inkbox.wrapper;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){
        return html;
    }

    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = DriverManager.getWebdriver();
        if(driver instanceof WebDriver){
            saveScreenshotPNG(driver);
        }
        saveTextLog(result.getTestName()  + " failed and screenshot " +
                "taken");
    }

}
