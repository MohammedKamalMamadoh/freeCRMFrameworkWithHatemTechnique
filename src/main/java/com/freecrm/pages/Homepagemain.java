package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBasis;

public class Homepagemain extends TestBasis
{
     public Homepagemain() throws IOException {
		
    	 PageFactory.initElements(driver, this);
	}
	@FindBy (linkText = "Contacts")
     WebElement contacts;   
     @FindBy (linkText = "Companies" )
     WebElement companies;
     @FindBy (linkText = "Deals")
     WebElement deals;
	 @FindBy (css = "span[class='user-display']")
	 WebElement myname;
	 
	 
	 public String gettitle()
	 {
		String title= driver.getTitle();
		 return title;
	 }
	 
	 public void navigateToHome()
	 {
		 driver.navigate().to("https://ui.freecrm.com/");
	 }
	 public Contact_page ClickOncontactButton() throws IOException
	 {
		 contacts.click();
		 return new Contact_page();
	 }
	 public String url()
	 {
		 String actualURL= driver.getCurrentUrl();
		 return actualURL;
	 }
	 public void CLickOnCompanyButton()
	 {
		 companies.click();
	 }
	 public void ClickOnDealsButton()
	 {
		 deals.click();
	 }
	 public Boolean IsMyNameVisiable()
	 {
		 Boolean name=myname.isDisplayed();
		 return name;
	 }
}
