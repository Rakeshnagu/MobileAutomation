package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseClass {

    @Test(retryAnalyzer= RetryListner.class, enabled = true, description = "Verify Item Added To Favourites Guest user")
    public void C5019_Verify_ItemAddedToFavourites_GuestUser(){
        menuPage.clickShopMenu();
        shopProductPage.addProductToFavouritesList();

        Assert.assertTrue(loginSignUpPage.checkSignUpPopUpAppearing(), "SignUp popup is not displaying after clicking Favourites");

    }

}
