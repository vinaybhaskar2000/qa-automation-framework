package actualTests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePage.BasePage;
import components.A3_CartPopupComponent;
import webPages.A5_ProductDetailsPage;

public class A5_ProductDetailsPageTest extends A1_BaseTest {

	

	@Test
	public void verifyUserCanSelectVariantAndAddToCart()
	{
		A5_ProductDetailsPage pdp = new A5_ProductDetailsPage(driver);
		
		// Step 1: Validate PDP is loaded
		
		Assert.assertTrue(pdp.isProductTitleDisplayed(),"Title is not visible");
		Assert.assertTrue(pdp.isProductPriceDisplayed(),"Price is not visible");
		
		// Step 2: Validate Variant Drop Down
		Assert.assertTrue(pdp.isVariantAvailable(),"Variant dropdown not available");
		
		// Printing of all Variants
		List<String> ele =   pdp.getAllOptions();
		for(String f : ele)
		{
			System.out.println(f);
		}
		
		// Step 3: Select Variant
		String variantToSelect = "76cm";
		pdp.selectVariant(variantToSelect);
		
		
	    // Step 4: Validate selected variant
		 String selectedVariant = pdp.getSelectedVariant();
		 Assert.assertEquals(selectedVariant,variantToSelect,"Variant not selected properly");
		
		 // Step 5: Capture price before adding
		 String price = pdp.getProductPrice();
		 System.out.println("Price: " + price);
		
		 
		// Step 6: Add to cart
		boolean cart =  pdp.isAddToCartButtonEnabled();
		Assert.assertTrue(cart, "Add to Cart disabled");
		
		// Step 7: Cart Popup Component validations.
		
		// Verify popupComponent is displaying or not, with a Text.
		A3_CartPopupComponent popUp = pdp.clickAddToCart();
		String text = popUp.getAddedToYourCartText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Added to your cart"));
		
		// Verifying: Product Name.
		String productNameText = popUp.getProductName();
		System.out.println(productNameText);
	//	Assert.assertTrue(productNameText.contains("Chimney"));
		Assert.assertTrue(productNameText.contains(pdp.getProductTitle()));
		
		
		// Verifying Product Details Price Text
		String productDetailsPriceText = popUp.getProductDetailsPriceText();
		System.out.println(productDetailsPriceText);
		Assert.assertTrue(productDetailsPriceText.contains(price),"Price mismatch between PDP and popup");
		
		
		// Verifying: View Cart and Product Count in it.
		String viewCartButtonVCount = popUp.getViewCartButtonText();
		System.out.println(viewCartButtonVCount);
		
		
		// Verifying Cart Sub Total
		String cartSubTotalText = popUp.getCartSubTotalText();
		System.out.println(cartSubTotalText);
		
		 
	}
	

}
