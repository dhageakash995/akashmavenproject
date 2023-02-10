package tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;

public class HomeTest extends TestBase{
	
	
	@Test
	public void verifyLinks()
	{
		//ArrayList<String> expectedList = new ArrayList<String>();
//		expectedList.add("Admin");
//		expectedList.add("PIM");		
//		expectedList.add("Leave");
//		expectedList.add("Time");
//		expectedList.add("Recruitment");
//		expectedList.add("My Info");
//		expectedList.add("Performance");
//		expectedList.add("Dashboard");
//		expectedList.add("Directory");
//		expectedList.add("Maintenance");
//		expectedList.add("Buzz");
//		
		LoginPage login =new LoginPage(driver);
		HomePage homepage =login.DoLogin("Admin", "admin123");
		
		Assert.assertEquals(homepage.isUserNamePresent(), true);		
		ArrayList<String> list=homepage.getLinks();
		
		Assert.assertEquals(list.size(),  Constants.HOMEPAGE_MENU_LINKS.size());
		Assert.assertEquals(list,  Constants.HOMEPAGE_MENU_LINKS);
	}
	
//	@Test
//	public void verifyAdminButtonNavigateToAdminPage()
//	{
//		driver.findElement(By.name("username")).sendKeys("Admin");			
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.className("orangehrm-login-button")).click();
//		try {
//	    WebElement element=	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
//	    element.click();
//		}
//	catch(TimeoutException e)
//		{
//		Assert.assertEquals(false, true,"Admin element is not found");
//		}
//		WebElement topbapElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-topbar-header-breadcrumb")));
//		String text=topbapElement.getText();
//		
//		Assert.assertEquals(text, "Admin\nUser Management");
//		
//	}

}
