package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class ProductDisplayPage {

	By addToCart = By.xpath("//button[contains(@class,'btn btn-primary f')]");
	By productName = By.xpath("//h3[contains(@class,'font-heading f')]");
	By productPrice = By.xpath("//div[@class='font-bold font-body md:text-lg ']");

	public void addProductToCart() {
		Utilities.javascriptClick(addToCart);
		Utilities.sleep(1000);
	}

	public String getProductName() {
		return Utilities.getText(productName);
	}

	public String  getProductPrice() {
		return Utilities.getText(productPrice);
	}
}
