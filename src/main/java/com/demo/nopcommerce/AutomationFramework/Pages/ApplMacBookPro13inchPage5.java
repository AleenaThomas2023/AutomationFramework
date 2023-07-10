package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class ApplMacBookPro13inchPage5 extends TestBase {

	public ApplMacBookPro13inchPage5() {

		PageFactory.initElements(wd, this);
	}
	
	

	@FindBy(css = "input#product_enteredQuantity_4")
	WebElement qtyInputField;

	@FindBy(css = "button#add-to-cart-button-4")
	WebElement addToCartButton;

	@FindBy(css = "p.content")
	WebElement successProdutAddedMessage;

	@FindBy(css = "span.close")
	WebElement closeButton;

	@FindBy(css = "span.cart-label")
	WebElement shoppingCartButton;

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListButton;

	@FindBy(css = "span.wishlist-label")
	WebElement wishListButton;

	public void enterQtyNotebook() {
		qtyInputField.sendKeys("2");

	}

	public void clickAddToCartButton() {
		addToCartButton.click();

	}

	public void clickAddToWishLIst() {
		addToWishListButton.click();
	}

	public WishListPage clickWishLIstButton() {
		wishListButton.click(); // return wishlistpage
		return new WishListPage();
	}

	// public String messageProductAddedToTheShoppingCart() {
	// return successProdutAddedMessage.getText();

	// }

//	public void clickcloseButton() {
//		closeButton.click();
//
//	}

	public ShoppingCartPage6 clickShoppingCartButton() {
		shoppingCartButton.click(); // return page6
		return new ShoppingCartPage6();
	}

	public void addToCartDetails() {
		enterQtyNotebook();
		clickAddToCartButton();
		// messageProductAddedToTheShoppingCart();
		// clickcloseButton();
		clickShoppingCartButton();

	}
}
