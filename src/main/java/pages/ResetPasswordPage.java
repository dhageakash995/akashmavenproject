package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage {
	
	WebDriver driver;
	
	By resetPass=By.className("orangehrm-forgot-password-title");
	By clickCancelButton=By.className("orangehrm-forgot-password-button--cancel");
	
	
	
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isResetPassTextPresent()
	{
		boolean flag;
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(resetPass));
		flag=true;
	}
		catch(TimeoutException  e)
		{
			flag=false;
		}
			return flag;
	}
	
	public String getResetPassText()
	{
		WebElement element=driver.findElement(resetPass);
		return element.getText();
	}
	
	public LoginPage clickCancel()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
	WebElement element=	wait.until(ExpectedConditions.presenceOfElementLocated(clickCancelButton));
		element.click();
		return new LoginPage(driver);
	}

}
