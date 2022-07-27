package inkbox.pages;

import inkbox.modules.WishList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;
import org.testng.Assert;

public class HomePage {
	final static Logger logger = Logger.getLogger(HomePage.class);

	By myAccount = By.xpath("//button/span[text()='My Account']");
	By cartIcon = By.xpath("//div[contains(@class,'group mainNav-cart')]");
	By wishlist = By.xpath("//a[@id='nav-wishlist']");
	By yourProfile = By.xpath("//a[text()='Your Profile']");
	By changePassword = By.xpath("//a[normalize-space()='Change Password']");



	public boolean checkLoginSuccessfully() {
		return Utilities.elementExist(myAccount);
	}

	public void clickCartIcon(){
		Utilities.javascriptClick(cartIcon);
	}

	public void clickWishListIcon(){
		Utilities.click(wishlist);
	}
	public void clickMyAccount(){
		Utilities.click(myAccount);
	}

	public void clickYourProfile(){
		Utilities.click(yourProfile);
	}



	public void navigateToYourProfile(){
		Utilities.checkPageIsReady();
		Utilities.click(myAccount);
		Utilities.sleep(2000);
		Utilities.click(yourProfile);
		Utilities.checkPageIsReady();
	}

	public void clickChangePassword(){
		Utilities.click(changePassword);
	}




}
