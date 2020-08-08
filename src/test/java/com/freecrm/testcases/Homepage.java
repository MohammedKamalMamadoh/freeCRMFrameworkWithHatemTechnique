package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.base.TestBasis;
import com.freecrm.pages.Homepagemain;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.Screen;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;



public class Homepage  extends TestBasis
{
	
	public Homepage() throws IOException
	{
		super();
		
	}
	LoginPage loginpage;
	Homepagemain homepage;
	@Parameters({"browser"})
	@BeforeMethod
	public void start(String browser,Method method) throws ATUTestRecorderException, IOException
	{
		initiate();
		loginpage= new LoginPage();
		recorder = new ATUTestRecorder("C:\\Users\\huawei\\eclipse-workspace\\framework\\records", method.getName(), false);
		recorder.start();
		homepage=loginpage.loginTestC();
		homepage.navigateToHome();
	}
	@AfterMethod(groups = {"Smoke","E2E","Regression"})
	public void tearDown(Method method) 
	{
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Screen.screenshoots(method.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
	
	@Test
	public void ContactButton(Method method) throws IOException 
	{
		
		homepage.ClickOncontactButton();
		String expectedURL= "https://ui.freecrm.com/contacts";
		String actualURL= homepage.url();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualURL,expectedURL,"the 2 URLs not matched in contacts");
		softassert.assertAll();
		Screen.screenshoots(method.getName());
	}
	
	@Test
	public void CompaniesButton(Method method) throws IOException
	{
		
        homepage.CLickOnCompanyButton();
		String expectedURL= "https://ui.freecrm.com/companies";
		String actualURL= homepage.url();
		SoftAssert softassert =new SoftAssert();
		softassert.assertEquals(actualURL, expectedURL,"the 2 URLs not matched in companies");
		softassert.assertAll();
		Screen.screenshoots(method.getName());
	}

	@Test 
	public void deals()
	{
		
		homepage.ClickOnDealsButton();
		String expectedURL= "https://ui.freecrm.com/deals";
		String actualURL= homepage.url();
		SoftAssert softassert =new SoftAssert();
		softassert.assertEquals(actualURL, expectedURL,"the 2 URLs not matched in deals");
		softassert.assertAll();
		
	}
	@Test 
	public void tasks()
	{
		
		homepage.IsMyNameVisiable();
		SoftAssert softassert =new SoftAssert();
		softassert.assertTrue(true, "your name is not exist");
		softassert.assertAll();
		
	}
	

	//@Parameters ({"pass"})
//	@BeforeTest
//	public void before_test(String pass)
//	{
//		System.out.println(pass);
//	}
//	@AfterTest
//	public void after_test()
//	{
//		System.out.println("after test");
//	}
//	@BeforeClass
//	public void before()
//	
//	{
//		System.out.println("before class");
//	}
//	@AfterClass
//	public void afterClass()
//	{
//		System.out.println("afterclass");
//	}
}
