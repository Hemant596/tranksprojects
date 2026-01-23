package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium_Java\\Trank_Technologies\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("WebDriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}else {
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	driver.get(prop.getProperty("url"));
	}

}
