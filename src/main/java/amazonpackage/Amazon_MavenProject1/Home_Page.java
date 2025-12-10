package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {
	WebDriver driver;
	 public Home_Page(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }

	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	

	@FindBy(xpath="//span[text()='Hello, sign in']")
	private WebElement Accounts_and_Lists;
	public void hoveroveronAccounts_and_Lists(WebDriver driver) {
		Actions a1=new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(Accounts_and_Lists));
		a1.moveToElement(Accounts_and_Lists).perform();
		
	}
	@FindBy(xpath="//span[text()='Sign in'][1]")
	private WebElement signinbutton;
	public void clickonSignin() {
		wait.until(ExpectedConditions.elementToBeClickable(signinbutton));
		signinbutton.click();
	}
	@FindBy(xpath="//span[text()='Hello, Nichanametla']")
	private WebElement Username_display;
	public void verifyUsernameAfterLogin() {
		wait.until(ExpectedConditions.visibilityOf(Username_display));
		Assert.assertTrue(Username_display.isDisplayed());
	}
	public void hoveroveronUsername_display(WebDriver driver) {
		Actions a1=new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(Username_display));
		a1.moveToElement(Username_display).perform();
		
	}
	@FindBy(xpath="//button[text()='Manage Profiles']")
	private WebElement ManageprofilesButton;
	public void clickonManageprofilesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(ManageprofilesButton));
		ManageprofilesButton.click();
	}
	@FindBy(linkText="View")
	private WebElement Viewlink;
	public void clickonViewlink() {
		wait.until(ExpectedConditions.elementToBeClickable(Viewlink));
		Viewlink.click();
	}
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbox;
	public void searchproduct() {
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys("Shoe"+Keys.ENTER);
	}
	@FindBy(xpath="//a[@id='nav-orders']")
	private WebElement Returns_Orders_link;
	public void clickonReturns_Orders_link() {
		wait.until(ExpectedConditions.elementToBeClickable(Returns_Orders_link));
		Returns_Orders_link.click();
	}
	@FindBy(linkText="Start here.")
	private WebElement StartHerebutton;
	public void clickonStartHerebutton() {
		wait.until(ExpectedConditions.elementToBeClickable(StartHerebutton));
		StartHerebutton.click();
	}
	
}
	