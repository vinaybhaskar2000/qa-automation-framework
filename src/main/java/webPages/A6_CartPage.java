package webPages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.BasePage;

public class A6_CartPage extends BasePage {

//--------------------------- Constructor---------------------------------

	public A6_CartPage(WebDriver driver) {
		super(driver);

	}

//--------------------------- Locators---------------------------------
	
	// Left Side Locators.

	private By yourCart_BannerProductTitle = By.xpath("//div[@class='cart-title-left']//h1");
	// private By productName = By.xpath("//div[@class='cart-item--content']//h2");

	private By productName = By.xpath("//h2[contains(@class,'cart-item')]");
	private By cartItemVendor = By.xpath("//div[@class='cart-item-vendor']//a");
	private By productVariantOptions = By.xpath("//div[@class='cart-item-product-options']");
	private By unitProductPrice = By.xpath("//div[@class='cart-item--content-price']");

	// QUANTITY BLOCK.

	// private By increaseQtyBtn =
	// By.xpath("//div[@class='quantity-selector__wrapper']//div[contains(@class,'quantity-selector__button-wrapper--plus')]");
	private By decreaseQtyBtn = By.xpath("//div[contains(@class,'quantity-selector__wrapper')]//div[contains(@class,'minus')]");
			

	private By qtyInput = By.xpath("//input[@class='quantity-selector__input']");

	// private By decreaseQtyBtn =
	// By.xpath("//div[@class='quantity-selector__wrapper']//div[@class='quantity-selector__button-wrapper
	// quantity-selector__button-wrapper--minus
	// quantity-selector__button-wrapper--disabled']");
	private By increaseQtyBtn = By .xpath("//div[contains(@class,'quantity-selector__wrapper')]//div[contains(@class,'plus')]");
			

	private By qtyBlockCartItemTotal = By.xpath("//div[@class='cart-item__total']//div");
	private By removeBtn = By.xpath("//div[@class='cart-item__remove']//a");
	private By yourCartIsEmptyMsg = By.xpath("//div[@class='cartitems-empty--inner']/p");

	// Right Side Locators.

	private By cartRightSideSubTotal = By.xpath("//div[@class='cart-title-right']//div[@class='cart-title-total--large']");
			
	private By cartRightSideCheckOutBtn = By.xpath("//div[@class='cart-title-right']//button[@name='checkout']");
	// private By headerCartCountVisible = By.xpath("//a[@class='site-header-cart--button']//span[@class='site-header-cart--countvisible']");
	
	// NO//private By headerCartCountVisible = By.xpath("//div[@class='site-header-right']//div[@class='site-header-cart']//a[@class='site-header-cart--button']//span[@class='site-header-cart--count visible']");
	private By headerCartCountVisible = By.xpath("//span[contains(@class,'site-header-cart--count')]");
	// WORKING// private By headerCartCountVisible = By.xpath("//span[@data-header-cart-count]");
	
	
	
	
	// Footer Locators.
	private By footerSubTotal = By.xpath("//div[@class='cart-subtotal']");
	private By footerCheckOutBtn = By.xpath("//div[@class='cart-total']//div[@class='cart-checkout']//button[@name='checkout']");
			
	// By checkoutBtn = By.xpath("//footer[@class='atc-banner--cart-footer']//form//button[@name='checkout']");

// --------------------------- Stock Message. Locators ---------------------------------

	private By stockMessageElement = By.xpath("//div[@class='message-banner--container message--error']//div[@class='message-banner--outer']/div[@class='message-banner--inner']");		
	private By stockMessageCloseBtn = By.xpath("//div[@class='message-banner--container message--error']//div[@class='message-banner--outer']//button[@type='button']");
			

// --------------------------- ReUsableMethods.---------------------------------

	protected WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String getPriceTest(By locator1, By locator2) {
		String a = waitForElementVisible(locator1).getText().trim();
		String b = waitForElementVisible(locator2).getText().trim();
		String c = a + " " + b;
		return c;

	}

	public String getCartPageURL() {
		return getCurrentURL();
	}

// --------------------------- Stock Message Methods..---------------------------------

	// Create a Private Helper.

	private WebElement getStockMessageElement() {
		return driver.findElement(stockMessageElement);
	}

	private WebElement getCloseButton() {
		return driver.findElement(stockMessageCloseBtn);
	}

	// Close Stock Mesage

	public void closeStockMessage() {
		waitForVisibilityOfElement(getCloseButton()).click();
	}
	
	// Is stock message displaying Before Upd ? displaying check.

		public boolean isStockMessageDisplayed_before() {

			WebElement ele = getStockMessageElement();
			return ele.isDisplayed();

			// return wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
			// wait.until(ExpectedConditions.visibilityOfElementLocated(stockMessageElement));

		}
	
	
	
	// Is stock message displaying? displaying check.

	public boolean isStockMessageDisplayed_upd() {

		WebElement ele = getStockMessageElement();
		return waitForVisibilityOfElement(ele).isDisplayed(); // we are using method from basePage

		// return wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(stockMessageElement));

	}

	// Get Stock Message.

	public String getstockMessage() {
		WebElement ele = getStockMessageElement();
		return waitForVisibilityOfElement(ele).getText(); // we are using method from basePage

		// return wait.until(ExpectedConditions.visibilityOf(ele)).getText();
	}

	// Get the vailable Stock Number.

	public int getAvailableStockNumber() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String stockMsg = getstockMessage();
		// Now get only availabele Stock Number.

		String stockNumber = stockMsg.replaceAll("\\D+", ""); // removes all Text
		// Now convert String to int, and we will return the same.
		int num = Integer.parseInt(stockNumber);
		return num;

	}

	// Disappear Check.

	public void waitForStockMessageToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(stockMessageElement));
	}

	// --------------------------- LEFT SIDE BLOCK / GETTERS ---------------------------------

		public String getYourCartHeadingText() {
			return waitForElementVisible(yourCart_BannerProductTitle).getText().trim();
		}

		public String getProductName() {
			return waitForElementVisible(productName).getText().trim();
		}

		public String getCartItemVendor() {
			return waitForElementVisible(cartItemVendor).getText().trim();
		}

		public String getSelectedProductVariantOption() {
			return waitForElementVisible(productVariantOptions).getText().trim();
		}

		public String totalPriceText() {
			return waitForElementVisible(unitProductPrice).getText().trim();
		}

	//----------------------------PRICING VALIDATIONS-----------------------
		
		// Getting Text/String 
		
		public String getOriginalPriceText()
		   {
			  
			   
			 WebElement originalPriceText  = driver.findElement(By.xpath("//span[text()='Original price']/following-sibling::s"));
			   return originalPriceText.getText().trim();
			   	
		   }
		
		   public String getCurrentPriceText()
		   {
			   WebElement currentPriceText  = driver.findElement(By.xpath("//span[text()='Current price']/following-sibling::span"));
				return currentPriceText.getText().trim();
		   }

		
		// Converting Text/String to Numbers to compare and calculate Qty*Price 
		   
		   public int getOriginalPriceValue_Numbers()
		   {
			  return   convertPriceToNumber(getOriginalPriceText());
		   }
		   
		   
		   public int getCurrentPriceValue_Numbers() {
			    return convertPriceToNumber(getCurrentPriceText());
			}
		   
		   
		   // Sub total Amount converting from String to Number.
		   
		   public int getCartSubtotal_Rightside_Numbers()
		   {
			   return convertPriceToNumber(getCartSubtotal_Rightsie());
		   }
		   
		   
		   
		 //Step 4: Extract Only Numbers.
		   public  int convertPriceToNumber(String priceText)
		   {
			   // Now, remove INR Symbol, spaces, Commas  and return only somple number.  
			   String a = priceText.replaceAll("[^0-9]", "");
			   int price =  Integer.parseInt(a);
			   return price;
		   }

		   
		   // validating Total Price
		   public String validateTotalPrice(int quantity) {

			    int currentPrice = getCurrentPriceValue_Numbers();
			    int expectedTotal = currentPrice * quantity;
			    int actualTotal = getCartSubtotal_Rightside_Numbers();

			    if (actualTotal == expectedTotal) {
			        return "PASS: Total price is correct";
			    } else {
			        return "FAIL: Expected " + expectedTotal + " but found " + actualTotal;
			    }
			}
		
// --------------------------- CART -------------------------------------

	/*
	 * This Method is used to: Get / View the No.of Items in Cart.
	 */
	
	/*
	public int getHeaderCartCount() {
		try {
		WebElement cart = driver.findElement(headerCartCountVisible);
		String count = cart.getDomAttribute("data-header-cart-count");
		// String count = waitForVisibilityOfElement(ele).getText();
		int noOfProdcutsInCart = Integer.parseInt(count); // Converting from String to int.
		return noOfProdcutsInCart;
		}
		catch(NoSuchElementException e)
		{
			return 0;
		}
	}
	
	*/
	
	public int getHeaderCartCount_upd() {
		
		List<WebElement> cart = driver.findElements(headerCartCountVisible);
		
		if (cart.isEmpty()) 
		{
			return 0;
		}
		
		String count = cart.get(0).getDomAttribute("data-header-cart-count");
		
		if (count == null || count.isEmpty()) 
		{
		  return 0;	
		}
		else
		{
			int num = Integer.parseInt(count);
			return num;
		}
		
		 
	
	}
	
	
// --------------------------- QUANTITY BLOCK---------------------------------

	// =========================
	// 🔹 QUANTITY METHODS
	// =========================

	// 🔹 1. Get Quantity

	public int getQuantity() {
		
		String noOfProductsCount = driver.findElement(qtyInput).getDomAttribute("value");
		// Converting from String to int, and returning the int.
		int productsCount = Integer.parseInt(noOfProductsCount);
		return productsCount;
	}

	// 🔹 2. Click Increase --> Click on Plus

	public void clickIncreaseQty_ClickPlus() {
		WebElement ele = driver.findElement(increaseQtyBtn);
		waitForVisibilityOfElement(ele).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 🔹 3. Click Decrease --> Click on Minus

	public void clickDecreaseQty_ClickMinus() {
		WebElement ele = driver.findElement(decreaseQtyBtn);
		waitForVisibilityOfElement(ele).click();
	}

	/*
	 * // 🔹 4. Enetr Quantity
	 * 
	 * public void enterquantity(String qty) { WebElement ele =
	 * driver.findElement(qtyInput); ele.clear(); ele.sendKeys(qty); }
	 * 
	 */

	// 🔹 6. Enter Quantity (Manual Input)

	public void enterQty(int qty) {
		WebElement input = driver.findElement(qtyInput);
		//input.clear();  ---> here clear is not working hence doing following steps.
		input.click();
		input.sendKeys(Keys.CONTROL+"a");
		input.sendKeys(Keys.BACK_SPACE);
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		input.sendKeys(String.valueOf(qty));
		input.sendKeys(Keys.TAB);
		
	//	wait.until(ExpectedConditions.attributeToBe(cartItemVendor, getCartPageURL(), getCartItemVendor()))
	//	wait.until(ExpectedConditions.attributeToBe(qtyInput, "value", String.valueOf(qty)));
	//	String noOfProductsCount = driver.findElement(qtyInput).getDomAttribute("value");
		
		
	//	int expectedQty = Math.min(qty, getQuantity());
	//	waitForQtyUpdate(expectedQty);

	}
	
	

	// 🔹 4. Wait for Quantity Update
	
	
	public String getQtyUpdatedInputValue()
	{
		String noOfProductsCount = driver.findElement(qtyInput).getDomAttribute("value");
		return noOfProductsCount;
	}
	
	
	public void waitForQtyUpdate(int expectedqty) {
		
		
		String chnageExpectedqtyFromIntToString = String.valueOf(expectedqty);
		wait.until(ExpectedConditions.attributeToBe(qtyInput, "value", chnageExpectedqtyFromIntToString));
	}

	// 🔹 5. Update Quantity (Using Buttons)

	public void updateQuantity(int expectedQty) {

		if (expectedQty < 1) {
			throw new IllegalArgumentException("Quanty cannot be less than 1");
		}

		// int attempts = 0;
		// while(currentQty < expectedQty && attempts < 10)
		int currentQty = getQuantity();

		while (currentQty < expectedQty) {
			clickIncreaseQty_ClickPlus();
			waitForQtyUpdate(currentQty + 1);
			currentQty = getQuantity();
		}

		while (currentQty > expectedQty) {
			clickDecreaseQty_ClickMinus();
			waitForQtyUpdate(currentQty - 1);
			currentQty = getQuantity();
		}

	}

	// 🔹 7. Validate Minus Button Disabled

	public boolean isMinusButtonDisplabled() {
		boolean c = driver.findElement(decreaseQtyBtn).getDomAttribute("class").contains("disabled");
		return c;
	}

	// 🔹 8. Get Total Price in Quantity Block.

	public String getItemTotalPrice_QuantityBlock() {
		return driver.findElement(qtyBlockCartItemTotal).getText();
	}

	// 🔹 9. Click on Remove X Button.

	public String clickOnXButton_At_QuantityBlock() {
		driver.findElement(removeBtn).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(yourCartIsEmptyMsg));
		return yourCartIsEmptyMsg();
	}

	// 🔹 10. Your Cart is Empty msg Method.

	public String yourCartIsEmptyMsg() {
		return driver.findElement(yourCartIsEmptyMsg).getText();
	}

// --------------------------- RIGHT SIDE BLOCK---------------------------------		

	// Click on Checkout Button at Rightside.
	
	/*
	 // This method is no longer valid because Checkout page is changed to Razorpay UI. 16 04 2026
	 
	public A7_CheckOutPage clickOnCheckoutBtn_RightSide() {
		driver.findElement(cartRightSideCheckOutBtn).click();
		return new A7_CheckOutPage(driver);
	}
	
	*/
	
	
//------------------------changes in code----------------------------------
	
	/*
	 * There are 2 scenarios. 
	 * 
	 * 1. clickOnCheckoutBtn_RightSide() --> method does not return any thing.
	 * 2. clickOnCheckoutBtn_RightSide() --> method returns A8_RazorpayPage
	 * 
	 */
	
	/*
	
	// OLD CODE, KEEP IT LIKE THAT.
	
	// updating return page to RazorPage UI.
	public A8_RazorpayPage clickOnCheckoutBtn_RightSide() {
		driver.findElement(cartRightSideCheckOutBtn).click();
		return new A8_RazorpayPage(driver);
	}

	*/
	
	
//------------------------ New Code -----------------
	
	// We are clicking on Checkout button thats all. Not returning any thing.
	
	public void clickOnCheckoutBtn_RightSide() {
		driver.findElement(cartRightSideCheckOutBtn).click();
		
	}
	
	
	// Case 2: We can return A8_RazorpayPage, but with wait.
	//	✅ Cleaner approach (recommended later)
	//	You can still return — but with wait:
	
	
	public A8_RazorpayPage clickOnCheckoutBtn_RightSide1() {
		
		driver.findElement(cartRightSideCheckOutBtn).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src,'razorpay')]")));
		return new A8_RazorpayPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	// Get (or) View the Sub Total Amount in Right Side Section / Block.

	public String getCartSubtotal_Rightsie() {
		return driver.findElement(cartRightSideSubTotal).getText();
	}

// --------------------------- FOOTER SECTION---------------------------------	

	// Click on Checkout Button at Footer.

	public A7_CheckOutPage clickOnCheckoutBtn_Footer() {
		driver.findElement(footerCheckOutBtn).click();
		return new A7_CheckOutPage(driver);
	}

	// Get (or) View the Sub Total Amount in Footer Section.

	public String getFooterSubTotal() {
		return driver.findElement(footerSubTotal).getText();
	}

// --------------------------- SUB TOTAL. Locators ---------------------------------

	private By yourCartSubTotalTop = By.xpath("//div[@class='cart-title-right']//div[@class='cart-title-total--large']");		
	private By qtyBlockSubTotalMiddle = By.xpath("//div[@class='cart-item__total']//div");
	private By footerSubTotalDown = By.xpath("//div[@class='cart-subtotal']");

	public String validateSubTotals() {
		// Step 1: Capture elements

		WebElement topSubtotal = driver.findElement(yourCartSubTotalTop);
		WebElement middleSubtotal = driver.findElement(qtyBlockSubTotalMiddle);
		WebElement footerSubtotal = driver.findElement(footerSubTotalDown);

		// Step 2: Get values

		String topValue = topSubtotal.getText();
		String middleValue = middleSubtotal.getText();
		String footerValue = footerSubtotal.getText();

		// Step 3: Clean values (remove ₹, commas, etc.)

		String top = topValue.replaceAll("[^0-9.]", "");
		String middle = middleValue.replaceAll("[^0-9.]", "");
		String footer = footerValue.replaceAll("[^0-9.]", "");

		// Step 4: Compare
		if (top.equals(middle) && middle.equals(footer)) {
			return "All subtotals are matching ✅";
		} else {
			return "Mismatch in subtotals ❌";

		}

	}

// --------------------------- SUB TOTAL. Comparision ended. ---------------------------------	

// --------------------------- Handle PopUp. ---------------------------------	

	public void handlePopupIfPresent() {

		try {

			List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@id,'popup-iframe')]"));

			if (!iframes.isEmpty()) {
				driver.switchTo().frame(iframes.get(0));
				List<WebElement> closeBtn = driver.findElements(By.cssSelector(".u-close-button"));

				if (!closeBtn.isEmpty()) {
					closeBtn.get(0).click();
				}

				driver.switchTo().defaultContent();
			}

		}

		catch (Exception e) {
			driver.switchTo().defaultContent();
		}

	}
	
	
	
//-----------------------------------------------------------------------------------------------------------
	
	
	
		
		public void closePopup() {
			
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    boolean clicked = false;

		    // Check main page (-1) and all iframes
		    for (int i = -1; i < iframes.size(); i++) {
		        if (i == -1) driver.switchTo().defaultContent();
		        else driver.switchTo().frame(iframes.get(i));

		        // Find all spans in popup header
		        List<WebElement> closeButtons = driver.findElements(By.xpath("//div[contains(@class,'u-popup-header')]//span[1]"));

		        for (WebElement btn : closeButtons) {
		            if (btn.isDisplayed()) { // only visible one
		                try {
		                    btn.click(); // normal click
		                } catch (Exception e) {
		                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn); // fallback
		                }
		                System.out.println("Popup closed successfully in iframe index: " + i);
		                clicked = true;
		                break; // stop after clicking
		            }
		        }

		        driver.switchTo().defaultContent(); // always switch back

		        if (clicked) break; // popup is closed, stop looping
		    }

		    if (!clicked) {
		        System.out.println("No visible popup found!");
		    }
		}


		
		// HOW TO USE THIS?
		
		/*
		 * 
		WebDriver driver = new ChromeDriver();
		driver.get("https://glenindia.com/");

		// Call this **first thing after page loads**
		closePopup(driver);

		// After this, all other actions like search box, pagination, etc. will work
		
		*/


}
