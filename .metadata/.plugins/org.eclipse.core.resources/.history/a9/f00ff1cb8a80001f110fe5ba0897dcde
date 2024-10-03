package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {

	// contractor
	public Cart(WebDriver driver) {
		super(driver);
	}

	// locator

	@FindBy(xpath = "//*[@id='tbodyid']//tr[1]/td[3]")
	WebElement price;

	@FindBy(xpath = "//div[@class='panel-heading']//h3")
	WebElement total;

	// action method

	public int totalRowsCount() throws InterruptedException {
		Thread.sleep(2000);
		// locate total rows in table
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tbodyid']//tr"));
		int totalRows = rows.size();

		return totalRows;
	}

	public boolean calculate_Total_Amount() throws InterruptedException {

		int totalAmount = 0;
		int tRows = totalRowsCount();

		for (int r = 1; r <= tRows; r++) {

			// locate table price column individual price of product
			String text = driver.findElement(By.xpath("//*[@id='tbodyid']//tr[" + r + "]/td[3]")).getText();
			int price = Integer.parseInt(text);

			// calculate total price
			totalAmount += price;

		}
		int tAmt = totalAmount;

		// locate the Total Amount in cart page
		String total = driver.findElement(By.xpath("//div[@class='panel-heading']//h3")).getText();
		int amt = Integer.parseInt(total);
		// Compare the Total Amount and calculated total Amount
		if (amt == tAmt) {
			return true;
		} else {
			return false;
		}
	}
}