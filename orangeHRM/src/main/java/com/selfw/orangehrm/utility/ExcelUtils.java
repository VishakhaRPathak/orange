package com.selfw.orangehrm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {
	private ExcelUtils() {
		
	}
	public static Map<String, String> getUserAddressDataFromExcel(String sheetName) {
		Map<String, String> testData = new HashMap<String, String>();
		try {
			ConfigReader.loadProperties();
			String userDir = ConfigReader.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(userDir+"\\TestData\\UserAddress_Selenium.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			for(int i =0; i<=sheet.getLastRowNum();i++) {
				XSSFRow row = sheet.getRow(i);
				String key = row.getCell(0).getStringCellValue();
				String value = row.getCell(1).getStringCellValue();
				System.out.println(key+" - >"+value);
				if((key.equals("First Name")|| (key.equals("Last Name")))){
					testData.put(key,value);
				}else {
					testData.put(key, value );
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
		
	}
	
}
