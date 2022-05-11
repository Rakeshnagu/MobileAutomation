package inkbox.modules;

import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class WishList {

    final static Logger logger = Logger.getLogger(WishList.class);

    By productList = By.xpath("//button[@type='submit']");

    By addProductToCart = By.xpath("//div[@class='flex justify-between mt-4']//div//button[@aria-label='Add product to cart']");
    By productName = By.xpath("//div[contains(@class,'group-hover:text')]/div[contains(@class,'text-base')]");

    public boolean checkProductExistInWistList(){
        return Utilities.getListSize(productList) > 0 ? true : false;
    }

    public void addProductToCart(int index){
        Utilities.click(addProductToCart, index);
    }

    public String getProductName(int index) {
        return Utilities.getText(productName,index).trim();
    }
}
