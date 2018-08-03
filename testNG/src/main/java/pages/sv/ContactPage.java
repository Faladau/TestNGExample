package pages.sv;

import dataProvider.Constants;
import pages.BasePage;

public class ContactPage extends BasePage{
	
	public String confirmContactPage() {
		navigateTo("https://www.softvision.com/");
		clickOnFindElement("//*[@id=\"hs-eu-confirmation-button\"]",  Constants.XPATH);
		clickOnFindElement(".hamburger-inner",  Constants.CLASSNAME);
		clickOnFindElement("//*[@id=\"nav-menu-item-19896\"]/a/span[1]",  Constants.XPATH);
		String contactText = getTextAndTitle("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div/div/div/div[3]/h3", Constants.XPATH);
		return contactText;
	}
}
