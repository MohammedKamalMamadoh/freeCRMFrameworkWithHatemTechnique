package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBasis;

public class LoginPage extends TestBasis{
	
    public LoginPage() throws IOException {
	PageFactory.initElements(driver, this);
	}

	@FindBy(name="email")
    WebElement email;
    
    @FindBy(name="password")
    WebElement password;
    
    @FindBy (xpath="//div[text()='Login']")
    WebElement loginButton;
    
    @FindBy (xpath = "//img[@class='img-responsive']")
    WebElement logo;
    
    @FindBy(css = "span[class='user-display']")
    WebElement myname;
    
    public String gettitle()
    {
    	String ActualTitle =driver.getTitle();
    	return ActualTitle;
    	
    }
    public String getURL()
    {
    	String actualURL= driver.getCurrentUrl();
    	return actualURL;
    	
    }
	public Boolean islogodisplayed()
	{
		Boolean islogodsplay=logo.isDisplayed();
		return islogodsplay;
	}
	public Homepagemain loginTestC() throws IOException
	{
		driver.navigate().to("https://ui.freecrm.com/");
		email.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new Homepagemain();
	}

}
