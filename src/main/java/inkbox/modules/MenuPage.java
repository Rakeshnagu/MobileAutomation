package inkbox.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class MenuPage {

	final static Logger logger = Logger.getLogger(MenuPage.class);

	By shop = By.xpath("//a[normalize-space()='SHOP']");
	By tattooMaker = By.xpath("//a[@href='/freehand-tattoo-marker']");
	By menuList = By.xpath("//div[@id='nav-links']/div/a"); //starting menu with index 1
	
	
	public void clickShopMenu() {
		Utilities.click(shop);
	}

	public void clickTattooMaker() {
		Utilities.click(tattooMaker);
	}
}