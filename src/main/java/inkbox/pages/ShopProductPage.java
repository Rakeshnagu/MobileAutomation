package inkbox.pages;

import inkbox.modules.WishList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class ShopProductPage {
    final static Logger logger = Logger.getLogger(ShopProductPage.class);

    By productList = By.xpath("//li[@class='ais-Hits-item']/a"); // list containing all product
    By productPriceList = By.xpath("//li[@class='ais-Hits-item']/a//div[contains(@class,'productCard-price')]");
    By favouritesList = By.xpath("//li[@class='ais-Hits-item']/a//button[@type='submit']");

    public void clickFirstProduct() {
        Utilities.click(productList, 0);
    }

    public void clickProduct(int productposition) {
        Utilities.click(productList, productposition);
    }
    public String getFirstProductPrice() {
        return Utilities.getText(productPriceList);
    }

    public void addProductToFavouritesList() { Utilities.click(favouritesList, 0); }
    public void addProductToFavouritesList(int index) { Utilities.click(favouritesList, index); }

}
