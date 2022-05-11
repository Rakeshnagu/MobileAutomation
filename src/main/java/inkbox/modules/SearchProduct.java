package inkbox.modules;

import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchProduct {

    final static Logger logger = Logger.getLogger(SearchProduct.class);

    By searchInputField = By.xpath("//input[@id='search-field-input']");
    By searchBar = By.xpath("//div[@id='search-field-container']");
    By errorMessage = By.xpath("//h1[contains(normalize-space(),'Sorry, no results found for')]");
    By popularSearchTitle = By.xpath("//div[@id='search-list']/div[@x-show='searchTitle']");
    By searchResultList = By.xpath("//div[@id='search-list']//a[contains(@aria-label,'View search results for')]");
    By searchResult = By.xpath("//h3[@class='text-xl font-bold leading-none']//span[contains(text(),'Results for \"')]");

    /*
    public void a() {
        Utilities.type(searchInputField, "sddssdsd");
        DriverManager.getWebdriver().findElement(searchInputField).sendKeys(Keys.ENTER);
    }
*/
    public void typeInSearchBox(String data) {
        Utilities.click(searchBar);
        Utilities.type(searchInputField, data);
        DriverManager.getWebdriver().findElement(searchInputField).sendKeys(Keys.ENTER);
    }

    public boolean Verify_Emptysearch() {
        String URL = Utilities.getCurrentUrl();
        if (URL.contains("products/all-tattoos")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateErrorMessage() {
        return Utilities.elementExist(errorMessage);
    }

    public boolean verifyPopularSearchIsPresentOrNot() {
        boolean blag = false;
        boolean blag1 = false;

        Utilities.click(searchBar);
        String SearchResults = Utilities.getText(popularSearchTitle);
        if (SearchResults.contains("Popular Searches")) {
            blag = true;
        } else {
            logger.error("FAILED Popular Searches text not visible");
        }
        if (Utilities.getListSize(searchResultList) > 0) {
            blag1 = true;
        } else {
            logger.error("FAILED Search not showing any result");
        }
        return blag & blag1;
    }

    public boolean verifySearchResult(String searchItem) {
        boolean blag = false;
        boolean blag1 = false;

        typeInSearchBox(searchItem);
        String searchText = Utilities.getText(searchResult);

        if (searchText.contains(searchItem) && Utilities.getCurrentUrl().contains(searchItem)) {
            blag = true;
        } else {
            logger.error("FAILED Popular Searches text not visible");
        }
        return blag;
    }


}