package com.orange.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.pages.objects.LoginPage;
import com.orange.pages.objects.PIMPage;
import com.orange.utils.BaseClass;

public class PIMTests extends BaseClass{

	@Test(dataProvider="getTC1Data",priority=1)
	public void tc1_createEmployee_PIM(HashMap<String,String> map) throws InterruptedException, IOException {
		String lastName=map.get("LastName")+getRandNum();
		pp.createEmployee(map.get("FirstName"), lastName, lastName, map.get("Password"));
		Thread.sleep(10000);
		String emplName=pp.empNameLabel.getText();
		writeSpecificDataToDataSheet("Sheet1","EmployeName",emplName,"TC2_Edit");
			
	}
	
	@Test(dataProvider="getTc2Data",priority=2)
	public void editEmployee(HashMap<String,String> map) throws InterruptedException {

		pp.editEmployee(map.get("EmployeName"), map.get("Nationality"), map.get("Marital Status"), map.get("BloodType"));
	}
	
	@DataProvider
	public Object[][] getTc2Data() throws IOException{
		return BaseClass.getData("TC2_Edit","Sheet1");
	}
	
	@DataProvider
	public Object[][] getTC1Data() throws IOException{
		return BaseClass.getData("TC1_CrtEmp","Sheet1");
	}
	
}
