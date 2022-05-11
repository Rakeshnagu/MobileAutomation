package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseClass {

    // Searching on Empty search box
    @Test(retryAnalyzer = RetryListener.class)
    public void C5076_EmptySearchBox_Validation() {
        search.typeInSearchBox("");
        Assert.assertTrue(search.Verify_Emptysearch(), "User has been navigated to wrong page");
    }

    //Enter random text in searchbox and click enter Validate 'Sorry, no results found for' message
    @Test(retryAnalyzer = RetryListener.class, description = "SearchBox No Results Found validation")
    public void C5013_SearchBox_NoResultsFound_validation() {
        search.typeInSearchBox("ABCDEFGGHIJKGDRUKLM");
        Assert.assertTrue(search.validateErrorMessage(),"'Sorry, no results found for' message didnt come");
    }

    // Verifying Popular Search is visible or not under Searchbox for guest user.
    @Test(retryAnalyzer = RetryListener.class,description = " Verifying Popular Search is visible or not under Searchbox for guest user.")
    public void C5065_PopularSearches_validation_Guestuser() {
        Assert.assertTrue(search.verifyPopularSearchIsPresentOrNot()," Popular Search is visible not under Searchbox");
    }

    // Verifying search result
    @Test(retryAnalyzer = RetryListener.class,description = "Verifying search result")
    public void C5077_SearchResults_Validation() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(search.verifySearchResult("flowers"),"Unable to find flowers Search item");
        softAssert.assertTrue(search.verifySearchResult("Inserts"),"Unable to find Inserts Search item");
        softAssert.assertTrue(search.verifySearchResult("Quotes"),"Unable to find Quotes Search item");
        softAssert.assertTrue(search.verifySearchResult("Artist"),"Unable to find Artist Search item");
        softAssert.assertAll();
    }


}
