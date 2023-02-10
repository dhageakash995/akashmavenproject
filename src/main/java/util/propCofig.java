package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class propCofig {

	
	static Properties prop;
	
	public static Properties init_proprties(String env)
	{
		String userDir=System.getProperty("user.dir");
		String filePath="";
		
		if(env.equals("SIT"))
		{
			filePath=userDir+"\\src\\main\\java\\config\\config_SIT.properties";
		}
		else if(env.equals("UAT"))
		{
			filePath=userDir+"\\src\\main\\java\\config\\config_UAT.properties";
		}

		System.out.println(filePath);
						
		File file = new File(filePath);
		try 
		{
		FileReader fileReader=new FileReader(file);	
		 prop = new Properties();		
		 prop.load(fileReader);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
}
