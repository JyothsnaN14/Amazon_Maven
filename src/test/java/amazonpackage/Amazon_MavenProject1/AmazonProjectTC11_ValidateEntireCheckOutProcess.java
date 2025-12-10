package amazonpackage.Amazon_MavenProject1;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.Listener_Logic;
import utility.RetryAnalyzerlogic;
@Listeners(Listener_Logic.class)
public class AmazonProjectTC11_ValidateEntireCheckOutProcess extends BaseClass{
	@Test(dataProvider="AmazonloginData_CorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class,
	retryAnalyzer=RetryAnalyzerlogic.class)
		public void ValidateEntireCheckOutProcess(String username, String pwd) throws InterruptedException {
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
			String productprice=sr1.getProductPrice();
			sr1.clickonfirstproduct();
			Set<String> browserids=driver.getWindowHandles();
			Iterator<String> ids=browserids.iterator();
			ids.next();
			String childid=ids.next();
			driver.switchTo().window(childid);
			ProductDetail_Page pd1=new ProductDetail_Page(driver); 
			pd1.clickonAddtoCartbutton();
			pd1.clickonproceedtobuybutton();
			Payment_Page pp1=new Payment_Page(driver);
			pp1.selectCashonDeliveryOption();
			pp1.clickUseThisPaymentButton();
			Thread.sleep(5000);
			Checkout_Page  cp1=new Checkout_Page(driver);
			cp1.verifyProductPrice(productprice);
			cp1.clickAddress_Changebutton();
			cp1.clickthirdAddressRadioButton();
			String thirdAddress=cp1.getthirdAddressname();
			System.out.println(thirdAddress);
			Thread.sleep(2000);
			cp1.clickOnDeliveryToThisAddress();
			Thread.sleep(3000);
			cp1.verifyAddressHeadingWiththirdAddressname(thirdAddress);
			//cp1.clickAddress_Changebutton();
			//cp1.clickfirstAddressRadioButton();
//			String firstAddress=cp1.getfirstAddressname();
//			System.out.println(firstAddress);
//			cp1.clickOnDeliveryToThisAddress();
//			cp1.verifyAddressHeadingWithfirstAddressname(firstAddress);
			
			
			
			pp1.clickoncarticon();
			pd1.clickondeletebutton();
}}
