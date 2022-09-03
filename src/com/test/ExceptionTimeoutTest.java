package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {
	
//	@Test(timeOut = 2000)
//	public void InfiniteLoopTest() {
//		int i = 1;
//		while(i==1) {
//			System.out.println("Infinite Loop");
//		}
//	}
		@Test(expectedExceptions=NumberFormatException.class) // Not working
		public void FormatTest() {
			String a = "100A";
			System.out.println(a);
			
		}
}
