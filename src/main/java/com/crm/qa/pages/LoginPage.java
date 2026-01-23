package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page_Factory
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpButton;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[1]/div[1]/div/div")
	WebElement googleSignIn;
	
	@FindBy(xpath="//button[text()='Sign in with Apple']")
	WebElement appleSignIn;
	
	@FindBy(xpath="//*[name()='path' and contains(@fill,'#ffffff')]")
	WebElement microsoftSignIn;
	
//	this
//	Refers to the current object of LoginPage.
//	Meaning: “Initialize elements inside this class”.
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(); // this will return homepage class object
	}
	public String googlebuttonClickandTitle() {
		googleSignIn.click();
		return driver.getTitle();
	}
	public String applebuttonClickandTitle() {
		appleSignIn.click();
		return driver.getTitle();
	}
	public String microsoftbuttonClickandTitle() {
		microsoftSignIn.click();
		return driver.getTitle();
	}
	public static void  switchWindow() throws InterruptedException {
		String currentWin =driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String W : windows) {
			if(!W.equals(currentWin)) {
				 driver.switchTo().window(W);
				 Thread.sleep(3000);
			}
			
		}
		}

}
