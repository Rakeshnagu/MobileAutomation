package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class ProductDisplayPage {

	By addToCart = By.xpath("//button[contains(@class,'btn btn-primary f')]");
	By productName = By.xpath("//h3[contains(@class,'font-heading f')]");

	public void addProductToCart() {
		Utilities.javascriptClick(addToCart);
	}

	public String getProductName() {
		return Utilities.getText(productName);
	}

}
