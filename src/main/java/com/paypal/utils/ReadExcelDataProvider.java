package com.paypal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelDataProvider {
	
	/**
	 * @author nim
	 * 
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 */
	@DataProvider(parallel = true)
	public Object [][] getExcelData(ITestNGMethod methodName, ITestContext testContext) {
		String[][] arrayExcelData = null;
		try {
			String fileName = methodName.getRealClass().getCanonicalName().replaceAll("\\.", "/");
			String localesInputDataFile = "testdata/"+fileName+".yaml";
			System.out.println(methodName.getRealClass());
			System.out.println(fileName);
			String sheetName  = testContext.getName();
			System.out.println(sheetName);
			FileInputStream fs = new FileInputStream(localesInputDataFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}
