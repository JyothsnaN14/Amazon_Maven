package amazonpackage.Amazon_MavenProject1;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login_Page {
	
	WebDriver driver;
	WebDriverWait wait;
	public Login_Page(WebDriver driver) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Continue shopping']")
	private WebElement continueshoppingbutton;
	public void clickoncontinueshoppingbutton()
	{
		if(continueshoppingbutton.isDisplayed()) {
		continueshoppingbutton.click();	
	}}


	@FindBy(name="email")
	private WebElement user_email_phonefield;
	public void enterMobileNumber(String username) {
		wait.until(ExpectedConditions.visibilityOf(user_email_phonefield));
		user_email_phonefield.sendKeys(username);
	}

	@FindBy(xpath="//span[@id='continue']")
	private WebElement continuebutton;
	public void clickonContinuButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continuebutton));
		continuebutton.click();	
	}

	@FindBy(id="ap_password")
	private WebElement pwdfield;
	public void enterPwd(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(pwdfield));
		pwdfield.sendKeys(pwd);
	}

	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signinButton;
	public void clickOnSignin() {
		wait.until(ExpectedConditions.elementToBeClickable(signinButton));
		signinButton.click();
	}
	@FindBy(xpath="//i[@class='a-icon a-icon-alert']/preceding-sibling::h4[text()='There was a problem']")
	private WebElement ErrormsgwithIcon;
	public void verifyErrormsgwithIcon() {
		wait.until(ExpectedConditions.visibilityOf(ErrormsgwithIcon));
		Assert.assertTrue(ErrormsgwithIcon.isDisplayed());
	}
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement ProceedToCreateAnAccountButton;
	public void clickOnProceedToCreateAnAccountButton() {
		wait.until(ExpectedConditions.elementToBeClickable(ProceedToCreateAnAccountButton));
		ProceedToCreateAnAccountButton.click();
	}
	@FindBy(name="customerName")
	private WebElement Namefield;
	public void EnterName(String customername) {
		wait.until(ExpectedConditions.visibilityOf(Namefield));
		Namefield.sendKeys(customername);
	}
	@FindBy(xpath="//input[@id='continue']")
	private WebElement verifyMobileNumberButton;
	public void clickonverifyMobileNumberButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(verifyMobileNumberButton));
		verifyMobileNumberButton.click();	
	}
	@FindBy(id="game-core-frame")
	private WebElement frameid;
	public void switchtoFrame(){
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameid));
	driver.switchTo().frame(frameid);
	}
	@FindBy(xpath="//button[text()='Start Puzzle']")
	private WebElement startPuzzleButton;
	public void clickOnstartPuzzleButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(startPuzzleButton));
		startPuzzleButton.click();	
	}
	
	

}
