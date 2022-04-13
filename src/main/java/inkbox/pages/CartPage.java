package inkbox.pages;

import inkbox.wrapper.DriverManager;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class CartPage {

    By productName = By.xpath("//div[contains(@class,'cart-contents')]/div/div/div/div[contains(@class,'cart-itemName')]");
    By cartItemCount = By.xpath("//div[contains(@class,'cart-item flex')]");

    By youHaveNoItemsInYourCartText = By.xpath("//h3[normalize-space()='You have no items in your cart']");
    By totalItemInCart = By.xpath("//span[@class='cart-item-count']");
    By removeItemFromCart = By.xpath("//div[contains(@class,'cart-item flex')]/descendant::div[text()='Remove']");
    By closeCart = By.xpath("//p[text()='Keep Shopping']");


    By paypalPayment = By.xpath("//img[@alt='Paypal']");
    By googlePayPayment = By.xpath("//img[@alt='Google Pay']");
    By applePayPayment = By.xpath("//img[@alt='Apple Pay']");
    By sezzlePayment = By.xpath("//img[@alt='Sezzle']");
    By afterPayPayment = By.xpath("//img[@alt='AfterPay']");

    public String getProductName() {
        return Utilities.getText(productName);
    }

    public int getCartItemCount() {
        return Utilities.getListSize(cartItemCount);
    }

    public boolean checkPaypalPaymentExist() {
        return Utilities.elementExist(paypalPayment);
    }

    public boolean checkGooglePayPaymentExist() {
        return Utilities.elementExist(googlePayPayment);
    }

    public boolean checkapplePayPaymentExist() {
        return Utilities.elementExist(applePayPayment);
    }

    public boolean checkSezzlePaymentPaymentExist() {
        return Utilities.elementExist(sezzlePayment);
    }

    public boolean checkAfterPayPaymentPaymentExist() {
        return Utilities.elementExist(afterPayPayment);
    }

    public boolean checkYouHaveNoItemsInYourCartTextPresent() {
        return Utilities.elementExist(youHaveNoItemsInYourCartText);
    }

    public int totalItemInCart() {
        return Integer.parseInt(Utilities.getText(totalItemInCart));// return count written on cart
    }

    public void emptyCart() {
        for (int i = Utilities.getListSize(removeItemFromCart); i > 0; i--) {
            DriverManager.getWebdriver().findElements(removeItemFromCart).get(i - 1).click();
        }
    }

    public void closeCart(){
        Utilities.click(closeCart);
    }
}
