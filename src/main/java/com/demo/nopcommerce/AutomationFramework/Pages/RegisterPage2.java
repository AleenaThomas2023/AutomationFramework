package com.demo.nopcommerce.AutomationFramework.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class RegisterPage2 extends TestBase {

	public RegisterPage2() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#gender-female")
	private WebElement genderRadioButton;

	@FindBy(css = "#FirstName")
	private WebElement firstNameInputField;

	@FindBy(css = "#LastName")
	private WebElement lastNameInputField;

	@FindBy(css = "#Email")
	private WebElement emailInputField;

	@FindBy(css = "#Password")
	private WebElement passwordInputField;

	@FindBy(css = "#ConfirmPassword")
	private WebElement confirmPasswordInputField;

	@FindBy(css = "#register-button")
	private WebElement registerButton;

	@FindBy(xpath = "//div[text()='Your registration completed']")
	private WebElement yourRegistrationCompletedText;

	@FindBy(css = "div.buttons a")
	private WebElement continueButton;

	private String generatedEmail;
	private String generatedPassword;

	public void clickGenderRadioButton() {
		genderRadioButton.click();
	}

	public void enterRegistrationDetails() {
		String firstName = RandomStringUtils.randomAlphanumeric(8);
		String lastName = RandomStringUtils.randomAlphanumeric(8);
		generatedEmail = generateRandomEmail();
		generatedPassword = RandomStringUtils.randomAlphanumeric(10);
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.sendKeys(lastName);
		emailInputField.sendKeys(generatedEmail);
		passwordInputField.sendKeys(generatedPassword);
		confirmPasswordInputField.sendKeys(generatedPassword);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	public String getYourRegistrationCompletedText() {
		return yourRegistrationCompletedText.getText();
	}

	public StorePage1 clickContinueButton() {
		continueButton.click();
		return new StorePage1();
	}

	public void performRegister() {
		clickGenderRadioButton();
		enterRegistrationDetails();
		clickRegisterButton();
	}

	public String generateRandomEmail() {
		String username = RandomStringUtils.randomAlphanumeric(10);
		String domain = RandomStringUtils.randomAlphabetic(5) + ".com";
		return username + "@" + domain;
	}

	public String getGeneratedEmail() {
		return generatedEmail;
	}

	public String getGeneratedPassword() {
		return generatedPassword;
	}
	
	
}
