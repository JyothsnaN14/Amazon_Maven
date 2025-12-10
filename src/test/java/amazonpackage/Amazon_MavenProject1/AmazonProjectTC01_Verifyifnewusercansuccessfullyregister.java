package amazonpackage.Amazon_MavenProject1;

import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.RetryAnalyzerlogic;

public class AmazonProjectTC01_Verifyifnewusercansuccessfullyregister extends BaseClass {
	@Test(dataProvider="AmazonloginData_NewUserCredentials",dataProviderClass=Amazon_Login_Data_Provider.class, 
			retryAnalyzer=RetryAnalyzerlogic.class)
	public void loginToAmazonWithValidCredentials(String username, String customername, String pwd) throws InterruptedException  {
		Home_Page h1=new Home_Page(driver);
		h1.hoveroveronAccounts_and_Lists(driver);
		h1.clickonStartHerebutton();
		Login_Page l1=new Login_Page(driver);
		l1.enterMobileNumber(username);
		l1.clickonContinuButton();
		l1.clickOnProceedToCreateAnAccountButton();
		l1.EnterName(customername);
		l1.enterPwd(pwd);
		l1.clickonverifyMobileNumberButton();
		//Thread.sleep(3000);
		//l1.switchtoFrame();
		//l1.clickOnstartPuzzleButton();
	
}}
