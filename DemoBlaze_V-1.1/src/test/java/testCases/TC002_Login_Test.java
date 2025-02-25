package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Login;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass {

	@Test(groups= {"Sanity","Master","Regression"})
	public void verify_login() {
		logger.info("****************** Strating TC002_Login_Test ********************");

		try {

			HomePage hp = new HomePage(driver);
			hp.click_on_Login_link();
			logger.info("***** Click on Login Link *****");

			Login lp = new Login(driver);
			lp.enter_Username(p.getProperty("username"));
			logger.info("***** Entered valid Username *****");
			lp.enter_Password(p.getProperty("password"));
			logger.info("***** Entered  valid Password *****");
			lp.click_on_Login();
			logger.info("***** Click on Login Button *****");
            try {
            	logger.info("***** User is Succesfully logined !! *****");
            	lp.click_on_Logout();
            	logger.info("***** Click on Logout Link *****");
            	Assert.assertTrue(true);
            }catch(Exception e) {
            	logger.info("***** Test is Failed *****");
    			Assert.assertTrue(false);
            }
		} catch (Exception e) {
			logger.info("***** Test is Failed *****");
			Assert.fail();
		}
		logger.info("****************** Finished TC002_Login_Test ********************");

	}

}
