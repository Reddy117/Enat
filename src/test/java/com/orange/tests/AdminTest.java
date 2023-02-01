package com.orange.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.pages.objects.AdminPage;
import com.orange.pages.objects.LoginPage;
import com.orange.utils.BaseClass;

public class AdminTest extends BaseClass{

	@Test(dataProvider="getAdminData")
	public void provideRights(HashMap<String,String> map) {

		ap.provideAdminRights(map.get("UserRole"), map.get("EmployeeName"), map.get("Status"), map.get("UserName"), map.get("Password"));
	}
	
	@DataProvider
	public Object[][] getAdminData() throws IOException {
		return getData("TC3_Provide", "Sheet1");
	}
}
