package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class CheckoutPage7 extends TestBase {

	public CheckoutPage7() {
		
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//h2[text()='Billing address']")
	private WebElement billingAddressTitle;

	@FindBy(css = "#BillingNewAddress_CountryId")
	private WebElement countryDropDown;

	@FindBy(css = "#BillingNewAddress_StateProvinceId.c.valid")
	private WebElement stateDropDown;

	@FindBy(css = "#BillingNewAddress_City")
	private WebElement inputCityNameField;

	@FindBy(css = "#BillingNewAddress_Address1")
	private WebElement inputAddress1Field;

	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	private WebElement zipPostalCodeInputField;

	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	private WebElement phoneNumberInputField;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	private WebElement continueButton;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	private WebElement continueButtonShipping;

	@FindBy(css = "#paymentmethod_1")
	private WebElement creditCardRadioButton;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	private WebElement continueButtonPayment;

	@FindBy(css = "#CardholderName")
	private WebElement cardHolderNameInputField;
	@FindBy(css = "#CardNumber")
	WebElement cardHolderNumberInputField;

	@FindBy(css = "#ExpireMonth")
	private WebElement expireMonthDropDown;

	@FindBy(css = "#ExpireYear")
	private WebElement expireYearDropDown;

	@FindBy(css = "#CardCode")
	private WebElement cardCodeInputField;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	private WebElement continueButtonPaymentInfo;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	private WebElement confirmButton;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement orderSuccessfulText;
	
	public void clickBillingAddressTitle() {
        WebDriverWait wait = new WebDriverWait(wd,10); 
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressTitle)).click();
    }

	public void selectCountryDropDownByValue(String value) {
		Select countrySelect = new Select(countryDropDown);
		countrySelect.selectByValue(value);
	}

	public void selectStateDropDownByValue(String value) {
		Select stateSelect = new Select(stateDropDown);
		stateSelect.selectByValue(value);
	}

	public void enterRandomCityName() {
		String cityName = generateRandomString(8); // Generate a random string of length 8
		inputCityNameField.sendKeys(cityName);
	}

	public void enterRandomAddress() {
		String address = generateRandomString(10); // Generate a random string of length 10
		inputAddress1Field.sendKeys(address);
	}

	public void enterRandomPostalCode() {
		String postalCode = generateRandomString(6); // Generate a random string of length 6
		zipPostalCodeInputField.sendKeys(postalCode);
	}

	public void enterRandomPhoneNumber() {
		String phoneNumber = generateRandomNumericString(10); // Generate a random numeric string of length 10
		phoneNumberInputField.sendKeys(phoneNumber);
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public void clickContinueButtonShipping() {
		continueButtonShipping.click();
	}

	public void clickCreditCardRadioButton() {
		creditCardRadioButton.click();
	}

	public void clickContinueButtonPayment() {
		continueButtonPayment.click();
	}

	public void enterCardHolderName() {
		String cardHolderName = generateRandomString(8); // Generate a random string of length 8
		cardHolderNameInputField.sendKeys(cardHolderName);
	}

	public void enterCardHolderNumber() {

		cardHolderNumberInputField.sendKeys("4111111111111111");
	}

	public void selectExpireMonthByValue(String value) {
		Select expireMonthSelect = new Select(expireMonthDropDown);
		expireMonthSelect.selectByValue(value);
	}

	public void selectExpireYearByValue(String value) {
		Select expireYearSelect = new Select(expireYearDropDown);
		expireYearSelect.selectByValue(value);
	}

	public void enterRandomCardCode() {
		String cardCode = generateRandomNumericString(3); // Generate a random numeric string of length 3
		cardCodeInputField.sendKeys(cardCode);
	}

	public void clickContinueButtonPaymentInfo() {
		continueButtonPaymentInfo.click();
	}

	public void clickConfirmButton() {
		confirmButton.click();
	}

	public String getOrderSuccessfulText() {
		return orderSuccessfulText.getText();
	}

	public void shippingDetails() {
		selectCountryDropDownByValue("2");
	//	selectStateDropDownByValue("2");
		enterRandomCityName();
		enterRandomAddress();
		enterRandomPostalCode();
		enterRandomPhoneNumber();
		clickContinueButton();
		clickContinueButtonShipping();

	}

	public void cardDetails() {
		clickCreditCardRadioButton();
		clickContinueButtonPayment();
		enterCardHolderName();
		enterCardHolderNumber();
		//selectExpireMonthByValue("02");
		selectExpireYearByValue("2025");
		enterRandomCardCode();
		clickContinueButtonPaymentInfo();
		clickConfirmButton();
		getOrderSuccessfulText();

	}

	// Method to generate a random string of specified length
	private String generateRandomString(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

	// Method to generate a random numeric string of specified length
	private String generateRandomNumericString(int length) {
		String digits = "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * digits.length());
			sb.append(digits.charAt(index));
		}
		return sb.toString();
	}
}
