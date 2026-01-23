package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	Actions ac = new Actions(driver);
	
	@FindBy(xpath="//span[contains(text(),'Hemant Sharma')]")
	WebElement userNameLebel;
	
	@FindBy(xpath="//div[@id='main-nav']")
	WebElement hoverOnLeft;
	
	@FindBy(xpath="//div[@id='main-nav']//div")
	List<WebElement> itemsOnLeft;
	
	@FindBy(xpath = "//a[@href=\"/contacts\"]//following-sibling::button")
	WebElement plusForContacts;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectItemFromLeft(String item) {
		ac.moveToElement(hoverOnLeft).perform();
		List<WebElement> allItems=itemsOnLeft;
		for(int i=0;i<allItems.size();i++) {
			System.out.println(allItems.get(i).getText());
			if(allItems.get(i).getText().equalsIgnoreCase(item)) {
				System.out.println(allItems.get(i).getText());
				allItems.get(i).click();
			}
		}
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink() {
		selectItemFromLeft("Contacts");
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		selectItemFromLeft("Deals");
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		selectItemFromLeft("Tasks");
		return new TasksPage();
	}
	public boolean verfifyCorrectUsername() {
		return userNameLebel.isDisplayed();
	}
	public void clickOnNewContactLinkPlusButton() {
		ac.moveToElement(hoverOnLeft).perform();
		plusForContacts.click();
	}
	

}
