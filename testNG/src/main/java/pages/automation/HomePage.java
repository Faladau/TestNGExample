package pages.automation;
import dataProvider.Constants;
import pages.BasePage;

public class HomePage extends BasePage{
	
	public String validHome() {
		String logoName = getElementPropertyValue("login", Constants.CLASSNAME, Constants .TEXT, null, true);
//		String logoName = driver.findElement(By.className("login")).getText();
		return logoName; 
	} 
}
