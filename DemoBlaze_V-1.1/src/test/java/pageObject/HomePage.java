package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

// locator
	@FindBy(xpath = "//div[@id='navbarExample']/ul/li[1]/a")
	WebElement lnkhome;

	@FindBy(linkText = "Contact")
	WebElement lnkcontact;

	@FindBy(linkText = "About us")
	WebElement lnkaboutUs;

	@FindBy(linkText = "Cart")
	WebElement lnkcart;

	@FindBy(linkText = "Log in")
	WebElement lnklogIn;

	@FindBy(linkText = "Sign up")
	WebElement lnksignUp;

	@FindBy(xpath = "//span[@class='carousel-control-prev-icon']")
	WebElement btnPrevious;

	@FindBy(xpath = "//span[@class=\"carousel-control-next-icon\"]")
	WebElement btnNext;

	@FindBy(xpath = "//a[normalize-space()='Phones']")
	WebElement phones;

	@FindBy(xpath = "//a[normalize-space()='Laptops']")
	WebElement laptops;

	@FindBy(xpath = "//a[normalize-space()='Monitors']")
	WebElement monitors;

	@FindBy(xpath = "//div[@id='tbodyid']/div[\"+a+\"]/div/div/h4/a")
	WebElement lnkproduct;

	@FindBy(xpath = "//*[@id='tbodyid']/div[1]//h4/a")
	WebElement oneproduct;

	@FindBy(xpath = "//a[normalize-space()='Add to cart']")
	WebElement addToCart;

//  action method
	public void click_on_SignUp_link() {
		lnksignUp.click();
	}

	public void click_on_Login_link() {

		lnklogIn.click();
	}

	public void click_on_Home_link() {
		lnkhome.click();
	}

	public void click_on_Contact_link() {

		lnkcontact.click();
	}

	public void click_on_Cart_link() {
		lnkcart.click();
	}

	// select categories
	/*
	 * public void select_Categories(String categories) {
	 * 
	 * switch (categories) { case "phones": phones.click(); break; case "laptops":
	 * laptops.click(); break; case "monitors": monitors.click(); break; } }
	 * 
	 * //click on phone category public void click_on_phone_category() {
	 * addToCart.click();
	 * 
	 * }
	 */
	// add to cart
	public void click_on_add_to_cart() {
		addToCart.click();

	}

	public void add_To_Cart_All_Product() throws InterruptedException {

		// locate the all product available in home page
		List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"tbodyid\"]/div/div/div/h4/a"));
		int lnks = links.size();

		// only 2 product add /if all product add a <= lnks
		for (int a = 1; a <= 2; a++) {

			// locate individual product
			WebElement individual_pct_lnk = driver
					.findElement(By.xpath("//div[@id='tbodyid']/div[" + a + "]/div/div/h4/a"));

			// individual_pct_lnk.click();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(individual_pct_lnk)).click();
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				System.out.println(e);
			}
			// click on add to cart
			try {
				wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				System.out.println(e);
			}

			// alert =======Product added.
			try {
				driver.switchTo().alert().accept();

			} catch (Exception e) {
				e.printStackTrace();
			}

			// click on home
			driver.navigate().to("https://www.demoblaze.com/");
			/*
			try {
				wait.until(ExpectedConditions.elementToBeClickable(lnkhome)).click();
				}
				catch(org.openqa.selenium.StaleElementReferenceException e) {
					System.out.println(e);
					
				}
			*/

		}
	}

}
