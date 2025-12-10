package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkout_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public Checkout_Page(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Change')])[1]")
	private WebElement Address_Changebutton;
	public void clickAddress_Changebutton() {
		wait.until(ExpectedConditions.elementToBeClickable(Address_Changebutton));
		Address_Changebutton.click();
		}
	@FindBy(xpath="(//input/following-sibling::i)[3]")
	private WebElement thirdAddressRadioButton;
	public void clickthirdAddressRadioButton() {
		wait.until(ExpectedConditions.elementToBeClickable(thirdAddressRadioButton));
		thirdAddressRadioButton.click();
		}
	@FindBy(xpath="(//span[contains(text(),'Deliver to this address')]/preceding-sibling::input)[1]")
	private WebElement DeliveryToThisAddress;
	public void clickOnDeliveryToThisAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(DeliveryToThisAddress));
		DeliveryToThisAddress.click();
		}
	@FindBy(xpath="(//input/following-sibling::i/following::span[@class='a-text-bold'])[3]")
	private WebElement thirdAddressname;
	public String getthirdAddressname() {
		wait.until(ExpectedConditions.visibilityOf(thirdAddressname));
		return thirdAddressname.getText();
		}
	
	@FindBy(xpath="(//input/following-sibling::i/following::span[@class='a-text-bold'])[1]")
	private WebElement firstAddressname;
	public String getfirstAddressname() {
		wait.until(ExpectedConditions.visibilityOf(firstAddressname));
		return firstAddressname.getText();
		}

	@FindBy(xpath="//h2[@id='deliver-to-customer-text']")
	private WebElement DeliveryAddressHeading;
	public void verifyAddressHeadingWiththirdAddressname(String thirdAddress) {
		wait.until(ExpectedConditions.visibilityOf(DeliveryAddressHeading));
		System.out.println(DeliveryAddressHeading.getText());
		//System.out.println(thirdAddressname.getText());
		Assert.assertEquals(DeliveryAddressHeading.getText().contains(thirdAddress), true);
	}
	public void verifyAddressHeadingWithfirstAddressname(String firstAddress) {
		wait.until(ExpectedConditions.visibilityOf(DeliveryAddressHeading));
		System.out.println(DeliveryAddressHeading.getText());
		//System.out.println(thirdAddressname.getText());
		
		Assert.assertEquals(DeliveryAddressHeading.getText().contains(firstAddress), true);
	}
//	@FindBy(xpath="(//input/following-sibling::i)[1]")
//	private WebElement firstAddressRadioButton;
//	public void clickfirstAddressRadioButton() {
//		wait.until(ExpectedConditions.elementToBeClickable(firstAddressRadioButton));
//		firstAddressRadioButton.click();
//		}
	@FindBy(xpath="//span[@class='lineitem-price-text a-text-bold']")
	private WebElement Checkoutpageprice;
	public void verifyProductPrice(String productprice) {
		wait.until(ExpectedConditions.visibilityOf(Checkoutpageprice));
		
		String cleanedPrice = Checkoutpageprice.getText()
		    .replaceAll("[^0-9.]", "") // Remove everything EXCEPT digits and a decimal point
		    .replaceFirst("\\..*", ""); // Remove the decimal point and everything after it

		Assert.assertEquals(productprice, cleanedPrice);
	}
	@FindBy(xpath="//button/child::span[@class='a-icon a-icon-small-trash']")
	private WebElement Checkoutpagedeleteicon;
	public void clickCheckoutpagedeleteicon() {
		wait.until(ExpectedConditions.elementToBeClickable(Checkoutpagedeleteicon));
		Checkoutpagedeleteicon.click();
		}
	
	
	

}
