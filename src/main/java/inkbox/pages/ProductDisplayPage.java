package inkbox.pages;

import inkbox.modules.WishList;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ProductDisplayPage {
    final static Logger logger = Logger.getLogger(ProductDisplayPage.class);

    By addToCart = By.xpath("//button[contains(@class,'btn btn-primary f')]");
    By productName = By.xpath("//h3[contains(@class,'font-heading f')]");
    By productPrice = By.xpath("//div[@class='font-bold font-body md:text-lg ']");
    By productSize = By.xpath("//h3[text()='Tattoo Canvas Size']/../p");
//	String product_price = "//div/descendant::button[@aria-label='Add product to cart']/parent::div/preceding-sibling::div/parent::div/descendant::div[contains(@class,'productCard-price')]";


    public void addProductToCart() {
        Utilities.javascriptClick(addToCart);
        Utilities.sleep(1000);
    }

    public String getProductName() {
        return Utilities.getText(productName);
    }

    public String getProductSize() {
        return Utilities.getText(productSize);
    }

    public String getProductPrice() {
        return Utilities.getText(productPrice);
    }


    public void validatePriceLowToHigh() {
        SoftAssert softAssert = new SoftAssert();
        Utilities.checkPageIsReady();

        ArrayList<Double> pricelist = new ArrayList<Double>();
        List<WebElement> products = Utilities.webElementList(By.xpath("//div/descendant::button[@aria-label='Add product to cart']/parent::div/preceding-sibling::div/parent::div/descendant::div[contains(@class,'productCard-price')]"));
        for (int i = 1; i < products.size(); i++) {
            int j = i + 1;
            System.out.println(products.get(i).getText());
            String path = products.get(i).getText();
            path = path.replace("$", "").replace("£", "").replace("€", "").replace("£", "").replace("USD", "")
                    .replace("CAD", "").replace("EUR", "").replace("AUD", "").replace("GBP", "");
            path = path.trim();
            System.out.println(path);
            double price = Double.parseDouble(path);
            pricelist.add(price);
        }
        int k = 0;
        for (int i = 0; i < pricelist.size() - 1; i++) {

            if (pricelist.get(i) >= pricelist.get(i + 1)) {
                // System.out.println("false :" + pricelist.get(i));
                k = 1;
                softAssert.fail(pricelist.get(i)+"Price is not Sorted by Low to High : " + pricelist.get(i + 1));
            }

        }

        if (k != 1) {
            logger.info("Able to sort by price low to high");
        }
        softAssert.assertAll();
    }
}
