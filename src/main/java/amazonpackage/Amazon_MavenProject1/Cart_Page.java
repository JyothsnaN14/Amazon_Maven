package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public Cart_Page(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[contains(text(),'Shopping Cart')]")
	private WebElement ShoppingCarttext;
	public void verifyCartPage() {
		wait.until(ExpectedConditions.visibilityOf(ShoppingCarttext));
		Assert.assertEquals(ShoppingCarttext.isDisplayed(), true);
	}
}
