package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementUtil;

public class TimeTimesheetPage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By header1=By.className("oxd-topbar-header-breadcrumb-module");
	By header2=By.className("oxd-topbar-header-breadcrumb-level");
	By attendance = By.xpath("//span[text()='Attendance ']");
	By myReports = By.xpath("//a[text()='My Records']");
	
	
	public TimeTimesheetPage(WebDriver driver)
	{
		this.driver=driver;
		 elementUtil = new ElementUtil(driver);
	}
	
	public String getTitle()
	{
		elementUtil.isElementPresent(header1, 10);
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(header1));
		String str1=driver.findElement(header1).getText();
		String str2=driver.findElement(header2).getText();
		
		return str1+" / "+str2;
		}
	
	public AttendancePage clickMyReports()
	{
		elementUtil.doClick(attendance);
		elementUtil.doClick(myReports);
//	driver.findElement(attendance).click();
//	driver.findElement(myReports).click();
//	
	return new AttendancePage(driver);
	}
}
