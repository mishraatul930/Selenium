package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	//Annotations starting with @Before is defined for Preconditions
	@BeforeSuite  //1
	public void setup() {
		System.out.println("Setup system property for chrome");
	}
	
	@BeforeTest  //2
	public void LaunchBrowser() {
		System.out.println("Launch browser");
	}
	
	@BeforeClass  //3
	public void enterURL() {
		System.out.println("Enter the URL");
	}
	
	@BeforeMethod  //4
	public void Login() {
		System.out.println("Login");
	}
	
	//Annotations starting with @Test is defined for Test Cases
	@Test   //5
	public void GoogleTitleTest() {
		System.out.println("Testing title");
	}
	
	@Test
	public void homecheck() {
		System.out.println("Homepage Login");
	}
	
	//Annotations starting with @After is defined for Post conditions
	
	@AfterMethod    //6
	public void Logout() {
		System.out.println("Logout from App");
	}
	
	@AfterClass  //7
	public void CloseBrowser() {
		System.out.println("Close Browser");
	} 
	
	@AfterTest     //8
	public void DeleteAllCookies() {
		System.out.println("delete all cookies");
	}
	
	@AfterSuite
	public void GenerateReport() {
		System.out.println("Generate Report");
	}
}
