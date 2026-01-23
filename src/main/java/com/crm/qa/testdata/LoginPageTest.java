package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title =loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM");
	}
	
	@Test(priority=2)
	public void signwithGoogle() throws InterruptedException {
		
		loginPage.googlebuttonClickandTitle();
		loginPage.switchWindow();
		String title2= driver.getTitle();
		Assert.assertEquals(title2, "Sign in - Google Accounts");
	}
	@Test(priority=3)
	public void signwithApple() throws InterruptedException {
		
		loginPage.applebuttonClickandTitle();
		loginPage.switchWindow();
		String title3= driver.getTitle();
		Assert.assertEquals(title3, "Sign in to Apple Account");
	}
	@Test(priority=4)
	public void signwithMicrosoft() throws InterruptedException {
		
		loginPage.microsoftbuttonClickandTitle();
		loginPage.switchWindow();
		String title4= driver.getTitle();
		Assert.assertEquals(title4, "Sign in to your account");
	}
	
	@Test(priority=5)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
