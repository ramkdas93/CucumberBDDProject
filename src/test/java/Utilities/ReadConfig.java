package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//instantiating
	Properties properties;
	
	String path = "config.properties";
	
	
	//constructor
	public ReadConfig() {
		
		//initializing
		properties = new Properties();  
		
		//to open "config.properties" file in input mode and load the file
		try {
			
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		
		//whatever is in the "browser" will be stored in the "value"
		String value = properties.getProperty("browser");
		
		if(value != null) 
			
			return value;
		
		else
			
			throw new RuntimeException("url not specified in config file.");
	}
}
