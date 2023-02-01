package com.orange.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class PIMPage extends BaseClass{
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=pimLinkxpath)
	WebElement pimLink;
	
	@FindBy(xpath=addButtonxpath)
	WebElement addButton;
	
	@FindBy(xpath=firstNameTxtxpath)
	WebElement firstNameText;
	
	@FindBy(xpath=lastNametTxtxpath)
	WebElement lastNameText;
	
	@FindBy(xpath=createCredentialsxpath)
	WebElement createLoginDetailsCheck;
	
	@FindBy(xpath=pimuserNamexpath)
	WebElement userNameText;
	
	@FindBy(xpath=pimPasswordxpath)
	WebElement passWrodText;
	
	@FindBy(xpath=pimConPasswordxpath)
	WebElement confirmPasswordtext;
	
	@FindBy(xpath=saveButtonxpath)
	WebElement saveButton;

	@FindBy(xpath=empLabelxpath)
	public WebElement empNameLabel;
	
	@FindBy(xpath=pimEmployeeNamexpath)
	WebElement empNameText;
	
	@FindBy(xpath=listboxXpath)
	WebElement ListBoxDrop;
	
	
	@FindBy(xpath=searchButtonxpath)
	WebElement searchButton;
	
	@FindBy(xpath=editButtoXpath)
	WebElement editButton;
	
	@FindBy(xpath=bloodTypeXpath)
	WebElement bloodTypeDrop;
	
	@FindBy(xpath=nationalityXpath)
	WebElement nationlaityDrop;
	
	@FindBy(xpath=maritalXpath)
	WebElement maritalStatusdrop;
	
	@FindBy(xpath=logoutimgXpath)
	public WebElement logOutImage;
	
	@FindBy(xpath=logOutButtonxpath)
	public WebElement logoutbutton;
	
	public void createEmployee(String fName,String lName,String uName,String password) throws InterruptedException {
		pimLink.click();
		addButton.click();
		firstNameText.sendKeys(fName);
		lastNameText.sendKeys(lName);
		Thread.sleep(2000);
		createLoginDetailsCheck.click();
		Thread.sleep(2000);
		userNameText.sendKeys(uName);
		passWrodText.sendKeys(password);
		confirmPasswordtext.sendKeys(password);
		saveButton.click();
		
	}
	
	public void editEmployee(String empName,String nationality,String maritalStatus,String blooedType) throws InterruptedException {
		pimLink.click();
		empNameText.sendKeys(empName);
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(2000);
		editButton.click();
		Thread.sleep(5000);
		nationlaityDrop.click();
		selectDrop(ListBoxDrop,nationality);
		Thread.sleep(3000);
		maritalStatusdrop.click();
		selectDrop(ListBoxDrop,maritalStatus);
		Thread.sleep(2000);
		bloodTypeDrop.click();
		selectDrop(ListBoxDrop,blooedType);
		saveButton.click();
	}
}
