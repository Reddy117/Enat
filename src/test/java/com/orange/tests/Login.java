package com.orange.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orange.utils.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass{


	
	//@Test
	public void verifyLoginFields() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		setup("Chrome");
		WebElement userNameText=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordText=driver.findElement(By.xpath("//input[@type='password']"));
		WebElement loginButton=driver.findElement(By.xpath("//button[text()=' Login ']"));
	}
	
	@Test
	public void tc1_Dosuccessfullogin() {
		setup("Chrome");
		WebElement userNameText=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordText=driver.findElement(By.xpath("//input[@type='password']"));
		WebElement loginButton=driver.findElement(By.xpath("//button[text()=' Login ']"));
		
		userNameText.sendKeys("Admin");
		passwordText.sendKeys("admin123");
		loginButton.click();
	}
	
//	@Test
	public void tc2_unsuccessfullogin() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		setup("Chrome");
		WebElement userNameText=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordText=driver.findElement(By.xpath("//input[@type='password']"));
		WebElement loginButton=driver.findElement(By.xpath("//button[text()=' Login ']"));
		
		userNameText.sendKeys("Admin12");
		passwordText.sendKeys("admin12345");
		loginButton.click();
	}
}
