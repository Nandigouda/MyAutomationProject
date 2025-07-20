package com.trello.MyProject.exceldatadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllWorkBookData {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resource123/facebookdropdown1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("dropdownoption1");
		int firstRowIndex = sheet.getFirstRowNum();
		// System.out.println(firstRowIndex);
		int lastRowIndex = sheet.getLastRowNum();
		// System.out.println(lastRowIndex);
		// int noOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = firstRowIndex; i <= lastRowIndex; i++) {
			short firstCellIndex = sheet.getRow(i).getFirstCellNum();
			// System.out.println(firstCellIndex);
			short cellCountInRow = sheet.getRow(i).getLastCellNum();
			// System.out.println(cellCountInRow);
			for (short j = firstCellIndex; j < cellCountInRow; j++) {
				String cellType = sheet.getRow(i).getCell(j).getCellType().toString();
				if (cellType.equals("NUMERIC")) {
					long numericValue = (long) sheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.println(numericValue);
				} else if (cellType.equals("STRING")) {
					String stringValue = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(stringValue);
				}
			}
		}
		workbook.close();
	}
}