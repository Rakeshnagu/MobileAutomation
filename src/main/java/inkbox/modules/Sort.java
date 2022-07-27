package inkbox.modules;

import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Sort {

    final static Logger logger = Logger.getLogger(Sort.class);

    By sortBy =By.xpath("//button/div/*[text()='Sort By']");

    By priceHigh_low = By.xpath("//div[@role='menu']/ul/li/label/span[contains(text(),'Price: High - Low')]");
    By priceLow_High = By.xpath("//div[@role='menu']/ul/li/label/span[contains(text(),'Price: Low - High')]");


    public void sortByLowToHigh() {
        Utilities.checkPageIsReady();
        Utilities.click(sortBy);
        Utilities.click(priceLow_High);
    }

    public void sortByHighToLow() {
        Utilities.checkPageIsReady();
        Utilities.click(sortBy);
        Utilities.click(priceHigh_low);
    }

}