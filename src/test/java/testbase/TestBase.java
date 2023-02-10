package testbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory;

import util.propCofig;

public class TestBase {

	static Logger log =Logger.getLogger(TestBase.class.getName());
	
 protected WebDriver driver;
 protected WebDriverWait wait;
   Properties prop;
 
  	@Parameters(value="env")
 	@BeforeTest
 	public void beforeTest(String env)
 	{		
  		
		prop=propCofig.init_proprties(env);
 	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
	

log.info("----------------------Execution Started for the testcase: " + result.getMethod().getMethodName() + "-----------------");
		String browser=prop.getProperty("browser");
		
		DriverFactory dff=new DriverFactory();
		driver=dff.init_driver(browser);
	
		String urlValue=prop.getProperty("url");
		driver.get(urlValue);		
		wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));		
	}
	
	@AfterMethod
	public void afterMthod()
	{	
		driver.quit();
	}
}
