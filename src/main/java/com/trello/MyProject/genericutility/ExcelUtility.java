package com.trello.MyProject.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * The class ExcelUtility helps us to read data from workBook
 * 
 * @author Nikhil nandigouda
 *
 */

public class ExcelUtility {
	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringDatafromexcel(String path, String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(fis);
		String cellData = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		workbook.close();
		return cellData;
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readNumericDatafromexcel(String path, String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(fis);
		double cellData = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
		workbook.close();
		return cellData;
	}
	
	
	
	/**
	 * 
	 * This Method helps us to write a data into workbook
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelData(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis =new FileInputStream("./src/resource/trelloworkbookdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(cell).getCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/resource/trelloworkbookdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
