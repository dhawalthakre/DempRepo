package com.advantage.fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.advantage.reporting.Report;

public class PropertyFile {
	
	public Properties prop = new Properties();
	InputStream fs = null;
    
    public PropertyFile(String sFilePath) {
    	 System.out.println(sFilePath);
    	try {
    		fs = new FileInputStream(sFilePath);            
            prop.load(fs);
		} catch (Exception ex ) {
			return;
		}	     
        
        
    }
     
    public Set<Object> getAllKeys(){
        Set<Object> keys = prop.keySet();
        return keys;
    }
     
    public String getPropertyValue(String key){
        return prop.getProperty(key);
    }
	
    public void setProperty(String key, String value){
    	  prop.setProperty(key, value);
    	}
	
	

}
