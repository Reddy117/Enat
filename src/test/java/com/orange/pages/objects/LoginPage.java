package com.orange.pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.utils.BaseClass;

public class LoginPage extends BaseClass{

	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userNameTxt;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement passwordTxt;
	
	@FindBy(xpath="//button[text()=' Login ']")
	public WebElement loginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String userName,String Password) {
		userNameTxt.sendKeys(userName);
		passwordTxt.sendKeys(Password);
		loginButton.click();
		
	}
	
}
