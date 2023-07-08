package com.demo.nopcommerce.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class StorePage1 extends TestBase {
	private Actions actions;
	WebDriverWait wait;
	public StorePage1() {
		
		PageFactory.initElements(wd, this);
		
		actions = new Actions(wd);
	}

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerButton;

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement logInButton;
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutButton;

	@FindBy(css = "div.header-menu ul.top-menu.notmobile>li:first-of-type>a")
	WebElement computerMenu;

	@FindBy(css = "div.header-menu ul.top-menu.notmobile >li:first-of-type ul.sublist.first-level li:nth-of-type(2) >a")
	WebElement notebookLink;
	
	@FindBy(css = "div.product-grid")
    private WebElement featuredProductsSection;
	
	@FindBy(css = "div.item-grid h2.product-title")
    private List<WebElement> productTitles;

	public RegisterPage2 clickRegisterButton() {

		registerButton.click();

		return new RegisterPage2();
	}// return register page

	public LoginPage3 clickLoginButton() {

		logInButton.click();

		return new LoginPage3();// return login page3
	}

	public void clickLogOutButton() {

		logoutButton.click(); // return page1
	}

	public void clickComputerMenu() {
		actions.moveToElement(computerMenu).perform();
		//computerMenu.click();
	}

	public NotebooksPage4 clickNotebookLink() {

		actions.moveToElement(notebookLink).click().perform();// return page4

		return new NotebooksPage4();
	}

	public void selectMac() {
		clickComputerMenu();
		clickNotebookLink();
	}

	public boolean isFeaturedProductSectionDisplayed()  {
		return featuredProductsSection.isDisplayed();
	}
	public void printProductTitles() {
        for (WebElement productTitle : productTitles) {
            System.out.println(productTitle.getText());
        }
    }
}