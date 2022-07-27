package inkbox.testcase;

import inkbox.wrapper.AllureListener;
import inkbox.wrapper.BaseClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class BrowseTest extends BaseClass {


    @Test(description = "Sort By prixe low to high")
    public void C5078_SortByPriceLowToHigh() {

        menuPage.clickShopMenu();
        sort.sortByLowToHigh();
        productDisplayPage.validatePriceLowToHigh();


    }

}