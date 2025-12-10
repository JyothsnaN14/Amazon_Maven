package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import amazonpackage.Amazon_MavenProject1.Login_Page;

public class BaseClass {
 protected WebDriver driver;	
@BeforeMethod
public void launchAmazon() {
driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();

//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Login_Page l1=new Login_Page(driver);
l1.clickoncontinueshoppingbutton();
driver.navigate().refresh();
Listener_Logic.driver = (ChromeDriver)driver;
}

@AfterMethod
public void quitbrowser() {
	//driver.quit();
}
}
