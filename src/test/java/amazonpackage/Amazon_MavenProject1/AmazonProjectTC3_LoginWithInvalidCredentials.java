package amazonpackage.Amazon_MavenProject1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.Listener_Logic;
import utility.RetryAnalyzerlogic;

@Listeners(Listener_Logic.class)
public class AmazonProjectTC3_LoginWithInvalidCredentials extends BaseClass {

	
	@Test(dataProvider="AmazonloginData_InCorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class, 
			retryAnalyzer=RetryAnalyzerlogic.class)
	public void LoginWithInvalidCredentials(String invalidusername, String invalidpwd) {
		Home_Page h1=new Home_Page(driver);
		h1.hoveroveronAccounts_and_Lists(driver);
		h1.clickonSignin();
		Login_Page l1=new Login_Page(driver);
		l1.enterMobileNumber(invalidusername);
		l1.clickonContinuButton();
		l1.enterPwd(invalidpwd);
		l1.clickOnSignin();
		l1.verifyErrormsgwithIcon();
		
	}

}
