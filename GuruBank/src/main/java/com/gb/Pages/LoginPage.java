package com.gb.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gb.Testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement guruheader;
	
	public LoginPage()throws IOException {
		PageFactory.initElements(driver, this);	
	}
	
	public String VerifyLoginPageTitle() throws InterruptedException {
		Thread.sleep(4000);
		return driver.getTitle();
	}
	
	public boolean verifyguru99headertext() {
		return guruheader.isDisplayed();
	}
	
	public HomePage VerifyLogin(String un,String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}
	
	
	
	

}
