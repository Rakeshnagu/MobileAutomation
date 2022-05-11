package inkbox.testcase;

import inkbox.wrapper.BaseClass;
import inkbox.wrapper.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseClass {

    @Test(retryAnalyzer= RetryListener.class, enabled = true, description = "Verify Item Added To Favourites Guest user")
    public void C5019_Verify_ItemAddedToFavourites_GuestUser(){
        menuPage.clickShopMenu();
        shopProductPage.addProductToFavouritesList();

        Assert.assertTrue(loginSignUpPage.checkSignUpPopUpAppearing(), "SignUp popup is not displaying after clicking Favourites");
    }


    @Test(retryAnalyzer= RetryListener.class, enabled = true, description = "Verify WishListvalidation")
    public void C4919_WishListvalidation(){
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();;

        menuPage.clickShopMenu();
        shopProductPage.addProductToFavouritesList(0);
        shopProductPage.addProductToFavouritesList(1);
        shopProductPage.addProductToFavouritesList(2);
        shopProductPage.addProductToFavouritesList(3);
        shopProductPage.addProductToFavouritesList(4);
    }
}
