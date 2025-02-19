package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Login;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Login_TestDDT extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class,groups= {"DataProvider"}) // getting data provider from different
																				// class
	public void verify_Login_with_DDT(String uname, String pword, String exp) throws InterruptedException {
		logger.info("****************** Strating TC003_Login_TestDDT ********************");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.click_on_Login_link();
			logger.info("***** Click on Login Link *****");
			// login pop up
			Login lp = new Login(driver);
			lp.enter_Username(uname);
			logger.info("***** Entered Username *****");
			lp.enter_Password(pword);
			logger.info("***** Entered Password  *****");
			lp.click_on_Login();
			logger.info("***** Click on Login Button *****");
			Thread.sleep(3000);
			boolean lnkLogout = lp.logout_link_display();

			if (exp.equalsIgnoreCase("valid")) {

				if (lnkLogout == true) {
					logger.info("***** User is Logined succesfully *****");
					try {
						lp.click_on_Logout();
						logger.info("***** Click on Logout Link *****");
						Assert.assertTrue(true);
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					logger.info("***** Test is Failed *****");
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {

				if (lnkLogout == true) {
					logger.info("***** User is Logined Succesfully *****");

					lp.click_on_Logout();
					Assert.assertTrue(true);

				} else {
					try {
						Alert a = driver.switchTo().alert();
						logger.info("***** Alert is Accepted *****");

						a.accept();

					} catch (NoAlertPresentException e) {
						System.out.println(e);
					}

					Thread.sleep(2000);
					lp.click_on_Close();
					logger.info("***** click on close button of pop up *****");
					logger.info("***** Test is Fialed *****");

					Assert.assertTrue(false);

				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****************** Finished TC003_Login_TestDDT ********************");

	}
}
