package com.freecrm.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.base.TestBasis;
import com.freecrm.pages.Contact_page;
import com.freecrm.pages.Homepagemain;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.Screen;

public class Contact_Testcase extends TestBasis{
	
	LoginPage loginpage;
	Homepagemain homepage;
	Contact_page contact;

	public Contact_Testcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Test(dataProvider = "testdata")
	public  void contact (String fname,String mname,String lname) throws IOException
	{
		initiate();
		loginpage= new LoginPage();
		homepage.navigateToHome();
        loginpage.loginTestC();
        contact= homepage.ClickOncontactButton();
        contact.clickOncontact();
        homepage.ClickOncontactButton();
        contact.Refresh();
        contact.Refresh();
		contact.data(fname,mname,lname);
		contact.AssertSave();
		SoftAssert softassert =new SoftAssert();
		softassert.assertTrue(true);
		softassert.assertAll();
			
	}
	@DataProvider
	public Object [][] testdata() throws IOException
	{
		Object data [][] = Screen.GetDataFromExcel("Sheet2");
		return data;
	}

}
