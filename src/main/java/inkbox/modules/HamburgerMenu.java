package inkbox.modules;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class HamburgerMenu {

	By hamburgerMenu = By.xpath("//div[@id='nav-hamburger']");
	By joinInkfam = By.xpath("//span[contains(normalize-space(),'Join The Inkfam')]");

	By shop = By.xpath("//li[@id='menu-L0-shop']/a");
	By giftCard = By.xpath("//a[@href='/products/gift']");

	By sale = By.xpath("//li[@id='menu-L0-sale']/a");
	By saleMysteryBundles = By.xpath("//span[text()='On Sale']/../li/a[@href='/g/mystery-bundles' and text()='Mystery Bundles']");
	By saleBundles = By.xpath("//span[text()='On Sale']/../li/a[@href='/collections/tattoo-bundles-1' and text()='Bundles']");

	public void navigateToLoginSignUpPage() {
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(joinInkfam);
	}
	
	public void navigateToGiftCardPage() {
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(shop);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(giftCard);

	}

	public void navigateToSalesMysteryBox(){
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(sale);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(saleMysteryBundles);
	}


	public void navigateToSalesBundles(){
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(sale);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(saleBundles);
	}
}
