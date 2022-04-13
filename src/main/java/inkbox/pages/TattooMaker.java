package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class TattooMaker {

	By addToCart = By.xpath("//button[contains(@onclick,'addProductToCart_0')]");
	By tracingPenProduct = By.xpath("//p[text()='Tracing Pen']/../img");

	public void addProductToCart() {
		Utilities.javascriptClick(addToCart);
	}

	public void clickTracingPenProduct() {
		Utilities.click(tracingPenProduct);
	}
}