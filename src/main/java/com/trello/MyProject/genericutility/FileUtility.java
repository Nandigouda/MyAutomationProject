package com.trello.MyProject.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class FileUtility helps us to read data from the different files
 * 
 * @author Nikhil Nandigouda
 *
 */

public class FileUtility {
	/**
	 * @author QASM6 we can read common data from propertyFile in the form of Key
	 *         and value pair
	 * @param key
	 * @return value
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/amazoncommondata.properties");

		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
