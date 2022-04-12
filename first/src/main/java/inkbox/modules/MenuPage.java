package inkbox.modules;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class MenuPage {

	By shop = By.xpath("//a[normalize-space()='Shop']");
	By tattooMaker = By.xpath("//a[@href='/freehand-tattoo-marker']");
	By menuList = By.xpath("//div[@id='nav-links']/div/a"); //starting menu with index 1
	
	
	public void clickShopMenu() {
		Utilities.click(shop);
	}

	public void clickTattooMaker() {
		Utilities.click(tattooMaker);
	}
}