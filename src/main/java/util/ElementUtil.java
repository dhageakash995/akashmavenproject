package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	static Logger log =Logger.getLogger(ElementUtil.class.getName());
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void doClick(By locator)
	{
		log.info("Inside doClick Method");
		//System.out.println("Inside doClick Method");
		//System.out.println("Locator:"+locator);
		log.info("Locator:"+locator);
		
		try
		{
		driver.findElement(locator).click();
		//System.out.println("click Successfully");
		log.info("click Successfully");
		}
		catch(Exception e)
		{
			log.error("Click not Successfully");
			//System.out.println("Click not Successfully");
		//	e.printStackTrace();
			log.error(e.toString());
		}
	}
	
	public void doClick(String xpath)
	{
		log.info("Inside doClick Method");
		log.info("Xpath:"+xpath);
		
		try
		{
		driver.findElement(By.xpath(xpath)).click();
		log.info("click Successfully");
		}
		catch(Exception e)
		{
			log.error("Click not Successfully");
			log.error(e.toString());
		}
	}
	
	public void doClick(WebElement ele)
	{
		log.info("Inside doClick Method eith webelement");		
		try
		{
		ele.click();
		log.info("click Successfully");
		}
		catch(Exception e)
		{
			log.error("Click not Successfully");
			log.error(e.toString());
		}
	}
	
	
	public void enterText(By locator , String text)
	{
		log.info("Inside enterText Method");
		log.info("Locator:"+locator);
		
		try
		{
		driver.findElement(locator).sendKeys(text);
		log.info("text entered Successfully");
		}
		catch(Exception e)
		{
			log.error("text not entered Successfully");
			log.error(e.toString());
		}
	}
	
	public boolean isElementPresent(By locator ,int time)
	{
		log.info("Inside isElementPresent method");
		log.info("Locator:" +locator);			
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			log.info("Element is present within " +time);
			return true;			
		}		
		catch(TimeoutException  e)
		{
			log.error("Element is not present");
				log.error(e.toString());
				return false;
		}
			
	}
	}

