package pages.automation;

import dataProvider.Constants;
import pages.BasePage;

public class LoginPage extends BasePage{
	
	public String ValidLogin() {
		navigateTo("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		sendKeyOnFindElement("#email", Constants.CSS, Constants.USERNAME);
		sendKeyOnFindElement("#passwd", Constants.CSS, Constants.PASS);
		clickOnFindElement("#SubmitLogin",  Constants.CSS);
		String loginName = getTextAndTitle("account>span", Constants.CLASSNAME);
		
		return loginName;
	}
	

	public String invalidLogin() {
		navigateTo("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		sendKeyOnFindElement("#email", Constants.CSS, Constants.USERNAME);
		sendKeyOnFindElement("#passwd", Constants.CSS, Constants.INVALID_PASS);
		clickOnFindElement("#SubmitLogin",  Constants.CSS);
		String faildLogin = getElementPropertyValue(".//p[text()='There is 1 error']", Constants.XPATH, Constants .TEXT, null, true);

		return faildLogin;
	}

}
