package inkbox.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import inkbox.modules.HamburgerMenu;
import inkbox.modules.MenuPage;
import inkbox.pages.CartPage;
import inkbox.pages.ProductDisplayPage;
import inkbox.pages.ShopProductPage;
import inkbox.pages.TattooMaker;
import inkbox.wrapper.BaseClass;

public class CartTest extends BaseClass {

	String productName;

	@Test(enabled = false, description = "Adding product to cart from product display page")
	public void T18406_AddingProductsToCartFromPdpPage() {
		menuPage = new MenuPage();
		shopProductPage = new ShopProductPage();
		productDisplayPage = new ProductDisplayPage();
		cartPage = new CartPage();

		menuPage.clickShopMenu();
		shopProductPage.clickFirstProduct();

		productName = productDisplayPage.getProductName();
		productDisplayPage.addProductToCart();

		Assert.assertEquals(cartPage.getProductName(), productName,	"Product name on product display page is not matching with cart");
		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
	}

	@Test(enabled = false, description = "Add free hand tattoo to cart from tattoo maker menu as a Guest user")
	public void T18416_AddFreehandInkToCartAsGuestUser() {
		menuPage = new MenuPage();
		tattooMaker = new TattooMaker();
		cartPage = new CartPage();

		menuPage.clickTattooMaker();

		tattooMaker.addProductToCart();
		productName = "Freehand Tattoo Marker";

		Assert.assertEquals(cartPage.getProductName(), productName,
				"Product name on product display page is not matching with cart");
		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
	}

	@Test(enabled = false, description = "Validating payement method is displayed in cart ")
	public void C4902_DisplayAvailablePaymentMethodsInCart() {
		menuPage = new MenuPage();
		shopProductPage = new ShopProductPage();
		productDisplayPage = new ProductDisplayPage();
		cartPage = new CartPage();

		menuPage.clickShopMenu();
		shopProductPage.clickFirstProduct();

		productName = productDisplayPage.getProductName();
		productDisplayPage.addProductToCart();

		Assert.assertTrue(cartPage.checkPaypalPaymentExist(),"Paypal payment doesnt exist on cart");
		Assert.assertTrue(cartPage.checkGooglePayPaymentExist(),"Google pay payment doesnt exist on cart");
		Assert.assertTrue(cartPage.checkapplePayPaymentExist(),"Apple pay payment doesnt exist on cart");
		Assert.assertTrue(cartPage.checkSezzlePaymentPaymentExist(),"Sezzle payment doesnt exist on cart");
		Assert.assertTrue(cartPage.checkAfterPayPaymentPaymentExist(),"After pay payment doesnt exist on cart");
	}

	
	@Test(enabled = false, description = "Adding gift card to cart ")
	public void C4928_AddGiftcardToCart() {
		hamburgerMenu = new HamburgerMenu();
		productDisplayPage = new ProductDisplayPage();
		cartPage = new CartPage();

		hamburgerMenu.navigateToGiftCardPage();
		productName = productDisplayPage.getProductName();
		productDisplayPage.addProductToCart();

		Assert.assertEquals(cartPage.getProductName(), productName,	"Product name on product display page is not matching with cart");
		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Number of item in cart expected is 1");
				
	}


}