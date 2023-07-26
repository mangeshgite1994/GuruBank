package com.gb.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gb.Testbase.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement NewCustomerlink;


	@FindBy(xpath="//td[normalize-space()='Manger Id : mngr515536']")
	WebElement managerID;

	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement managerheading;


	// Initializing the Page Objects:

	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public String VerifyManagerHomepageTitle() {
		return driver.getTitle();
	}

	public boolean verifyManagerHomepageHeading() {
		String Managerheading=managerheading.getText();
		System.out.println(Managerheading);
		return managerheading.isDisplayed();

	}
	public boolean verifyManagerId() {
		String Managerid=managerID.getText();
		System.out.println(Managerid);
		return managerID.isDisplayed();
	}


	//Clicking on New Customer link
	public void ClickonNewCustomerlink() {
		NewCustomerlink.click();
	}
}
