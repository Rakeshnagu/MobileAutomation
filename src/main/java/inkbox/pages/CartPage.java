package inkbox.pages;

import org.openqa.selenium.By;

import inkbox.wrapper.Utilities;

public class CartPage {

	By productName = By
			.xpath("//div[contains(@class,'cart-contents')]/div/div/div/div[contains(@class,'cart-itemName')]");
	By cartItemCount = By.xpath("//div[contains(@class,'cart-item flex')]");

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
}
