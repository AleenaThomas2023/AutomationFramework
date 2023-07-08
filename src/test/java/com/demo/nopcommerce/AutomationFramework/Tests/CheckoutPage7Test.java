package com.demo.nopcommerce.AutomationFramework.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.nopcommerce.AutomationFramework.Pages.ApplMacBookPro13inchPage5;
import com.demo.nopcommerce.AutomationFramework.Pages.CheckoutPage7;

import com.demo.nopcommerce.AutomationFramework.Pages.LoginPage3;
import com.demo.nopcommerce.AutomationFramework.Pages.NotebooksPage4;
import com.demo.nopcommerce.AutomationFramework.Pages.StorePage1;
import com.demo.nopcommerce.AutomationFramework.Pages.WishListPage;
import com.demo.nopcommerce.AutomationFramework.Utils.Utils;
import com.demo.nopcommerce.AutomationFramework.Pages.RegisterPage2;
import com.demo.nopcommerce.AutomationFramework.Pages.ShoppingCartPage6;
import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class CheckoutPage7Test extends TestBase {

	private StorePage1 storePage1;
	private RegisterPage2 registerPage2;
	private LoginPage3 loginPage3;

	private NotebooksPage4 noteBooks4;
	private ApplMacBookPro13inchPage5 macBook5;
	private ShoppingCartPage6 shoppingCart6;
	private CheckoutPage7 checkOut7;
	private WishListPage wishlist;

	private String email;
	private String password;

	@BeforeMethod
	public void setup() {

		initialisation();

		storePage1 = new StorePage1();
		registerPage2 = new RegisterPage2();
		loginPage3 = new LoginPage3();
		// computer4 = new ComputersPage4();
		noteBooks4 = new NotebooksPage4();
		macBook5 = new ApplMacBookPro13inchPage5();
		shoppingCart6 = new ShoppingCartPage6();
		checkOut7 = new CheckoutPage7();
		wishlist = new WishListPage();

	}

	@Test
	public void validateRegistration() {
		storePage1.clickRegisterButton();
		registerPage2.performRegister();

		// registerPage2.getYourRegistrationCompletedText();
		Assert.assertEquals(registerPage2.getYourRegistrationCompletedText(), "Your registration completed",
				"Registration Unsuccessful");
		email = registerPage2.getGeneratedEmail();
		password = registerPage2.getGeneratedPassword();
		// registerPage2.clickContinueButton();
	}

	@Test(dependsOnMethods = "validateRegistration")
	public void validateLogin() {

		storePage1.clickLoginButton();

		loginPage3.performLogin(email, password);
		Assert.assertEquals(loginPage3.welcomeToOurStoreText(), "Welcome to our store");

	}

	@Test(dependsOnMethods = "validateLogin")
	public void validateOrderSuccessfully() {

		storePage1.selectMac();
		// computer4.clickNoteBookButton();
		macBook5 = noteBooks4.clickAddToCartButton();
		macBook5.addToCartDetails();
		shoppingCart6.clickTermsOfService();

		loginPage3 = shoppingCart6.clickCheckoutButton();
		loginPage3.performLogin(email, password);
		shoppingCart6.clickTermsOfService();
		shoppingCart6.clickCheckoutButton();
		checkOut7.clickBillingAddressTitle();
		checkOut7.shippingDetails();
		checkOut7.cardDetails();
		Assert.assertEquals(checkOut7.getOrderSuccessfulText(), "Your order has been successfully processed!");
	}

	@Test
	public void validateWishList() {

		storePage1.selectMac();
		noteBooks4.clickAppleMacLink();
		macBook5.clickAddToWishLIst();
		wishlist = macBook5.clickWishLIstButton();
		Assert.assertEquals(wishlist.getwishlistAppleMacLinkText(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void validateFeaturedProducts() {
		// Assert that the featured products section is displayed
		Assert.assertTrue(storePage1.isFeaturedProductSectionDisplayed(),
				"Featured products section is not displayed.");

		storePage1.printProductTitles();
	}

	@AfterMethod
	public void quit() {
		tearDown();

	}
}
