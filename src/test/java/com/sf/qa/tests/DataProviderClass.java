package com.sf.qa.tests;

import org.testng.annotations.DataProvider;

import com.sf.qa.util.TestUtil;

public class DataProviderClass {

	@DataProvider(name = "getOppTestData")
	public Object[][] getOppTestData() {
		Object data[][] = TestUtil.getTestData("opportunities");
		return data;
	}

	@DataProvider(name = "getAccoTestData")
	public Object[][] getAccoTestData() {
		Object data[][] = TestUtil.getTestData("accounts");
		return data;
	}

}
