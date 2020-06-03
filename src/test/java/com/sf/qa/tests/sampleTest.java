package com.sf.qa.tests;

import com.sf.qa.pages.LoginPage;
import com.sf.qa.util.TestUtil;

import org.testng.annotations.Test;

public class sampleTest {

	TestUtil testUtil;

	@Test
	public void newDate() {
		testUtil = new TestUtil();

		System.out.println("future date: " +testUtil.getFutureDate());
		System.out.println("current date: " +testUtil.getCurrentDate());
	}

	@Test
	public String returnMethod() {
		System.out.println("Returning Method");
		return "devendraparate";
	}

	@Test
	public void normalMethod() {
		System.out.println("Normal Method");
		System.out.println(returnMethod());

	}

}
