package pages.automation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import dataProvider.Constants;
import pages.BasePage;

public class SearchPage extends BasePage{

	
	
	
	public int searcharrea(String searchFor) {
		
	navigateTo("http://automationpractice.com/index.php");
	sendKeyOnFindElement("#search_query_top", Constants.ID, "dress");
	wait.until(ExpectedConditions.visibilityOfElementLocated(selector("#search_query_top", Constants.ID)));
	
	List<WebElement> result = driver.findElements(By.xpath("\".//div[@class=\\\"ac_results\\\"]/ul/li\""));

	int len = 0, unexpected = 0;
	for (WebElement webElement : result) {
		len++;
		if (!(webElement.getText().toLowerCase().contains(searchFor.toLowerCase()))) {
			System.err.println("Element "+ len + " " + webElement.getText() + " did not contain " + searchFor);
			unexpected++;
		}
	}
	return unexpected;

	}

}
