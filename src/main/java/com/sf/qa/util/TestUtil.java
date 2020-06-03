package com.sf.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sf.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICITE_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = ".\\src\\main\\java\\com\\sf\\qa\\testdata\\SFTestData.xlsx";
	public static String PICKLISTTESTDATA_SHEET_PATH = ".\\src\\main\\java\\com\\sf\\qa\\testdata\\SFPicklistTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("");
	}

	public String getFutureDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();// gets current date
		// cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);// add five days
		String newDate = dateFormat.format(cal.getTime());
		return newDate;
	}

	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();// gets current date
		String currentDate = dateFormat.format(cal.getTime());
		return currentDate;
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}

		return data;

	}

	public ArrayList<String> getPicklistTestData(String sheetName, String colName) {
		FileInputStream file = null;

		ArrayList<String> expectedList = new ArrayList<String>();

		try {
			file = new FileInputStream(PICKLISTTESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sheets = book.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (book.getSheetName(i).equalsIgnoreCase(sheetName)) {
				sheet = book.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell cellValue = ce.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase(colName)) {
						column = k;
					}
					k++;
				}
				// System.out.println("Column index: " + column);

				while (rows.hasNext()) {
					{

						Row r = rows.next();

						if (r.getCell(column).getCellType() == CellType.STRING) {
							expectedList.add(r.getCell(column).getStringCellValue());
						} else {
							expectedList.add(NumberToTextConverter.toText(r.getCell(column).getNumericCellValue()));

						}

					}

				}
			}

		}
		return expectedList;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
