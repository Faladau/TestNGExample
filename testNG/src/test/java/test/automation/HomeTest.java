package test.automation;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.automation.HomePage;
import test.BaseTest;

@Test
public class HomeTest extends BaseTest{
	
	HomePage hp = new HomePage();
	
	
	public void vaidHomePage() {
		
		navigateTo("http://automationpractice.com/index.php");
		String logoName =  hp.validHome();
		Assert.assertEquals(logoName, "Sign in");
	}
	 
	
	
	
}
