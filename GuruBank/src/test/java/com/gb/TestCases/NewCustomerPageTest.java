package com.gb.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gb.Pages.HomePage;
import com.gb.Pages.LoginPage;
import com.gb.Pages.NewCustomerPage;
import com.gb.Testbase.TestBase;
import com.gb.Testutil.TestUtil;

public class NewCustomerPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	NewCustomerPage newcustomerpage;
	String sheetName="NewCustomerData";

	public NewCustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		newcustomerpage = new NewCustomerPage();
		loginpage = new LoginPage();
		homepage = loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(priority = 1)
	public void NewCustomerpageTitleTest() {
		homepage.ClickonNewCustomerlink();
		String ncptitle = driver.getTitle();
		System.out.println(ncptitle);
	}
	
	@DataProvider
	public Object[][] getGuruBankTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 2,dataProvider = "getGuruBankTestData")
	public void Validatecreatenewcustomer(String Custname,String dob,String address,String City,String State,String Pin,String mobilenum,String email,String pwd)
	{

		homepage.ClickonNewCustomerlink();

//		newcustomerpage.AddNewCustomer("Manoharqa", "01/18/1894", "YusufGuda1", "Hyderabad", "Telangana", "500035",
//				"7893694776", "manoharch20006@gmail.com", "manu4045");

		newcustomerpage.AddNewCustomer(Custname, dob, address, City, State, Pin, mobilenum, email, pwd);
		
		
//		  java.util.List<WebElement> Cusdetails =
//		  driver.findElements(By.xpath("//tbody//tr//tr"));
//		  
//		  System.out.println(Cusdetails.size());
//		  
//		  for (WebElement webElement : Cusdetails) { String name =
//		  webElement.getText(); System.out.println(name); }
//		 

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
