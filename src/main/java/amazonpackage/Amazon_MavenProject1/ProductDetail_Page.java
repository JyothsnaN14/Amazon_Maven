package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductDetail_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductDetail_Page(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='corePriceDisplay_desktop_feature_div']/descendant::span[@class='a-price-whole']")
	private WebElement productprice;
	
	public void verifyproductprice() {
		wait.until(ExpectedConditions.visibilityOf(productprice));
		Assert.assertEquals(productprice.isDisplayed(), true);
	}
	@FindBy(xpath="//div[@id='productDescription']")
	private WebElement productdescription;
	
	public void verifyproductdescription() {
		wait.until(ExpectedConditions.visibilityOf(productdescription));
		Assert.assertEquals(productdescription.isDisplayed(), true);
	}
	@FindBy(xpath="//div[@id='customerReviews']")
	private WebElement Customerreviewsection;
	
	public void verifyCustomerreviewsection() {
		wait.until(ExpectedConditions.visibilityOf(Customerreviewsection));
		Assert.assertEquals(Customerreviewsection.isDisplayed(), true);
	}
	@FindBy(xpath="//span[text()='Add to Cart']/preceding-sibling::input")
	private WebElement AddtoCartbutton;
	public void clickonAddtoCartbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(AddtoCartbutton));
		AddtoCartbutton.click();

}
	@FindBy(xpath="//div[@class='a-box a-alert-inline a-alert-inline-success sw-atc-message']/following-sibling::h1")
	private WebElement addedtocartmsg;
	
	public void verifyaddedtocartmsg() {
		wait.until(ExpectedConditions.visibilityOf(addedtocartmsg));
		Assert.assertEquals(addedtocartmsg.isDisplayed(), true);
	}
	@FindBy(xpath="//button/child::span[@class='a-icon a-icon-small-trash']")
	private WebElement deletebutton;
	public void clickondeletebutton() {
		wait.until(ExpectedConditions.elementToBeClickable(deletebutton));
		deletebutton.click();

}
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement cartcount;
	public int verifyProductscount() {
		int productscount=Integer.parseInt(cartcount.getText());
		return productscount;
		
	}
	@FindBy(xpath="//button/child::span[@class='a-icon a-icon-small-add']")
	private WebElement addbutton;
	public void clickonaddbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(addbutton));
		addbutton.click();

}
	@FindBy(xpath="//button/child::span[@class='a-icon a-icon-small-remove']")
	private WebElement removebutton;
	public void clickonremovebutton() {
		wait.until(ExpectedConditions.elementToBeClickable(removebutton));
		removebutton.click();

}
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement proceedtobuybutton;
	public void clickonproceedtobuybutton() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedtobuybutton));
		proceedtobuybutton.click();

}
	@FindBy(xpath="//span[@id='sw-gtc']/child::span/child::a[contains(text(),'Go to Cart')]")
	private WebElement GoTOCartButton;
	public void clickonGoTOCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(GoTOCartButton));
		GoTOCartButton.click();

}

	}
	
