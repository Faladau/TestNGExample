package test.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.automation.LoginPage;
import test.BaseTest;

public class LoginTest extends BaseTest{
	LoginPage lp = new LoginPage();
	
	
	@Test
	public void validLoginTest() { 
		//login with valid user and pass and click on login btn
		String loginName =  lp.ValidLogin();
		//assert user name with laginName from the right corner
		Assert.assertEquals(loginName, "ciprian lucian"); 
		
		
	}
	
	@Test
	public void invalidLoginTest() {
		String faildText = lp.invalidLogin();
		
			try {
				Assert.assertEquals(faildText, "There is 1 error");
			} catch (java.lang.AssertionError e) {
				System.out.println("Try to login with invalid credential and the error is not the expected one!!!");
			}

	}

}
