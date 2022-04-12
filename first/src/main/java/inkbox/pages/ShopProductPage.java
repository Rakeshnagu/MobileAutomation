package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class ShopProductPage {

	By productList = By.xpath("//li[@class='ais-Hits-item']/a"); // list containing all product

	public void clickFirstProduct() {
		Utilities.click(productList, 0);
	}

}
