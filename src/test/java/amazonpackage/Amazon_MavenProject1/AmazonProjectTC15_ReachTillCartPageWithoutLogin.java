package amazonpackage.Amazon_MavenProject1;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import utility.BaseClass;
import utility.RetryAnalyzerlogic;

public class AmazonProjectTC15_ReachTillCartPageWithoutLogin extends BaseClass{
	@Test(retryAnalyzer=RetryAnalyzerlogic.class)
	public void verifyUserIsAbleToReachTillCartPageWithoutLogin() {
		Home_Page h1=new Home_Page(driver);
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
		pd1.clickonGoTOCartButton();
		Cart_Page cp1=new Cart_Page(driver);
		cp1.verifyCartPage();
		pd1.clickondeletebutton();
	}
}
