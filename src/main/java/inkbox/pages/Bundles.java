package inkbox.pages;

import inkbox.wrapper.Utilities;
import org.openqa.selenium.By;

public class Bundles {

    By productList = By.xpath("//div[contains(@class,'section-collection')]/div/div[contains(@class,'product')]/div"); // list containing all product

    public void clickFirstProduct() {
        Utilities.click(productList, 1);
    }
}
