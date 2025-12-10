package amazonpackage.Amazon_MavenProject1;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.Listener_Logic;
import utility.RetryAnalyzerlogic;
@Listeners(Listener_Logic.class)
public class AmazonProjectTC10_Verifyupdatingandremovingitemsfromthecart extends BaseClass {
	
	@Test(dataProvider="AmazonloginData_CorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class,
			retryAnalyzer=RetryAnalyzerlogic.class)
		public void Verifyupdatingandremovingitemsfromthecart(String username, String pwd) throws InterruptedException {
			Home_Page h1=new Home_Page(driver);
			h1.hoveroveronAccounts_and_Lists(driver);
			h1.clickonSignin();
			Login_Page l1=new Login_Page(driver);
			l1.enterMobileNumber(username);
			l1.clickonContinuButton();
			l1.enterPwd(pwd);
			l1.clickOnSignin(); 
			h1.searchproduct();
			SearchResults_Page sr1=new SearchResults_Page(driver);
			sr1.clickonfirstproduct();
			Set<String> browserids=driver.getWindowHandles();
			Iterator<String> ids=browserids.iterator();
			ids.next();
			String childid=ids.next();
			driver.switchTo().window(childid);
			ProductDetail_Page pd1=new ProductDetail_Page(driver); 
			pd1.clickonAddtoCartbutton();
			Thread.sleep(2000);
			Assert.assertEquals(pd1.verifyProductscount(), 1);
			pd1.clickonaddbutton();
			Thread.sleep(2000);
			Assert.assertEquals(pd1.verifyProductscount(), 2);
			pd1.clickonremovebutton();
			Thread.sleep(2000);
			Assert.assertEquals(pd1.verifyProductscount(), 1);
			pd1.clickondeletebutton();
			Thread.sleep(2000);
			Assert.assertEquals(pd1.verifyProductscount(), 0);
			
}}
