package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class NotebooksPage4 extends TestBase {

	public NotebooksPage4() {

		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "(//button[contains(text(), 'Add to cart')])[1]")
	WebElement addToCartButton;

	@FindBy(xpath = "//h2[contains(@class, 'product-title')]/a[contains(text(), 'Apple MacBook Pro 13-inch')]")
	WebElement appleMacBookLink;

	public ApplMacBookPro13inchPage5 clickAddToCartButton() {
		addToCartButton.click();// return page5
		return new ApplMacBookPro13inchPage5();
	}

	public void clickAppleMacLink() {
		appleMacBookLink.click(); //return page 5
	}
}
