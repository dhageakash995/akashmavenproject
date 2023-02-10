package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.ElementUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil elementUtil;
	//webelements
	By username=By.name("username");
	By password=By.name("password");	
	By loginButton=By.className("orangehrm-login-button");	
	By invalidCredentials=By.className("oxd-alert-content-text");
	By forgetPassLink =By.className("orangehrm-login-forgot-header");
	By logintitle =By.className("orangehrm-login-title");
	
	
	//pageactions
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		 elementUtil = new ElementUtil(driver);
	}
	
	public void enterUsername(String user)
	{
		elementUtil.enterText(username, user);
//		try {
//		driver.findElement(username).sendKeys(user);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	public void enterPassword(String pass)
	{
		elementUtil.enterText(password, pass);
//		try 
//		{
//			driver.findElement(password).sendKeys(pass);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
		public HomePage clickButton()
		{
			
			elementUtil.doClick(loginButton);
	//	driver.findElement(loginButton).click();
//		HomePage homepage =new HomePage(driver);
//		return homepage;
		
		return new HomePage(driver);
	}
	
	public HomePage DoLogin(String user , String pass)
	{
		enterUsername(user);
		enterPassword(pass);
//		HomePage homepage=clickButton();
//		return homepage;
		
		return clickButton();
	}
	
	public boolean isInvalidCredMsgPresent()
	{
		return elementUtil.isElementPresent(invalidCredentials, 10);
	}	
	
	public String getInvalidMsgText()
		{
			WebElement element=driver.findElement(invalidCredentials);
			return element.getText();
		}

	public boolean isForgetPassLinkPresent()
	{
		
		return elementUtil.isElementPresent(forgetPassLink, 10);
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		try {
//			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(forgetPassLink));
//			return true;
//		}
//			catch(NoSuchElementException e)
//		{
//			return false;
//		}
	}
	
	public ResetPasswordPage clickForgetPassLink()
	{
		elementUtil.doClick(forgetPassLink);
	//	driver.findElement(forgetPassLink).click();
		
		return new ResetPasswordPage(driver);
	}
	
	public boolean isLoginTextPresent()
	{
		return elementUtil.isElementPresent(logintitle, 10);
//		boolean flag;
//		try
//		{
//			WebDriverWait wait=new WebDriverWait(driver,10);
//			wait.until(ExpectedConditions.presenceOfElementLocated(logintitle));
//			
//			flag=true;			
//		}
//		catch(TimeoutException e)
//		{
//			flag=false;
//		}
//		return flag;
	}
	
	public String getTitle()
	{
		WebElement element=driver.findElement(logintitle);
		return element.getText();
	}

}
