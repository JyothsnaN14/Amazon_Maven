package amazonpackage.Amazon_MavenProject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orders_Page {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public Orders_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Write a product review')]")
	WebElement productreviewlink;
	public void clickonproductreviewlink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(productreviewlink));
		productreviewlink.click();	
	}

}
