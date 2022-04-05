package test;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AutomationChromeBase {

	@Test
	public void setupCapabilities() throws MalformedURLException, InterruptedException {
		
		// 1 Create Device Capabilities.
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT,20000);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"fb66ea39e09d5097");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
		caps.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		System.out.println("3");
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("4");
						
		// 4 Create an Android driver to initiate the session to Appium server.			
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.get("http://www.google.com");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//input[@class='gLFyf']")).click();
		driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("test");
	}
}