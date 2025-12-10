package amazonpackage.Amazon_MavenProject1;


import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserProfile_Page {

	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public UserProfile_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='accordion-age-group-id']")
	private WebElement AgeGroupsection;
	public void clickonAgeGroupsection() {
		wait.until(ExpectedConditions.elementToBeClickable(AgeGroupsection));
		AgeGroupsection.click();
	}
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement Editbutton;
	public void clickonEditbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(Editbutton));
		Editbutton.click();
	}
	@FindBy(xpath="//div[@class='options-list six-column-grid']/child::button")
	private List<WebElement> AgeGroupbuttons;
	public void clickonAgeGroupbutton() {
		wait.until(ExpectedConditions.visibilityOfAllElements(AgeGroupbuttons));
		if(!(AgeGroupbuttons.get(0).isSelected())){
			AgeGroupbuttons.get(0).click();
		}
		else
		{
			AgeGroupbuttons.get(1).click();
		}
	}
	@FindBy(xpath="(//button[text()='Save'])[2]")
	private WebElement saveButton;
	public void clickonsaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		if(saveButton.isEnabled()) {
		saveButton.click();
		}
	}
	@FindBy(xpath="//div[@class='last-updated']")
	private WebElement lastUpdatedmsg;
	public void verifylastUpdatedmsg() {
		wait.until(ExpectedConditions.visibilityOf(lastUpdatedmsg));
		System.out.println(lastUpdatedmsg.getText());
		Date d1=new Date();
		System.out.println(d1.getTime());
		Date d2=new Date(d1.getTime());
		String format=d2.toString();
		String month=format.substring(4,7);
		String date=format.substring(8,10);
		String year=format.substring(format.length()-4);
		String format1=month.concat(" ").concat(date).concat(", ").concat(year);
		System.out.println("Current date is "+format1);
		Assert.assertEquals(lastUpdatedmsg.getText().contains(format1), true);
		}
	
}
