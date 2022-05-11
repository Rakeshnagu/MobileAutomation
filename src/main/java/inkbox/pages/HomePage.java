package inkbox.pages;

import inkbox.modules.WishList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class HomePage {
	final static Logger logger = Logger.getLogger(HomePage.class);

	By myAccount = By.xpath("//button/span[text()='My Account']");
	By cartIcon = By.xpath("//div[contains(@class,'group mainNav-cart')]");
	By wishlist = By.xpath("//a[@id='nav-wishlist']");
	public boolean checkLoginSuccessfully() {
		return Utilities.elementExist(myAccount);
	}

	public void clickCartIcon(){
		Utilities.click(cartIcon);
	}

	public void clickWishListIcon(){
		Utilities.click(wishlist);
	}

}
