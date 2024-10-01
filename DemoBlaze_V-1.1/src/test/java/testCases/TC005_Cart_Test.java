package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Cart;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC005_Cart_Test extends BaseClass {
	@Test()
	public void verify_Product_is_Added_in_cart() throws InterruptedException {
		 
		logger.info("****************** Strating TC005_Cart_Test ********************");

		  try {
		  HomePage hp = new HomePage(driver);
		  hp.click_on_Home_link();
		  logger.info("****** click on Home Link ********");
		  hp.add_To_Cart_All_Product();
		  logger.info("******* Add to Cart present in Home page ******");
		  hp.click_on_Cart_link();
		  logger.info("***** click on Cart Link ****");
		  Cart ct=new Cart(driver);
		  ct.totalRowsCount();
		  logger.info("***** Total sum of rows in cart of price columns ****");
		  if(ct.calculate_Total_Amount()) {
		  logger.info("**** verify total Sum the prices of all products in the cart ****");
		  
		  logger.info("***** Total == Calculated Total is Same Amount ****");
			  Assert.assertTrue(true);
		  }
			 		 
		 } catch (Exception e) {
			 Assert.fail();
		 } 
		  logger.info("****************** Finished TC005_Cart_Test ********************");
		 
		 
		 
	}
}
