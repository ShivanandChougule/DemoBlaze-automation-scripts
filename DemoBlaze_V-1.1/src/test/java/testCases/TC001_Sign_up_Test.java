package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignUp;
import testBase.BaseClass;

public class TC001_Sign_up_Test extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verify_sign_up() throws InterruptedException {
		logger.info("****************** Strating TC001_Sign_up_Test ********************");

		try {
			HomePage hp = new HomePage(driver);
			hp.click_on_SignUp_link();
			logger.info("**** Click on Sign up link ***");

			SignUp sp = new SignUp(driver);

			sp.enter_Username(randomString().toUpperCase());
			logger.info("**** Entered Username ***");

			String password = randomAlpaNumberic();
			sp.enter_Password(password);
			logger.info("**** Entered Password ***");


			try {
				sp.click_on_SignUp();
				logger.info("**** Click on Sign up button ***");
				
				Alert a = driver.switchTo().alert();

				a.accept();
				logger.info("**** Alert is Accepted ***");

			} catch (NoAlertPresentException e) {
               e.printStackTrace();
			}
			logger.info("**** Sign up is Succesfully !!! ***");

			Assert.assertTrue(true);
		} catch (Exception e) {
			
			
			logger.info("**** Test is Failed ***");

			Assert.fail();
		}
		logger.info("****************** Finished TC001_Sign_up_Test ********************");

	}

}