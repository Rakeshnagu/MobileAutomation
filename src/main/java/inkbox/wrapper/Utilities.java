package inkbox.wrapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class Utilities {

	final static Logger logger = Logger.getLogger(Utilities.class);

	public static void checkPageIsReady() {
		logger.info("waiting for page to get loaded ");

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebdriver();

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after every 1
		// second.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public static void click(By loc) {
		logger.info("clicking " + loc);
		checkPageIsReady();
		DriverManager.getWebdriver().findElement(loc).click();
	}

	public static void javascriptClick(By loc) {
		checkPageIsReady();
		logger.info("clicking using javascript click " + loc);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebdriver();
		js.executeScript("arguments[0].click();", DriverManager.getWebdriver().findElement(loc));
	}

	public static void javascriptClick(WebElement element) {
		checkPageIsReady();
		logger.info("clicking using javascript click " + element);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebdriver();
		js.executeScript("arguments[0].click();", element);
	}

	public static void click(By loc, Integer index) {
		logger.info("clicking " + loc + " with index of list " + index);
		checkPageIsReady();
		DriverManager.getWebdriver().findElements(loc).get(index).click();
	}

	public static String getText(By loc) {
		checkPageIsReady();
		logger.info("Getting text for locator " + loc);
		String text = DriverManager.getWebdriver().findElement(loc).getText();
		logger.info("text is " + text);
		return text;
	}

	public static String getText(By loc, int index) {
		checkPageIsReady();
		logger.info("Getting text for locator " + loc);
		String text = DriverManager.getWebdriver().findElements(loc).get(index).getText();
		logger.info("text is " + text);
		return text;
	}

	public static Integer getListSize(By loc) {
		checkPageIsReady();
		System.out.println(DriverManager.getWebdriver().findElements(loc).size());
		return DriverManager.getWebdriver().findElements(loc).size();
	}

	public static List<WebElement> webElementList(By loc) {
		checkPageIsReady();
		return DriverManager.getWebdriver().findElements(loc);
	}

	public static String readPropertyFile(String key) {
		logger.info("Getting property value of " + key);
		String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("environment");
		try (InputStream input = new FileInputStream("src/test/resources/" + env + "_config.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out

			logger.info("value is " + prop.getProperty(key));
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void type(By loc, String value) {
		logger.info("entering data for locator " + loc + "and value is " + value);
		checkPageIsReady();
		DriverManager.getWebdriver().findElement(loc).sendKeys(value);
	}

	public static boolean elementExist(By loc) {
		checkPageIsReady();
		System.out.println( DriverManager.getWebdriver().findElements(loc).size());
		return DriverManager.getWebdriver().findElements(loc).size() > 0 ? true : false;
	}

	public static void HoverOver(By loc) {
		Actions action = new Actions(DriverManager.getWebdriver());
		action.moveToElement((DriverManager.getWebdriver().findElement(loc))).build().perform();
	}

	public static String randomString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getCurrentUrl() {
		checkPageIsReady();
		String url = DriverManager.getWebdriver().getCurrentUrl();
		System.out.println(url);
		return url;
	}


	public static void ScrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getWebdriver();
		jse.executeScript("window.scrollBy(0,7000)");
	}

	public static void ScrollTop() {
		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getWebdriver();
		jse.executeScript("window.scrollBy(0,-7500)");
	}

	public static void sleep(int timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void SwitchToChildWindow() {
		checkPageIsReady();
		String parentWindow = DriverManager.getWebdriver().getWindowHandle();
		Set<String> handles = DriverManager.getWebdriver().getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				DriverManager.getWebdriver().switchTo().window(windowHandle);
				checkPageIsReady();
				DriverManager.getWebdriver().close(); //closing child window
				DriverManager.getWebdriver().switchTo().window(parentWindow); //control to parent window
			}
		}
	}

	public static void SwitchToParent() {

		//controlHelper.SwitchToParent();
		String parent = DriverManager.getWebdriver().getWindowHandle();
		Set<String> s =  DriverManager.getWebdriver().getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				DriverManager.getWebdriver().switchTo().window(child_window);

				DriverManager.getWebdriver().close();
			}
		}
		// switch to the parent window
		DriverManager.getWebdriver().switchTo().window(parent);
	}


	public static void navigateBack(){
		DriverManager.getWebdriver().navigate().back();
	}




}