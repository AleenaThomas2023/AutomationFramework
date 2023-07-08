package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class ShoppingCartPage6 extends TestBase {

	public ShoppingCartPage6() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input#termsofservice")
	WebElement termsOfServiceCheckbox;

	@FindBy(css = "button.button-1.checkout-button")
	WebElement checkoutButton;

	public void clickTermsOfService() {
		termsOfServiceCheckbox.click();
	

	}

	public   LoginPage3 clickCheckoutButton() {
		checkoutButton.click(); // return page 7
		return new LoginPage3();
	}

}