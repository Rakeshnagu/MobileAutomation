package inkbox.testcase;

import inkbox.pages.*;
import inkbox.wrapper.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import inkbox.modules.HamburgerMenu;
import inkbox.modules.MenuPage;

@Listeners({AllureListener.class})
public class CartTest extends BaseClass {

    String productName;

    @Test(description = "Adding product to cart from product display page")
    public void C4913_AddingProductsToCartFromPdpPage() {
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add free hand tattoo to cart from tattoo maker menu as a Guest user")
    public void C4926_AddFreehandInkToCartAsGuestUser() {
        menuPage.clickTattooMaker();

        tattooMaker.addProductToCart();
        productName = "Freehand Tattoo Marker";

        Assert.assertEquals(cartPage.getProductName(), productName,
                "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Validating payment method is displayed in cart ")
    public void C4902_DisplayAvailablePaymentMethodsInCart() {
        menuPage = new MenuPage();
        shopProductPage = new ShopProductPage();
        productDisplayPage = new ProductDisplayPage();
        cartPage = new CartPage();

        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertTrue(cartPage.checkPaypalPaymentExist(), "Paypal payment doesnt exist on cart");
        Assert.assertTrue(cartPage.checkGooglePayPaymentExist(), "Google pay payment doesnt exist on cart");
        Assert.assertTrue(cartPage.checkapplePayPaymentExist(), "Apple pay payment doesnt exist on cart");
        Assert.assertTrue(cartPage.checkSezzlePaymentPaymentExist(), "Sezzle payment doesnt exist on cart");
        Assert.assertTrue(cartPage.checkAfterPayPaymentPaymentExist(), "After pay payment doesnt exist on cart");
    }

    @Test(description = "Adding gift card to cart ")
    public void C4928_AddGiftCardToCart() {
        hamburgerMenu = new HamburgerMenu();
        productDisplayPage = new ProductDisplayPage();
        cartPage = new CartPage();

        hamburgerMenu.navigateToGiftCardPage();
        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }

    @Test(description = "Add free hand tattoo to cart from tattoo maker menu for logged in user")
    public void C4925_AddFreehandInkToCartAsLoggedInUser() {
        loginSignUpPage.loginToInkBox();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        menuPage.clickTattooMaker();
        tattooMaker.addProductToCart();
        productName = "Freehand Tattoo Marker";

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add mystery bundles to cart as logged in user")
    public void C4921_AddMysteryBundlesToCartForLoggedInUser() {
        loginSignUpPage.loginToInkBox();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        homePage.clickCartIcon();
        cartPage.emptyCart();
        cartPage.closeCart();

        hamburgerMenu.navigateToSalesMysteryBox();
        mysteryBundles.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }

    @Test(description = "Add mystery bundles to cart as guest user")
    public void C4922_AddMysteryBundlesToCartVerifyProductAddedOrNotAsGuestUser() {
        hamburgerMenu.navigateToSalesMysteryBox();
        mysteryBundles.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Verify bundle is getting added to cart as guest user")
    public void C4924_AddBundlesToCartVerifyProductAddedForGuestUser() {
        hamburgerMenu.navigateToSalesBundles();
        bundles.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add artist kit to cart as guest user")
    public void C5006_AddArtistKitToCartAsGuestUser() {
        hamburgerMenu.navigateToTattooMakerArtistKit();

        tattooMaker.addProductToCart();
        productName = "Freehand Tattoo Marker";

        Assert.assertEquals(cartPage.getProductName(), productName,
                "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add accessories to cart as guest user")
    public void C5008_AddAccessoriesToCartAsGuestUser() {
        hamburgerMenu.navigateToTattooMakerAccessories();

        tattooMaker.clickTracingPenProduct();
        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add accessories to cart as guest user")
    public void C4998_0ItemWhenCartIsEmpty() {
        //Check is cart empty
        homePage.clickCartIcon();
        Assert.assertTrue(cartPage.checkYouHaveNoItemsInYourCartTextPresent(), "You have no items in your cart not coming in cart");
        Assert.assertEquals(cartPage.totalItemInCart(), 0, "total item in cart is not zero");

        cartPage.closeCart();

        //Adding item to cart and removing item from cart
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

        cartPage.emptyCart();

        //Check is cart empty after removing product
        Assert.assertTrue(cartPage.checkYouHaveNoItemsInYourCartTextPresent(), "You have no items in your cart not coming in cart");
        Assert.assertEquals(cartPage.totalItemInCart(), 0, "total item in cart is not zero");
    }

    @Test(description = "Add Giftcard to cart as logged in user")
    public void C4927_AddGiftcardToCartAsLoggedInUser() {
        homePage.clickCartIcon();
        cartPage.emptyCart();
        cartPage.closeCart();

        hamburgerMenu.navigateToGiftCardPage();
        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }

    @Test(description = "Verify cart is getting empty")
    public void C4918_EmptyCart() {
        hamburgerMenu.navigateToGiftCardPage();
        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
        cartPage.emptyCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart is not empty");

        cartPage.closeCart();
        loginSignUpPage.loginToInkBox();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        menuPage.clickTattooMaker();
        tattooMaker.addProductToCart();
        productName = "Freehand Tattoo Marker";

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should not be  empty");

        cartPage.emptyCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart is not empty");


    }


    @Test(description = "Price validation")
    public void C4914_PriceValidation() {
        String price;
        menuPage.clickShopMenu();
        price = shopProductPage.getFirstProductPrice();
        shopProductPage.clickFirstProduct();

        Assert.assertEquals(productDisplayPage.getProductPrice(), price, "price of item not matching from shop page and product page");

        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getCartFirstProductValue(), price, "price of product is different in cart from product page");
        Assert.assertEquals(cartPage.getCartSubtotalValue(), price, "price of product is different in cart from product page");
        Assert.assertEquals(cartPage.getCartTotalValue(), price, "price of product is different in cart from product page");


    }

    @Test(description = "verifying SubTotal,Total and Continue_To_Checkout visibility after product added to cart")
    public void C4917_AddToCartVerifyingSubTotalTotalAndContinueToCheckout() {
        String price;
        menuPage.clickShopMenu();
        price = shopProductPage.getFirstProductPrice();
        shopProductPage.clickFirstProduct();

        Assert.assertEquals(productDisplayPage.getProductPrice(), price, "price of item not matching from shop page and product page");

        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getCartFirstProductValue(), price, "price of product is different in cart from product page");
        Assert.assertEquals(cartPage.getCartSubtotalValue(), price, "price of product is different in cart from product page");
        Assert.assertEquals(cartPage.getCartTotalValue(), price, "price of product is different in cart from product page");

        cartPage.clickContinueToCheckout();

        Assert.assertTrue(Utilities.getCurrentUrl().contains("checkouts"), "After click on ContinueToCheckout button, it's redirecting to wrong page");

    }

    @Test(description = "Increment items in cart")
    public void C4993_IncrementItemsInCart() {
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();
        productDisplayPage.addProductToCart();

        cartPage.increaseProductCount();
        cartPage.increaseProductCount();
        cartPage.increaseProductCount();
        cartPage.increaseProductCount();

        Assert.assertEquals(cartPage.totalItemInCart(), 5, "product count has not increased");

        cartPage.closeCart();
        menuPage.clickShopMenu();
        shopProductPage.clickProduct(1);
        productDisplayPage.addProductToCart();
        Assert.assertEquals(cartPage.totalItemInCart(), 6, "product count has not increased");

    }

    @Test(description = "Decrement items in cart")
    public void C4994_DecrementItemsInCart() {
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();
        productDisplayPage.addProductToCart();

        cartPage.increaseProductCount();
        cartPage.increaseProductCount();
        cartPage.increaseProductCount();
        cartPage.increaseProductCount();

        Assert.assertEquals(cartPage.totalItemInCart(), 5, "product count has not increased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 4, "product count has not decreased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 3, "product count has not decreased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 2, "product count has not decreased");

        cartPage.closeCart();
        menuPage.clickShopMenu();
        shopProductPage.clickProduct(1);
        productDisplayPage.addProductToCart();
        Assert.assertEquals(cartPage.totalItemInCart(), 3, "product count has not increased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 2, "product count has not decreased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 1, "product count has not decreased");

        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.totalItemInCart(), 0, "product count has not decreased");
    }

    @Test(description = "C4992 Add products to cart from wishlist")
    public void C4992_AddProductsToCartFromWishlist() {

        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();
        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        homePage.clickWishListIcon();

        if (!wishList.checkProductExistInWistList()) {
            menuPage.clickShopMenu();
            shopProductPage.addProductToFavouritesList();
            homePage.clickWishListIcon();
        }

        String productName = wishList.getProductName(0);
        System.out.println(productName);
        wishList.addProductToCart(0);

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }


    @Test(description = "Add artist kit to cart as logged in user")
    public void C5005_AddArtistKitToCartAsLoggedInUser() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();

        homePage.clickCartIcon();
        cartPage.emptyCart();
        cartPage.closeCart();

        hamburgerMenu.navigateToTattooMakerArtistKit();

        tattooMaker.addProductToCart();
        productName = "Freehand Tattoo Marker";

        Assert.assertEquals(cartPage.getProductName(), productName,
                "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Add accessories to cart as logged in user")
    public void C5007_AddAccessoriesToCartAsLoggedInUser() {
        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();

        homePage.clickCartIcon();
        cartPage.emptyCart();
        cartPage.closeCart();

        hamburgerMenu.navigateToTattooMakerAccessories();

        tattooMaker.clickTracingPenProduct();
        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
    }

    @Test(description = "Remove items from cart")
    public void C4931_RemoveItemsFromCart() {

        //Adding item to cart and removing item from cart
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

        cartPage.emptyCart();

        //Check is cart empty after removing product
        Assert.assertTrue(cartPage.checkYouHaveNoItemsInYourCartTextPresent(), "You have no items in your cart not coming in cart");
        Assert.assertEquals(cartPage.totalItemInCart(), 0, "total item in cart is not zero");


    }

    @Test(description = "Add Items To cart")
    public void C4934_AddItemsToCart() {

        //Adding item to cart and removing item from cart
        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

        cartPage.closeCart();

        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }

    @Test(description = "Add Items To Cart without Login and Validate After Login")
    public void C4933_AddItemsToCart_without_Login_and_ValidateAfterLogin() {

        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

        cartPage.closeCart();

        hamburgerMenu.navigateToLoginSignUpPage();
        loginSignUpPage.enterLoginCredential();

        Assert.assertTrue(homePage.checkLoginSuccessfully(), "Login was not successful");

        homePage.clickCartIcon();
        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

    }


    @Test(description = "Validate product name, price, size & actual price with PDP")
    public void C5015_ValidateProduct_NamePriceSze() {

        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();

        productName = productDisplayPage.getProductName();
        String price = productDisplayPage.getProductPrice();

        productDisplayPage.addProductToCart();

        Assert.assertEquals(productDisplayPage.getProductPrice(), price, "price of item not matching from shop page and product page");
        Assert.assertEquals(cartPage.getProductName(), productName, "Product name on product display page is not matching with cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");


    }

    @Test(description = "Quantity chosen in PDP must match the no. of items in cart for that product")
    public void C5010_QuantityChosenInPDPMustMatchTheNoOfItemsInCart() {

        menuPage.clickShopMenu();
        shopProductPage.clickFirstProduct();
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");

        cartPage.closeCart();

        Utilities.navigateBack();

        shopProductPage.clickProduct(2);
        productDisplayPage.addProductToCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Number of item in cart expected is 1");
    }

    @Test(description = "Verify discount meter is displayed and appropriate discounts are displayed")
    public void C4996_VerifyDiscountMeterIsDisplayedAndAppropriateDiscountsAreDisplayed() {
        DriverManager.getWebdriver().get(Utilities.readPropertyFile("url")+"/products/all-tattoos");

        shopProductPage.clickProduct(1);
        productDisplayPage.addProductToCart();


    }


    @Test(description = "Confirm tattoo size is the same in cart & pdp")
    public void C5081_ConfirmTattooSizeIsSameInCartPDP() {
        DriverManager.getWebdriver().get(Utilities.readPropertyFile("url")+"/products/all-tattoos?size=1_x_1_in");
        shopProductPage.clickProduct(0);

        String size = productDisplayPage.getProductSize();
        productDisplayPage.addProductToCart();
        Utilities.checkPageIsReady();
        System.out.println(size);
        System.out.println(cartPage.getProductSize());
        Assert.assertTrue(cartPage.getProductSize().trim().replace(" ","").contains(size.trim().replace(" ","")));

    }
}