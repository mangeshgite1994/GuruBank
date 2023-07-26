package com.gb.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.gb.Testutil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String CHROMEDRIVERPATH=System.getProperty("user.dir")+"/src/main/java/com/gb/excutables/chromedriver.exe";
	public static String FIREFOXDRIVERPATH=System.getProperty("user.dir")+"/src/main/java/com/gb/excutables/geckodriver.exe";
	
	public static String CONFIG_FILE_PATH =System.getProperty("user.dir")+"/src/main/java/com/gb/Configuration/config.properties";

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){

		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",CHROMEDRIVERPATH);	
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options); 
		}
		else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver",FIREFOXDRIVERPATH);
			driver = new FirefoxDriver(); 
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));				
	}

}
