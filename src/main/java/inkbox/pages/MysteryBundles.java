package inkbox.pages;

import inkbox.wrapper.Utilities;
import org.openqa.selenium.By;

public class MysteryBundles {

    By productList = By.xpath("//div[contains(@class,'product product-blocks')]/div"); // list containing all product

    public void clickFirstProduct() {
        Utilities.click(productList, 0);
    }
}
