package test.sv;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.sv.ContactPage;
import test.BaseTest;

public class ContactPageTest extends BaseTest{
	ContactPage cp = new ContactPage();
	
	@Test
	public void validContactPageTest() {
		String contactText = cp.confirmContactPage();
		Assert.assertEquals(contactText, "Stay in Touch"); 
	}

}
