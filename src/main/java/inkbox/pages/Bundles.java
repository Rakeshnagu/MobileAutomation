package inkbox.pages;

import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Bundles {
    final static Logger logger = Logger.getLogger(Bundles.class);

    By productList = By.xpath("//div[contains(@class,'section-collection')]/div/div[contains(@class,'product')]/div"); // list containing all product

    public void clickFirstProduct() {
        logger.info("clicking first product from budles page");
        Utilities.click(productList, 1);
    }
}
