package inkbox.modules;

import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchProduct {

    By searchInputField = By.xpath("//input[@id='search-field-input']");

    public void a(){
        Utilities.type(searchInputField,"sddssdsd");
        DriverManager.getWebdriver().findElement(searchInputField).sendKeys(Keys.ENTER);
    }
}