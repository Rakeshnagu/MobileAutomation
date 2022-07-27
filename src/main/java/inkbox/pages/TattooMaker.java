package inkbox.pages;

import inkbox.modules.WishList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class TattooMaker {
	final static Logger logger = Logger.getLogger(TattooMaker.class);

	By addToCart = By.xpath("//button[contains(@onclick,'addProductToCart_0')]");
	By tracingPenProduct = By.xpath("//div[normalize-space()='Tracing Pen']/..");

	public void addProductToCart() {
		logger.info("Adding product to cart");
		Utilities.javascriptClick(addToCart);
	}

	public void clickTracingPenProduct() {
		logger.info("clicking tracing pen product");
		Utilities.javascriptClick(tracingPenProduct);
		Utilities.checkPageIsReady();
	}
}