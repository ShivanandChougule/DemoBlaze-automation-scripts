package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends BasePage {

	public Login(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='loginusername']")
	WebElement txtUsername;
	@FindBy(xpath = "//input[@id='loginpassword']")
	WebElement txtPassword;
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement btnLogIn;

	@FindBy(xpath = "//button[normalize-space()='Log in']/preceding-sibling::button")
	WebElement btnClose;

	@FindBy(id = "logout2")
	WebElement lnklogOut;

	public void enter_Username(String username) {
		txtUsername.sendKeys(username);
	}

	public void enter_Password(String password) {
		txtPassword.sendKeys(password);
	}

	public void click_on_Login() {
		btnLogIn.click();
	}

	public void click_on_Close() {
		btnClose.click();
	}

	public void click_on_Logout() {
		if (lnklogOut.isDisplayed()) {
			lnklogOut.click();
		}

	}

	public boolean logout_link_display() {
		try {
			return (lnklogOut.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

}
