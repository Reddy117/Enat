package com.orange.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class AdminPage extends BaseClass{

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement AdminLink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	@FindBy(xpath="//label[text()='User Role']/following::i[1]")
	WebElement userRoleDrop;
	
	@FindBy(xpath="//label[text()='Employee Name']/following::input[1]")
	WebElement empNameText;
	
	@FindBy(xpath="//label[text()='Username']/following::input[1]")
	WebElement userNameText;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement passWrodText;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement confirmPasswordtext;
	
	@FindBy(xpath="//label[text()='Status']/following::i[1]")
	WebElement statusDrop;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@role='listbox']")
	WebElement ListBoxDrop;
	
	public void provideAdminRights(String userRole,String employeeName,String status,String uName,String passWord) {
		AdminLink.click();
		addButton.click();
		userRoleDrop.click();
		selectDrop(ListBoxDrop, userRole);
		empNameText.sendKeys(employeeName);
		statusDrop.click();
		selectDrop(ListBoxDrop, status);
		userNameText.sendKeys(uName);
		passWrodText.sendKeys(passWord);
		confirmPasswordtext.sendKeys(passWord);
		saveButton.click();
	}

}
