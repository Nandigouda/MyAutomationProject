package com.trello.MyProject.dropdownstest;

	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ReadDataFromExcel {
	public static void main(String[] args) throws Throwable {
		//Create the Object of FileInputStream
		FileInputStream fis = new FileInputStream("./src/test/resource/facebookdropdown1.xlsx");
		//Call the WorkBookFactory Class from POi and create() upon the same class
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("facebookdropdown1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(0);
		//String value1 = cell.getStringCellValue();
		long value = (long)cell.getNumericCellValue();
		System.out.println(value);
		//System.out.println(value1);
	
		workbook.close();
	}
	}

