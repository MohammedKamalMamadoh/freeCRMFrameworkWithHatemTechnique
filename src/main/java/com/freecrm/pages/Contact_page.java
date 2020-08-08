package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBasis;

public class Contact_page extends TestBasis {
	
	public Contact_page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='main-nav']/a[3]/span")
	WebElement contactButton;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement newcontact;
	
	@FindBy (xpath = "//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy (xpath = "//input[@name='middle_name']")
	WebElement middlename;

	
	@FindBy (xpath = "//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement savebutton;
	
	@FindBy (xpath = "//*[text()='Middle Name(s)']")
	WebElement assertsave;
	
	public void clickOncontact() {
		contactButton.click();
	}
	public void ClickOnNewContact()
	{
		newcontact.click();
		
	}
	
	public void Refresh ()
	{
		 driver.navigate().refresh();
	}
	public void data(String fname,String mname,String lname)
	{
		firstname.sendKeys(fname);
		middlename.sendKeys(mname);
		lastname.sendKeys(lname);
		savebutton.click();
		
	}
	public Boolean AssertSave()
	{
	Boolean iscontactsaved=	assertsave.isDisplayed();
	return iscontactsaved;
	
	}

}
