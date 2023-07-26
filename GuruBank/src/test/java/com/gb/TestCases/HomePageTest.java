package com.gb.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gb.Pages.HomePage;
import com.gb.Pages.LoginPage;
import com.gb.Testbase.TestBase;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		loginpage = new LoginPage();	
		homepage = loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(priority=1)
	public void verifyManagerHomePageTitleTest(){
		String homePageTitle = homepage.VerifyManagerHomepageTitle();
		Assert.assertEquals(homePageTitle, "Guru99 Bank Manager HomePage","Home page title not matched");
	}


	@Test(priority=2)
	public void verifyManagerHomepageHeadingTest(){
		boolean flag = homepage.verifyManagerHomepageHeading();
		Assert.assertTrue(flag);

	}

	@Test(priority=3)
	public void verifyManagerIdTest(){
		boolean flag = homepage.verifyManagerId();
		Assert.assertTrue(flag);


	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
