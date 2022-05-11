package inkbox.pages;

import inkbox.modules.WishList;
import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MysteryBundles {
    final static Logger logger = Logger.getLogger(MysteryBundles.class);

    By productList = By.xpath("//div[contains(@class,'product product-blocks')]/div"); // list containing all product

    public void clickFirstProduct() {
        Utilities.click(productList, 0);
    }
}
