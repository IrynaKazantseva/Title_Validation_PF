package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Selenium_properties {
	
public static void main(String[] args) {
	String a_value = null;
	String b_value = null;
	String c_value = null;
	
	Properties proper = new Properties();
	try {
		proper.load(new FileInputStream("C:/Workspace/Title_Validation_PF/src/main/resources/proper.properties"));
		a_value = proper.getProperty("a_value");
		b_value = proper.getProperty("b_value");
		c_value = proper.getProperty("c_value");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
	driver.get(b_value);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String title_actual = driver.getTitle();

	
	if (c_value.equals(title_actual)) {
		System.out.println("Test Case ID: \t\t" + a_value);
		System.out.println("URL: \t\t\t" + b_value);
		System.out.println("Title Expected: \t" + c_value);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "PASSED");
	} else {
		System.out.println("Test Case ID: \t\t" + a_value);
		System.out.println("URL: \t\t\t" + b_value);
		System.out.println("Title Expected: \t" + c_value);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "FAILED");
	}
	driver.quit();

}
}

	
