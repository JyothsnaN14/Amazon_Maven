package amazonpackage.Amazon_MavenProject1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.Amazon_Login_Data_Provider;
import utility.BaseClass;
import utility.Listener_Logic;
import utility.RetryAnalyzerlogic;
@Listeners(Listener_Logic.class)
public class AmazonProjectTC6_Searchingwithfiltersyieldsaccurateresults extends BaseClass {

	
	@Test(dataProvider="AmazonloginData_CorrectCredentials",dataProviderClass=Amazon_Login_Data_Provider.class,
			retryAnalyzer=RetryAnalyzerlogic.class)
	public void verifySearchingWithFiltersYieldsAccurateResults(String username, String pwd) throws InterruptedException {
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
		sr1.verifyBrandFilters();
		sr1.verifypricefilters();

}}
