package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	ContactsPage contactPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactPage = new ContactsPage();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactPage.verifyContactsLable(),"contact lebel is missing on the page");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactPage.selectContactsByName("Priya Sharma Sharm");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactPage.selectContactsByName("Priya Sharma Sharm");
		contactPage.selectContactsByName("sdsd sd dfdf");
	}
	
	@Test(priority=4)
	public void validateCreateNewContactTest() {
		homePage.clickOnNewContactLinkPlusButton();
		contactPage.createNewContact("Nikhile", "tyagii");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
