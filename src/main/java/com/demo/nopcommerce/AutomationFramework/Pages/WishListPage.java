package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class WishListPage extends TestBase {

	public WishListPage()  {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//td[@class=\"product\"]/a[@class=\"product-name\"]")
	WebElement wishListProductAppleMac ;
	
	
	public String getwishlistAppleMacLinkText() {
		return wishListProductAppleMac.getText();
	}
}
