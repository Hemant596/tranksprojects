package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	Actions ac = new Actions(driver);
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactLabel;
	
	@FindBy(xpath="//a[contains(text(),'Priya Sharma Sharm')]//parent::td//preceding-sibling::td")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(xpath="//div[@name='view']")
	@CacheLookup
	WebElement justHover;
	
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	@CacheLookup
	WebElement justHoverforplus;
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@name=\"last_name\"]")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//div[@name=\"channel_type\"]//i//following-sibling::div//div")
	@CacheLookup
	List<WebElement> socialChannel;
	
	@FindBy(xpath="//i[@class=\"save icon\"]")
	@CacheLookup
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLable() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		ac.moveToElement(justHover).perform();
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
				+ "//parent::td//preceding-sibling::td")).click();
	}
public void createNewContact(String fName, String lName) {
		
		ac.moveToElement(justHoverforplus).perform();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		
		
		save.click();
	}

}
