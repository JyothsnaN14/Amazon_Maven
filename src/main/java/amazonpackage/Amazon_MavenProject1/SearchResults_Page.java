package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResults_Page {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public SearchResults_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@role='listitem']/descendant::a/child::h2")
	private List<WebElement> searchresults;
	public void verifysearchresult() {
		wait.until(ExpectedConditions.visibilityOf(searchresults.get(0)));
		Assert.assertEquals(searchresults.get(0).getText().contains("Shoe"), true);
	}
	
	public void clickonfirstproduct() {
		wait.until(ExpectedConditions.visibilityOf(searchresults.get(0)));
		searchresults.get(0).click();
	}
	@FindBy(xpath="//div[@id='brandsRefinements']/descendant::a/child::span[@class='a-size-base a-color-base']")
	private List<WebElement> brandsfilters;
	@FindBy(xpath="//div[@id='brandsRefinements']/descendant::a/child::span[@class='a-size-base a-color-base a-text-bold']")
	private WebElement brandsfilterafterselecting;
	@FindBy(xpath="//div[@class='a-row a-size-base a-color-secondary']/child::h2/span")
	private List<WebElement> productbrandname;
	@FindBy(xpath="//span[text()='Clear']")
	private WebElement Clearbutton;
	public void verifyBrandFilters() throws InterruptedException {
		for(int i=0; i<3; i++) {
			wait.until(ExpectedConditions.visibilityOf(brandsfilters.get(i)));
			brandsfilters.get(i).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(brandsfilterafterselecting));
			wait.until(ExpectedConditions.visibilityOf(productbrandname.get(0)));
			Assert.assertEquals(brandsfilterafterselecting.getText(), productbrandname.get(0).getText());
			wait.until(ExpectedConditions.visibilityOf(Clearbutton));
			Clearbutton.click();
			Thread.sleep(3000);
		}
		
	}
	
	@FindBy(xpath="//div[@id='priceRefinements']/ul[@id='filter-p_36']/descendant::a/child::span")
	private List<WebElement> pricefilters;
	@FindBy(xpath="//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']/descendant::span[@class='a-price-whole']")
	private List<WebElement> productsprices;
	
	public String getProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(productsprices.get(0)));
		return productsprices.get(0).getText();
	}
	public void verifypricefilters() throws InterruptedException {
		int pricefilterscount=pricefilters.size();
		for(int i=0; i<pricefilterscount; i++) {
			wait.until(ExpectedConditions.visibilityOf(pricefilters.get(i)));
			pricefilters.get(i).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(pricefilters.get(i)));
			wait.until(ExpectedConditions.visibilityOf(productsprices.get(0)));
			int price=Integer.parseInt(productsprices.get(0).getText().replaceAll("[^0-9]",""));
			String filtertext=pricefilters.get(i).getText();
			if(filtertext.contains("Up to ")) {
				int firstfilterrange=Integer.parseInt(filtertext.replaceAll("[^0-9]",""));
				System.out.println(firstfilterrange);
				Assert.assertTrue(price<firstfilterrange);	
			}
			else if(filtertext.contains(" - ")) {
				String[] priceParts = filtertext.split(" - ");
				String minPriceText = priceParts[0].replaceAll("[^0-9]", ""); 
			    int filterRangeMin = Integer.parseInt(minPriceText);
			    String maxPriceText = priceParts[1].replaceAll("[^0-9]", ""); 
			    int filterRangeMax = Integer.parseInt(maxPriceText);
			    System.out.println("Min Range: " + filterRangeMin + ", Max Range: " + filterRangeMax);
			    Assert.assertTrue(price >= filterRangeMin && price <= filterRangeMax);
			}
			else if(filtertext.contains("Over ")) {
				int lastfilterrange=Integer.parseInt(filtertext.replaceAll("[^0-9]",""));		
				System.out.println(lastfilterrange);
				Assert.assertTrue(lastfilterrange<price);		
			}
			Clearbutton.click();
			Thread.sleep(3000);
			
			
}}
	@FindBy(xpath="//div[@role='listitem']/descendant::h2/child::span[@class='a-size-base-plus a-color-base']")
	private List<WebElement> productsbrands;
	@FindBy(xpath="//div[@role='listitem']/descendant::h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']/child::span")
	private List<WebElement> products;
//	public void printSortedProductsWithHashMap() {
//	    Map<String, String> productsMap = new HashMap<>();
//	    int countOfProducts = products.size();
//	    for (int i = 0; i < countOfProducts; i++) {
//	        String brandName = productsbrands.get(i).getText();
//	        String productName = products.get(i).getText();
//	        productsMap.put(brandName, productName);
//	    }
//	    List<String> sortedBrands = new ArrayList<>(productsMap.keySet());
//	    Collections.sort(sortedBrands);
//	    System.out.println("--- Products Sorted by Brand Name (Using HashMap & List Sort) ---");
//	    for (String brand : sortedBrands) {
//	        String product = productsMap.get(brand);
//	        System.out.println("Brand: **" + brand + "** | Product: " + product);
//	    }
//	}
	public void printAllSortedProducts() {
	    final String DELIMITER = "###UNIQUE_SEP###";
	    List<String> combinedProductList = new ArrayList<>();
	    int countOfProducts = products.size();
	    System.out.println("Number of Products:"+countOfProducts);  
	    for (int i = 0; i < countOfProducts; i++) {
	        String brandName = productsbrands.get(i).getText();
	        String productName = products.get(i).getText();
	        if (brandName == null || brandName.isEmpty()) brandName = "[No Brand]";
	        if (productName == null || productName.isEmpty()) productName = "[No Product]";
	        String combined = brandName + DELIMITER + productName;
	        combinedProductList.add(combined); 
	    }
	    Collections.sort(combinedProductList);
	    System.out.println("--- All Products (Including Duplicates) Sorted by Brand ---");
	    for (String combinedString : combinedProductList) {
	       String[] parts = combinedString.split(DELIMITER, 2); 
	        
	        String brand;
	        String product;
	        
	        if (parts.length == 2) {
	        	brand = parts[0];
	            product = parts[1];
	        } else {
	        	brand = parts[0]; 
	            product = "[ERROR: Split Failure]";
	        }
	        System.out.println("Brand: **" + brand + "** | Product: " + product);
	    }
	}
	@FindBy(xpath="//div[@role='listitem']/descendant::div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']/descendant::span[@class='a-price-whole']")
	private List<WebElement> prices;
	public void sortProductsByPrice() {
	    Map<String, String> sortedProductsByPrice = new TreeMap<>();
	    int count = products.size();
	    int counter = 0; 
	    final int PRICE_STRING_LENGTH = 7; 

	    for (int i = 0; i < count; i++) {
	        String productName = products.get(i).getText();
	        String priceText = prices.get(i).getText();
	        
	        String priceStrClean = priceText.replaceAll("[^0-9]", "");
	       if (priceStrClean.isEmpty()) {
	            priceStrClean = "9999999"; 
	        } else {
	            try {
	                Integer.parseInt(priceStrClean);
	            } catch (NumberFormatException e) {
	                priceStrClean = "9999999"; 
	            }
	        }
	       String paddedPrice = String.format("%0" + PRICE_STRING_LENGTH + "d", Long.parseLong(priceStrClean));
	       String uniqueKey = paddedPrice + "_" + counter;
	        
	        sortedProductsByPrice.put(uniqueKey, productName);
	        
	        counter++;
	    }
	    System.out.println("\n--- All Products Sorted by Price (Low to High) ---");
	    for (Map.Entry<String, String> entry : sortedProductsByPrice.entrySet()) {
	        String uniqueKey = entry.getKey();
	        String product = entry.getValue();
	        String rawPrice = uniqueKey.split("_")[0];
	        String price = rawPrice.replaceFirst("^0+(?!$)", ""); 
	        
	        System.out.println("Price: **₹" + price + "** | Product: " + product);
	    }
	}
	
	
	@FindBy(xpath="//div[@role='listitem']/descendant::span[@class='a-size-small a-color-base']")
	private List<WebElement> ratings;
	public void sortProductsByRatingDescending() {
	    // TreeMap with a custom Comparator to sort keys in REVERSE order (Highest to Lowest)
	    Map<String, String> sortedProductsByRating = new TreeMap<>(Collections.reverseOrder());
	    
	    int count = products.size();
	    int counter = 0;
	    // Assuming ratings are typically short (e.g., 5.0, 4.5, 4.0), a length of 5 is safe
	   // final int RATING_STRING_LENGTH = 5; 

	    for (int i = 0; i < count; i++) {
	        String productName = products.get(i).getText();
	        String ratingText = ratings.get(i).getText(); // e.g., "4.2 out of 5 stars" or just "4.2"
	        
	        // 1. Clean the rating string
	        // Remove non-numeric text and potentially truncate after the first number (e.g., get "4.2")
	        String cleanRatingStr = ratingText.replaceAll("[^0-9.]", "");
	        
	        // 2. Pad and format the rating for alphabetical sorting
	        String paddedRating;
	        try {
	            // Convert to a Double for consistent formatting
	            double ratingValue = Double.parseDouble(cleanRatingStr);
	            
	            // Format the number to a string, ensuring fixed length and padding
	            // "%5.2f" means 5 characters total, 2 digits after the decimal point
	            paddedRating = String.format("%5.2f", ratingValue).replace(" ", "0"); 
	        } catch (NumberFormatException e) {
	            // Assign a low rating value string if parsing fails (to push it to the end in reverse order)
	            paddedRating = "00.00"; 
	        }

	        // 3. Construct the Unique Key: [Padded Rating]_[Counter]
	        String uniqueKey = paddedRating + "_" + counter;
	        sortedProductsByRating.put(uniqueKey, productName);
	        
	        counter++;
	    }

	    // 4. Print the Sorted Results
	    System.out.println("--- Products Sorted by Rating (Highest to Lowest) ---");
	    for (Map.Entry<String, String> entry : sortedProductsByRating.entrySet()) {
	        String uniqueKey = entry.getKey();
	        String product = entry.getValue();
	        
	        // Extract the rating part and remove leading zeros/spaces for clean printing
	        String rawRating = uniqueKey.split("_")[0];
	        String rating = rawRating.replaceFirst("^0+", ""); 
	        
	        System.out.println("Rating: **" + rating + "** | Product: " + product);
	    }
	}
}
