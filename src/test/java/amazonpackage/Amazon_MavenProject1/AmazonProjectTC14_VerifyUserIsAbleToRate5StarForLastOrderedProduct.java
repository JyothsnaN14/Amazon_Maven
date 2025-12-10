package amazonpackage.Amazon_MavenProject1;

import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.RetryAnalyzerlogic;

public class AmazonProjectTC14_VerifyUserIsAbleToRate5StarForLastOrderedProduct extends BaseClass {
	@Test(dataProvider="AmazonloginData_User2CorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class, retryAnalyzer=RetryAnalyzerlogic.class)
		public void VerifyUserIsAbleToRate5StarForLastOrderedProduct(String user2username, String user2pwd) {
		Home_Page h1=new Home_Page(driver);
		h1.hoveroveronAccounts_and_Lists(driver);
		h1.clickonSignin();
		Login_Page l1=new Login_Page(driver);
		l1.enterMobileNumber(user2username);
		l1.clickonContinuButton();
		l1.enterPwd(user2pwd);
		l1.clickOnSignin();
		h1.clickonReturns_Orders_link();
		Orders_Page op1=new Orders_Page(driver);
		op1.clickonproductreviewlink();
		Product_Review_Page pr1=new Product_Review_Page(driver);
		pr1.clickonRating5star();
		pr1.EnterReviewText();
		pr1.sharePhotoReview("C:\\Users\\Uday\\Pictures\\BBslrPg.jpg");
		pr1.EnterTitlereview();
		pr1.clickonclear();
}}
