package com.gb.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.gb.Pages.HomePage;
import com.gb.Pages.LoginPage;
import com.gb.Testbase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	//TestUtil testutil;
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		

		loginpage = new LoginPage();	
	}
	@Test(priority=2)
	public void loginPageTitleTest() throws InterruptedException{
		String title = loginpage.VerifyLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	@Test(priority=1)
	public void loginTest() throws IOException{
		homepage = loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	@Test(priority=3)
	public void GuruLoginPageHeaderTest(){
		boolean flag = loginpage.verifyguru99headertext();
		Assert.assertTrue(flag);
	}




	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
