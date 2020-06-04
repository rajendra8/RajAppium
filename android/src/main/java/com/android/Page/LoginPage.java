package com.android.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.Base.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {

	private AndroidDriver<MobileElement> driver;

	@AndroidFindBy(uiAutomator = "text(\"Already a member? Login\")")
	public MobileElement Already_A_Member_Login;

	@AndroidFindBy(uiAutomator = "text(\"Sign in with Email\")")
	public MobileElement SignInWithEmail;

	@AndroidFindBy(id = "com.healthifyme.basic:id/et_username")
	public MobileElement EnterEmailId;

	@AndroidFindBy(id = "com.healthifyme.basic:id/et_password")
	public MobileElement EnterPassWord;

	@AndroidFindBy(id = "com.healthifyme.basic:id/btn_login_signup")
	public MobileElement LOGIN;

	@AndroidFindBy(uiAutomator = "text(\"LOGIN\")")
	public MobileElement WelComeBackAlert;

	public LoginPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 30);
	}

	public boolean isDisplayed() throws Exception {

		return Already_A_Member_Login.isDisplayed();
	}

	public void Already_Login() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Already_A_Member_Login.click();
	}

	public void LoginWithEmailAdress() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (SignInWithEmail.isDisplayed())
			SignInWithEmail.click();
	}

	public void enterEmailid(String name) {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (EnterEmailId.isDisplayed())
			EnterEmailId.clear();
		EnterEmailId.sendKeys(name);
	}

	public void enterPassword(String password) {
		if (EnterPassWord.isDisplayed())
			EnterPassWord.clear();
		EnterPassWord.sendKeys(password);
	}

	public void clickLogin() {
		if (LOGIN.isDisplayed())
			LOGIN.click();
	}

	// public void hideKeyboardIfVisible() {
	// if (keyboard != null) {
	// driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
	// }
	// }
	public void login(String name, String password) {
		// hideKeyboardIfVisible();
		enterEmailid(name);
		enterPassword(password);
		clickLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void acceptAlert() {
		if (WelComeBackAlert.isDisplayed())
			WelComeBackAlert.click();
	}

}