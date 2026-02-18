package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactPage = new ContactsPage();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String hometitle =homePage.verifyHomePageTitle();
		Assert.assertEquals(hometitle, "Free CRM","HomePageTitle not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		boolean b =homePage.verfifyCorrectUsername();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void contactLinktest() {
		contactPage=homePage.clickOnContactsLink();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
