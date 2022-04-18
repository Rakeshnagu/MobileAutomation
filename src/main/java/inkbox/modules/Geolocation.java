package inkbox.modules;

import inkbox.wrapper.Utilities;
import org.openqa.selenium.By;

public class Geolocation {

    public void SelectGeoLocation(String LocationName) {
        Utilities.checkPageIsReady();
        Utilities.ScrollDown();
        Utilities.javascriptClick(By.xpath("(//span[@x-text='selectedCurrency'])[1]"));
        Utilities.javascriptClick(By.xpath("(//button/span[@x-text='selectedCurrency'])[1]/parent::button/following-sibling::div/ul/li/descendant::span[contains(text(),'" + LocationName + "')]"));
        Utilities.ScrollTop();
        Utilities.checkPageIsReady();
    }
}
