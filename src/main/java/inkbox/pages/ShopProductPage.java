package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class ShopProductPage {

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

}
