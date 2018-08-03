package test;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.BasePage;

public class BaseTest extends BasePage{
	

	@BeforeClass
	public void intializa() {
		System.out.println("BASE_TEST...... BBBBBBBBBBeforeClass : ---" + platform);
		readConfig();
		initSet();
	}
	
	
	@AfterClass
	public void tearDown() {
		System.out.println("BASE_TEST......AAAAAAAAAAAAAAAAAAAAAAfterClass : ---" + platform);
		tearDownP();
	}
	
	@BeforeSuite
	public void getParam(ITestContext  testStore) {
		System.out.println("BASE_TEST......BeforeSuiteeeeeeee : ---" + platform);
		HashMap<String,String> parameters = new HashMap<String, String>(testStore.getCurrentXmlTest().getAllParameters());
		
		platform = parameters.get("platform");
		app = parameters.get("app");
		
		System.out.println("Platforma is: " + platform);
		System.out.println("App is: " + app);


	}
	

}
