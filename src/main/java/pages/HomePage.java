package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementUtil;

public class HomePage {

	
	WebDriver driver;	
	ElementUtil elementUtil;
	
	//page Element
	By username=By.className("oxd-userdropdown-name");	
	By allLinks=By.className("oxd-main-menu-item--name");
	By timeLink=By.xpath("//span[text()='Time']");
	By AdminLink=By.xpath("//span[text()='Admin']");
	//costructor		
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		 elementUtil = new ElementUtil(driver);
	}	
	//PageActions	
	public boolean isUserNamePresent()
	{
		return elementUtil.isElementPresent(username, 15);
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		try {
//			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(username));
//			return true;
//		}
//			catch(NoSuchElementException e)
//		{
//			return false;
//		}
	}
			
	public String getUsername()
		{
			return driver.findElement(username).getText();
		}
	
	public ArrayList<String> getLinks()
	{
		ArrayList<String> texts=new ArrayList<String>();
	List<WebElement> list =driver.findElements(allLinks);
	
	for(WebElement e: list)
	{
		texts.add(e.getText());
	}
	
		return texts;
	}
	
	public TimeTimesheetPage clickLink()
	{
		elementUtil.doClick(timeLink);
	//	driver.findElement(timeLink).click();
		
		return new TimeTimesheetPage(driver);
	}
	
	public AdminPage ClickAdminLink()
	{	
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(AdminLink));
		element.click();
		return new AdminPage(driver);
		
	}
}
