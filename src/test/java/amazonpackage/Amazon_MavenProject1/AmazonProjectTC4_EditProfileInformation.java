package amazonpackage.Amazon_MavenProject1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.Listener_Logic;
import utility.RetryAnalyzerlogic;
@Listeners(Listener_Logic.class)
public class AmazonProjectTC4_EditProfileInformation extends BaseClass {

	
	@Test(dataProvider="AmazonloginData_CorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class, 
			retryAnalyzer=RetryAnalyzerlogic.class)
	public void EditUserProfileInformation(String username, String pwd) {
		Home_Page h1=new Home_Page(driver);
		h1.hoveroveronAccounts_and_Lists(driver);
		h1.clickonSignin();
		Login_Page l1=new Login_Page(driver);
		l1.enterMobileNumber(username);
		l1.clickonContinuButton();
		l1.enterPwd(pwd);
		l1.clickOnSignin();
		h1.hoveroveronUsername_display(driver);
		h1.clickonManageprofilesButton();
		h1.clickonViewlink();
		UserProfile_Page u1=new UserProfile_Page(driver);
		u1.clickonAgeGroupsection();
		u1.clickonEditbutton();
		u1.clickonAgeGroupbutton();
		u1.clickonsaveButton();
		u1.verifylastUpdatedmsg();
		
	}

}
