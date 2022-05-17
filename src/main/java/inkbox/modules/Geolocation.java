package inkbox.modules;

import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Geolocation {

    final static Logger logger = Logger.getLogger(Geolocation.class);

    By listOfCurrencies = By.xpath("(//span[@x-text='selectedCurrency'])[1]/../select/option");


    public void SelectGeoLocation(String LocationName) {
        logger.info("Setting geo location as : " + LocationName);
        Utilities.checkPageIsReady();
        Utilities.ScrollDown();
        Utilities.javascriptClick(By.xpath("(//span[@x-text='selectedCurrency'])[1]"));
        Utilities.javascriptClick(By.xpath("(//button/span[@x-text='selectedCurrency'])[1]/parent::button/following-sibling::div/ul/li/descendant::span[contains(text(),'" + LocationName + "')]"));
        Utilities.ScrollTop();
        Utilities.checkPageIsReady();
    }

    public void validateCurrencyGettingSelected(){
        for (int i = 0; i < Utilities.getListSize(listOfCurrencies); i++) {
            Utilities.checkPageIsReady();
            Utilities.ScrollDown();
            Utilities.javascriptClick(By.xpath("(//span[@x-text='selectedCurrency'])[1]"));
            Utilities.click(By.xpath("(//span[@x-text='selectedCurrency'])[1]/../../div//li"),i);

            Utilities.checkPageIsReady();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
