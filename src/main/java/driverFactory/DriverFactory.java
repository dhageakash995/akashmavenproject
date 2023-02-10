package driverFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListenerClass;
import util.ElementUtil;

public class DriverFactory {
	static Logger log =Logger.getLogger(DriverFactory.class.getName());
	  WebDriver driver;
	public   WebDriver init_driver(String browser)
	{
		log.info("inside init driver:"+browser);
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info(" chrome browser initialize successfully");
		}
		else if(browser.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter the browser name [chrome,FF,Edge]");
			System.exit(0);
		}	 
		driver.manage().window().maximize();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		WebDriverListenerClass driverListener = new WebDriverListenerClass();
		eDriver.register(driverListener);
		driver=(WebDriver)eDriver;
		return driver;
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
