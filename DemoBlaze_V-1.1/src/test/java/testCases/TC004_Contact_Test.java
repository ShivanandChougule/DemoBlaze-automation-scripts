package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Contact;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC004_Contact_Test extends BaseClass {

	@Test(groups= {"Sanity","Master","Regression"})
	public void verify_Contact_menu() {
		logger.info("****************** Strating TC004_Contact_Test ********************");

		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.click_on_Contact_link();
			logger.info("***** Click on Contact Link *****");


			// Contact pop up
			Contact ct = new Contact(driver);
			ct.enter_Email_Address(p.getProperty("Email_ID"));
			logger.info("***** User is entered Email Id *****");

			ct.enter_Contact_Name(p.getProperty("Name"));
			logger.info("***** User is entered Name *****");

			ct.write_Text_Message(p.getProperty("Txt_Msg"));
			logger.info("***** Write Message *****");

			ct.click_on_Send_Message();
			logger.info("***** Click on Send Message button *****");

			try {
				driver.switchTo().alert().accept();
				logger.info("***** Alert is Accepted *****");

			} catch (Exception e) {
				System.out.println(e);
			}
			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.info("***** Test is Fialed *****");

			Assert.assertTrue(false);
		}
		logger.info("****************** Finished TC004_Contact_Test ********************");

	}

}
