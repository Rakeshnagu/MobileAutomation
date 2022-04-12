package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class HomePage {
	
	By myAccount = By.xpath("//button/span[text()='My Account']");

	public boolean checkLoginSuccessfully() {
		return Utilities.elementExist(myAccount);
	}
}
