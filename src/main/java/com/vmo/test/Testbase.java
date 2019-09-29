package com.vmo.test;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {


	public static Properties prop;
	public static WebDriver Driver;
	protected static String currentdir = System.getProperty("user.dir");
	

	 public Testbase() {
		

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					currentdir + "\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			
	
			
			WebDriverManager.chromedriver().setup();
		
			Driver = new ChromeDriver();
		
			
		} 
		else if (browsername.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", currentdir +"\\src\\main\\java\\com\\partner\\qa\\config\\geckodriver.exe");
//			Driver = new FirefoxDriver();
//			Driver.get(prop.getProperty("url"));
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
			
		}
		
		
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.iedriver().setup();
		
			Driver = new InternetExplorerDriver();
			
		}
			
		
		Driver.get(prop.getProperty("url"));
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		

	}
	

	


}
