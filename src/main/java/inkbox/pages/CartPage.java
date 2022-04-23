package inkbox.pages;

import inkbox.wrapper.DriverManager;
import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class CartPage {

    By productName = By.xpath("//div[contains(@class,'cart-contents')]//div[contains(@class,'cart-itemName')]");
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

    By cartFirstProductValue = By.xpath("//div[contains(@class,'cart-contents')]//div[@class='font-bold']");
    By cartSubtotalValue = By.xpath("//span[@id='cart-subtotal-value']");
    By cartTotalValue = By.xpath("//span[@class='cart-total-value']");

    By increaseProductCount = By.xpath("//button[@id='cart-item-add']");
    By decreaseProductCount = By.xpath("//button[@id='cart-item-sub']");
    By productQuantity = By.xpath("//button[@id='cart-item-sub']/../div");

    By continueToCheckout = By.xpath("//a[@id='cart-checkout-button-main']");

    public String getCartFirstProductValue() {return Utilities.getText(cartFirstProductValue);}

    public String getCartSubtotalValue() {return Utilities.getText(cartSubtotalValue);}

    public String getCartTotalValue() {return Utilities.getText(cartTotalValue);}

    public String getProductName() { return Utilities.getText(productName);}

    public void clickContinueToCheckout() { Utilities.click(continueToCheckout);}

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Number of product in cart " +  Utilities.getListSize(removeItemFromCart));
        /*for (int i = Utilities.getListSize(removeItemFromCart); i > 0; i--) {
            DriverManager.getWebdriver().findElements(removeItemFromCart).get(i - 1).click();
        }*/
        while(Utilities.getListSize(removeItemFromCart)!=0) {
            DriverManager.getWebdriver().findElements(removeItemFromCart).get(0).click();
        }
        System.out.println("Number of product in cart " +  Utilities.getListSize(removeItemFromCart));

    }

    public void closeCart(){
        Utilities.click(closeCart);
    }

    public void increaseProductCount(){
        Utilities.click(increaseProductCount);
        Utilities.sleep(1000);
    }

    public void decreaseProductCount(){
        Utilities.click(decreaseProductCount);
        Utilities.sleep(1000);
    }
}
