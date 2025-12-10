package amazonpackage.Amazon_MavenProject1;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Review_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public Product_Review_Page(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[@class='in-context-ryp__form-field--starRating']/child::span)[5]")
	WebElement Rating5star; 
	public void clickonRating5star()
	{
		wait.until(ExpectedConditions.visibilityOf(Rating5star));
		Rating5star.click();	
	}

	@FindBy(id="reviewText")
	WebElement ReviewText;
	public void EnterReviewText()
	{
		wait.until(ExpectedConditions.visibilityOf(ReviewText));
		ReviewText.sendKeys("Value For Money");	
	}
	@FindBy(xpath="//input[@id='media']")
	WebElement photoreview;
//	public void sharePhotoReview()
//	{
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("media")));
//		photoreview.sendKeys("C:\\Users\\Uday\\Pictures\\BBslrPg.jpg");	
//	}
	public void sharePhotoReview(String filePath) {
	    File fileToUpload = new File(filePath);
	    String absolutePath = fileToUpload.getAbsolutePath();
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.id("media") 
	    )); 
	    photoreview.sendKeys(absolutePath);
	    System.out.println("File uploaded successfully using path: " + absolutePath);
	}
	@FindBy(id="reviewTitle")
	WebElement Titlereview;
	public void EnterTitlereview()
	{
		wait.until(ExpectedConditions.visibilityOf(Titlereview));
		Titlereview.sendKeys("worth buying");	
	}
	
	@FindBy(xpath="//span[@class='in-context-ryp__form-field--starRating--clear']")
	WebElement clear;
	public void clickonclear()
	{
		wait.until(ExpectedConditions.visibilityOf(clear));
		clear.click();	
	}
	
}
