package inkbox.wrapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {

	static AndroidDriver<AndroidElement> driver = null;

	public static void startAppium() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 20000);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "fb66ea39e09d5097");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create an Android driver to initiate the session to Appium server.
		driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Utilities.readPropertyFile("url"));
	}

	public static WebDriver getWebdriver() {
		return driver;
	}


	public static void startAppiumServerProgramically(){
		AppiumDriverLocalService appiumService;
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingAnyFreePort();
		builder.withIPAddress("127.0.0.1");
		appiumService = AppiumDriverLocalService.buildService(builder);
		appiumService.clearOutPutStreams();
		appiumService.start();



	}
}
