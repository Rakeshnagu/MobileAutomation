package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class HomePage {
	
	By myAccount = By.xpath("//button/span[text()='My Account']");
	By cartIcon = By.xpath("//div[contains(@class,'group mainNav-cart')]");

	public boolean checkLoginSuccessfully() {
		return Utilities.elementExist(myAccount);
	}

	public void clickCartIcon(){
		Utilities.click(cartIcon);
	}

}
