package pages.automation;
import dataProvider.Constants;
import pages.BasePage;

public class ContactPage extends BasePage{
	
	
	public String verifyContactUsTitle() {
		navigateTo("http://automationpractice.com/index.php");
		clickOnFindElement(".//*[@id='contact-link']/a",  Constants.XPATH);
		String textErrea = getTextAndTitle("#center_column h1", Constants.CSS);
		return textErrea;
	

	}
	
	
	public String sendError() {
		
		navigateTo("http://automationpractice.com/index.php");
		clickOnFindElement(".//*[@id='contact-link']/a",  Constants.XPATH);
		clickOnFindElement("#submitMessage",  Constants.CSS);

		String textError = getTextAndTitle(".alert.alert-danger>ol>li", Constants.CSS);
		return textError;
	}

}
