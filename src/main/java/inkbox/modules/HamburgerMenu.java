package inkbox.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class HamburgerMenu {

	final static Logger logger = Logger.getLogger(HamburgerMenu.class);

	By hamburgerMenu = By.xpath("//div[@id='nav-hamburger']");
	By joinInkfam = By.xpath("//span[contains(normalize-space(),'Join The Inkfam')]");

	By shop = By.xpath("//li[@id='menu-L0-shop']/a");
	By giftCard = By.xpath("//a[@href='/products/gift']");

	By sale = By.xpath("//li[@id='menu-L0-sale']/a");
	By saleMysteryBundles = By.xpath("//span[text()='On Sale']/../li/a[@href='/g/mystery-bundles' and text()='Mystery Bundles']");
	By saleBundles = By.xpath("//span[text()='On Sale']/../li/a[@href='/collections/tattoo-bundles-1' and text()='Bundles']");

	By tattooMarker =By.xpath("//li[@id='menu-L0-tattoo-marker']/a");
	By tattooMarkerArtistKit = By.xpath("//div[@class='mm-panel mm-panel_opened']//span[text()='Tattoo Marker']/../li/a[text()='Artist Kit']");
	By tattooMarkerAccessories = By.xpath("//div[@class='mm-panel mm-panel_opened']//span[text()='Tattoo Marker']/../li/a[text()='Accessories']");

	By customs = By.xpath("//li[contains(@class,'menu-L0 list-cols-odd thumbs-2 mm-listitem')]/a");


	public void navigateToLoginSignUpPage() {
		Utilities.click(hamburgerMenu);
		Utilities.checkPageIsReady();
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

	public void navigateToTattooMakerArtistKit(){
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(tattooMarker);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(tattooMarkerArtistKit);
	}


	public void navigateToTattooMakerAccessories(){
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(tattooMarker);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(tattooMarkerAccessories);
		Utilities.checkPageIsReady();
	}

	public void navigateToQuiz(){
		Utilities.click(hamburgerMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.click(tattooMarker);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utilities.javascriptClick(tattooMarkerArtistKit);
	}

}