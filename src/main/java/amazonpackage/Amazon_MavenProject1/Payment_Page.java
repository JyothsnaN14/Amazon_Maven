package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payment_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public Payment_Page(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	

	//@FindBy(xpath="//input[@type='radio']")
	//private List<WebElement> paymentoptions;
	public void verifyeachpaymentoption() {
		 Map<String, By> paymentOptions = new HashMap<>();
	        paymentOptions.put("Amazon Pay Balance", By.xpath("(//label/child::input[@type='radio'])[1]"));
	        paymentOptions.put("Amazon Pay UPI", By.xpath("(//label/child::input[@type='radio'])[2]"));
	        paymentOptions.put("Credit or debit card", By.xpath("(//label/child::input[@type='radio'])[3]"));
	        paymentOptions.put("Net Banking", By.xpath("(//label/child::input[@type='radio'])[4]"));
	        paymentOptions.put("Scan and Pay with UPI", By.xpath("(//label/child::input[@type='radio'])[5]"));
	        paymentOptions.put("Other UPI Apps", By.xpath("(//label/child::input[@type='radio'])[6]"));
	        paymentOptions.put("EMI", By.xpath("(//label/child::input[@type='radio'])[7]"));
	        paymentOptions.put("Cash on Delivery/Pay on Delivery", By.xpath("(//label/child::input[@type='radio'])[8]"));
	        System.out.println("--- Starting Payment Option Selection Verification ---");
	        
	        for (Map.Entry<String, By> entry : paymentOptions.entrySet()) {
	            String optionName = entry.getKey();
	            By locator = entry.getValue();
	            WebElement radioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            if(radioElement.isEnabled()) {
	             radioElement.click();
	            }
	             wait.until(ExpectedConditions.visibilityOf(radioElement));
	                    if (radioElement.isSelected()) {
	                    System.out.println("✅ SUCCESS: The '" + optionName + "' option was successfully selected.");
	                } else {
	                    System.out.println("⚠️ WARNING: The '" + optionName + "' option was clicked but did NOT register as selected.");
	                }
	                
	            } 
	        

	}
	@FindBy(xpath="//span[@id='nav-checkout-cart-icon']")
	private WebElement carticon;
	public void clickoncarticon() {
		wait.until(ExpectedConditions.elementToBeClickable(carticon));
		carticon.click();

}
	@FindBy(xpath="//input[@placeholder='Enter Code']")
	private WebElement couponcodeplaceholder;
	public void entercouponcode() {
		wait.until(ExpectedConditions.visibilityOf(couponcodeplaceholder));
		couponcodeplaceholder.sendKeys("ABCD123");
		}
	@FindBy(xpath="//input[@value='Apply']")
	private WebElement Applybutton;
	public void clickOnApplyButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Applybutton));
		Applybutton.click();

}@FindBy(xpath="//p[text()='The promotional code you entered is not valid.']")
private WebElement couponcodeerrormsg;
public void verifycouponcodeerrormsg() {
	wait.until(ExpectedConditions.visibilityOf(couponcodeerrormsg)); 
	Assert.assertEquals(couponcodeerrormsg.isDisplayed(), true, "User is able to apply Coupon Code");
}

@FindBy(xpath="//input[contains(@value,'Cash')and(@type='radio')]")
private WebElement CashonDeliveryOption;
public void selectCashonDeliveryOption() {
	wait.until(ExpectedConditions.elementToBeClickable(CashonDeliveryOption));
	CashonDeliveryOption.click();
	Assert.assertEquals(CashonDeliveryOption.isSelected(), true);

}
@FindBy(xpath="(//span[contains(text(),'Use this payment method')]/preceding-sibling::input)[1]")
private WebElement UseThisPaymentButton;
public void clickUseThisPaymentButton() {
	wait.until(ExpectedConditions.elementToBeClickable(UseThisPaymentButton));
	UseThisPaymentButton.click();
	}

}
