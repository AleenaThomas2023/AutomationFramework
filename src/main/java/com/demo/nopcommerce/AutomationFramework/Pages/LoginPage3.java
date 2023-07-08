package com.demo.nopcommerce.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class LoginPage3 extends TestBase {
	WebDriverWait wait;

	public LoginPage3() {
		PageFactory.initElements(wd, this);
		wait = new WebDriverWait(wd, 15);
	}

	@FindBy(css = "#Email")
	private WebElement emailInputField;

	@FindBy(css = "#Password")
	private WebElement passwordInputField;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//h2[text()='Welcome to our store']")
	private WebElement welcomeText;

	public void enterEmail(String email) {

		emailInputField.sendKeys(email);

	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String welcomeToOurStoreText() {

		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		return welcomeText.getText();

	}

	public StorePage1 performLogin(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		clickLoginButton();// return page1
		return new StorePage1();
	}

}
