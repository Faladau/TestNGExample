package test.automation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.automation.ContactPage;
import test.BaseTest;

public class ContactPageTest extends BaseTest {
	
	ContactPage cp = new ContactPage();


	@Test
	public void verifyContactUsTitle() {

		String textErrea = cp.verifyContactUsTitle();
		Assert.assertEquals(textErrea, "CUSTOMER SERVICE - CONTACT US");
	}

	@Test
	public void sendError() {

		String textErrea = cp.sendError();
		Assert.assertEquals(textErrea, "Invalid email address.");

	}

}
