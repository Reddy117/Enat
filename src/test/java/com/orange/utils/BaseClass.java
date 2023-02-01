package com.orange.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orange.elementlocators.OR;
import com.orange.pages.objects.AdminPage;
import com.orange.pages.objects.LoginPage;
import com.orange.pages.objects.PIMPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends OR{

	public static WebDriver driver;
	public static LoginPage lp;
	public static PIMPage pp;
	public static AdminPage ap;
	
	public static void setup(String browser) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@BeforeMethod
	public void baseMehtod() {
		setup("Chrome");
		lp=new LoginPage();
		pp=new PIMPage();
		ap=new AdminPage();
		lp.doLogin("Admin", "admin123");
		
	}
	
	@AfterMethod
	public void tearDown() {

		pp.logOutImage.click();
		pp.logoutbutton.click();
		driver.quit();
	}
	
	public static String getcelldata(String sheetName,int rownum,int colNum) throws IOException {
		
		FileInputStream f=new FileInputStream("C:\\Enat\\Orange\\src\\test\\resources\\TestData\\Data.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(f);
		XSSFSheet s=w.getSheet(sheetName);
		XSSFRow r=s.getRow(rownum);
		XSSFCell c=r.getCell(colNum);
		
		return c.getStringCellValue();
	}
	
	public static Object[][] getData(String tcName,String sheetName) throws IOException{
		int tcRow=0; 

		while(!getcelldata(sheetName, tcRow, 0).equals(tcName)) {
			tcRow++;
		}

		System.out.println(tcRow);
		int colRow=tcRow+1;
		int cols=0;//4
		while(!getcelldata(sheetName, colRow, cols).equals("N")) {
			cols++;
		}
		System.out.println(cols);

		int dataRow=tcRow+2; //5
		int rows=0; //2
		while(!getcelldata(sheetName, dataRow+rows,0).equals("N")) {
		
			rows++;
		}
		System.out.println(rows);
		HashMap<String,String> dataMap;
		Object[][] data=new Object[rows][1];
		//i=8 dataRow+rows=9  colRow=5 j=2 cols=3
		int index=0;
		for(int i=dataRow;i<dataRow+rows;i++) {
			dataMap=new HashMap();
			for(int j=0;j<cols;j++) {
				
				String key=getcelldata(sheetName, colRow, j);
				String value=getcelldata(sheetName, i, j);
				dataMap.put(key, value);
			}
			data[index][0]=dataMap;
			index++;
			System.out.println(dataMap);
		}
		return data;
	}

	public static void writeSpecificDataToDataSheet(String sheetName,String colName,String data,String tcName) throws IOException {
		FileInputStream f=new FileInputStream("C:\\Enat\\Orange\\src\\test\\resources\\TestData\\Data.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(f);
		XSSFSheet s=w.getSheet(sheetName);
		
		int tcRow=0; 
		int colNum=0;

		while(!getcelldata(sheetName, tcRow, 0).equals(tcName)) {
			tcRow++;
		}
		System.out.println(tcRow);
		XSSFRow r=s.getRow(tcRow+1);

		for(int i=0;i<r.getLastCellNum();i++) {

			if(r.getCell(i).getStringCellValue().equals(colName)) {
				colNum=i;
			}
		}
		System.out.println(colNum);
		r=s.getRow(tcRow+2);
		XSSFCell c=r.getCell(colNum);
		c.setCellValue(data);
		FileOutputStream out=new FileOutputStream("C:\\Enat\\Orange\\src\\test\\resources\\TestData\\Data.xlsx");
		w.write(out);
		out.close();
		f.close();
	}
	public static void main(String[] args) throws IOException {
		//m1(10,5);		
		 writeSpecificDataToDataSheet("Sheet1","EmployeName","Hi","TC2_Edit");
		//getData("TC2_Edit","Sheet1");
	}
	public void selectDrop(WebElement drop,String value) {
		
		List<WebElement> items=drop.findElements(By.tagName("div"));
		for(WebElement item:items) {
			if(item.getText().equals(value)) {
				item.click();
				break;
			}
		}
	}
	
	public static int getRandNum() {
		Random r=new Random();
		return r.nextInt(50);
	}
}
 