package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasePage {

	protected static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement element;
	public static String platform;
	public static String app;

	public void readConfig() {
		ConfigFileReader.getAttributes();

	}

	public void initSet() {
		System.out.println("initSettttttttttttttt platform: " + platform);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resource\\chromedriver.exe");
		if (platform.equals("desktop")) {
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 15);
			System.out.println(driver);
		}
		if (platform.equals("mobile")) {

			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			wait = new WebDriverWait(driver, 15);

		}
		//se seteaza variabila de sistem in : click dr pe MyComputer/properties/Advanced system settings/jos la Environment Variables/system variables/
		//new : nume : ANDROID_HOME, value: C:\Users\ciprian.faladau\AppData\Local\Android\Sdk
		//
		if (platform.equals("mobileEmulator")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
			driver.navigate().to("https://www.softvision.com/");
		}

	}

	public void tearDownP() {

		driver.close();
		if (driver != null) {
			driver.quit();

		}

	}

	public void navigateTo(String URL) {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}

	public By selector(String name, String findBy) {

		if (findBy.equals(Constants.ID)) {
			return By.id(name);
		} else if (findBy.equals(Constants.CLASSNAME)) {
			return By.className(name);
		} else if (findBy.equals(Constants.CSS)) {
			return By.cssSelector(name);
		} else if (findBy.equals(Constants.XPATH)) {
			return By.xpath(name);
		} else
			System.out.println("The locator is undefind!");
		return null;
	}

	public WebElement findObject(String name, String findBy, boolean mandatory) {

		WebElement toFind = null;
		try {
			toFind = driver.findElement(selector(name, findBy));
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector(name, findBy)));

		} catch (Exception e) {

			System.out.println("The element '" + name + "' not found on the page");

		}
		if (mandatory && toFind == null) {
			System.out.println("The mandatory element '" + name + "' is not found!");
		}
		return toFind;

	}

	public void clickOnFindElement(String name, String findBy) {

		element = findObject(name, findBy, true);
		if (element != null && element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("The element : '" + name + "' not clickable or not found!");
		}

	}

	public void sendKeyOnFindElement(String name, String findBy, String key) {

		try {
			element = findObject(name, findBy, true);
			element.sendKeys(key);

		} catch (Exception e) {
			System.out.println("The element : '" + name + "' not found!");
		}

	}

	public String getTextAndTitle(String name, String findBy) {
		element = findObject(name, findBy, true);
		String textElem = element.getText();
		return textElem;
	}

	public String getElementPropertyValue(String name, String findBy, String property, String option,
			Boolean mandatory) {

		try {
			element = findObject(name, findBy, mandatory);

			if (property.equals(Constants.TEXT)) {
				return element.getText();
			} else if (property.equals(Constants.TAG_NAME)) {
				return element.getTagName();
			} else if (property.equals(Constants.ATTRIBUTE)) {
				return option == null ? null : element.getAttribute(option);
			} else if (property.equals(Constants.SELECTED)) {
				return String.valueOf(element.isSelected());
			} else if (property.equals(Constants.DISPLAYED)) {
				return String.valueOf(element.isDisplayed());
			} else if (property.equals(Constants.CSS_VALUE)) {
				return option == null ? null : element.getCssValue(option);
			} else
				throw new Exception();
		} catch (Exception e) {
			return ("The input parameer \"valueOf\" = " + property + " ,is not a valid value to get ");
		}

	}

}
