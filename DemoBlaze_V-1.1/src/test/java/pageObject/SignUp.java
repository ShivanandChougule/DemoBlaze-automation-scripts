package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp extends BasePage {

	//Contractor
	public SignUp(WebDriver driver) {
		super(driver);
	}
	
	//locator of sign up 
	@FindBy(xpath="//input[@id='sign-username']")  WebElement txtUsername;
    @FindBy(xpath="//input[@id='sign-password']") WebElement txtPassword;
    @FindBy(xpath="//button[normalize-space()='Sign up']")  WebElement btnSignUp;
    
    
    
    //action method for sign up
    public void enter_Username(String uname) {
    	txtUsername.sendKeys(uname);
    }
    
    public void enter_Password(String pword) {
    	txtPassword.sendKeys(pword);
    }
    	
    public void click_on_SignUp() {
    	btnSignUp.click();
    
    }
    
    

	
}
