package com.test;

import org.testng.annotations.Test;

public class TestNgConcepts {
	
	@Test
	public void LoginTest() {
		System.out.println("LoginTest");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void HomepageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void SearchTest() {
		System.out.println("Search Test");
	}

}
