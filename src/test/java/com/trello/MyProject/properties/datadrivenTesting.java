package com.trello.MyProject.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class datadrivenTesting {

	public String readDataFromFiles(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("./sr/test/xyz.properties");
		Properties pobj=new Properties();
         pobj.load(fis);
         String value = pobj.getProperty(key);
         return value;	
	}
}
