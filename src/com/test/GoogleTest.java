package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod(groups = "Regression")
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atul.mishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:9089/BrowserWeb/");
		Thread.sleep(2000);
		driver.findElement(By.id("signOnName")).sendKeys("INPUTT");
		driver.findElement(By.id("password")).sendKeys("123456");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, groups = "Regression")
	public void VerifyHomePage() throws InterruptedException {
		driver.findElement(By.id("sign-in")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2, groups = "Regression")
	public void EnterData() throws InterruptedException {
		driver.findElement(By.id("sign-in")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[contains(@id,'commandV')]")).sendKeys("SAPWPS.PARAMETER");
		Thread.sleep(3000);
	}
	
	@Test(priority = 5, groups = "UnitTest")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(priority = 4, groups = "UnitTest")
	public void test2() {
		System.out.println("Test2");
	}
	@Test(priority = 3, groups = "Regression")
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
}
}
