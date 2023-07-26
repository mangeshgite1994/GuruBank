package com.gb.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gb.Testbase.TestBase;

public class NewCustomerPage extends TestBase {


	@FindBy(xpath = "//p[contains(text(),'Add New Customer')]")
	WebElement AddNewCustomerLabel;

	@FindBy(name="name")
	WebElement CustomerName;

	@FindBy(xpath="//input[@name='rad1'][2]")
	WebElement Gender;

	@FindBy(name="dob")
	WebElement DateofBirth;

	@FindBy(name="addr")
	WebElement Address;

	@FindBy(name="city")
	WebElement Cityname;

	@FindBy(name="state")
	WebElement Statename;

	@FindBy(name="pinno")
	WebElement PIN;

	@FindBy(name="telephoneno")
	WebElement Mobile;

	@FindBy(name="emailid")
	WebElement Email;

	@FindBy(name="password")
	WebElement Password;

	@FindBy(name="sub")
	WebElement Submit;

	// Initializing the Page Objects:

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddNewCustomerLabel(){
		return AddNewCustomerLabel.isDisplayed();
	}

	public void AddNewCustomer(String Custname,String dob,String address,
			String City,String State,String Pin,String mobilenum,
			String email,String pwd)
	{

		CustomerName.sendKeys(Custname);
		Gender.click();
		DateofBirth.sendKeys(dob);
		Address.sendKeys(address);
		Cityname.sendKeys(City);
		Statename.sendKeys(State);
		PIN.sendKeys(Pin);
		Mobile.sendKeys(mobilenum);
		Email.sendKeys(email);
		Password.sendKeys(pwd);
		Submit.click();
	}

}



















