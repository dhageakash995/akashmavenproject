package tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import testbase.TestBase;
import util.Constants;
import util.ElementUtil;

public class LogInTest extends TestBase {
	
	static Logger log =Logger.getLogger(LogInTest.class.getName());
		
	@Test
	public void loginTest()
	{
		log.info("test case executopn start -->loginTest");
			LoginPage login=new LoginPage(driver);
			HomePage homepage=login.DoLogin("Admin", "admin123");
			
				
			boolean flag=homepage.isUserNamePresent();			
			Assert.assertEquals(flag, true, "Username element not displayed");
			
			String username=homepage.getUsername();
			Assert.assertEquals(username, Constants.HOMEPAGE_USERNAME);
	}			
	
	
	@Test
	public void invalidLogin()
	{	
		log.info("test case executopn start -->invalidLogin");
		LoginPage login=new LoginPage(driver);
		login.DoLogin("Admin", "admin12");
		boolean isPresent=login.isInvalidCredMsgPresent();
		Assert.assertEquals(isPresent, true);
		String actual=login.getInvalidMsgText();
		Assert.assertEquals(actual, Constants.INVALID_MSG_TEXT);
		
	}
	

		
		@Test
		public void redirectToResetPasswordPageLinkPresent()
		{
			log.info("test case executopn start -->redirectToResetPasswordPageLinkPresent");
			LoginPage login=new LoginPage(driver);
			boolean isforgetpassPresent=login.isForgetPassLinkPresent();
			Assert.assertEquals(isforgetpassPresent, true);
		}		
	
		@Test 
		public void CancellationButton()
		{
			log.info("test case executopn start -->CancellationButton");
			LoginPage login=new LoginPage(driver);
			ResetPasswordPage resetPass=login.clickForgetPassLink();
			resetPass.clickCancel();
			boolean isPresent=login.isLoginTextPresent();
			Assert.assertEquals(isPresent, true);
			
			String str=login.getTitle();
			Assert.assertEquals(str,  "Login");

			}
		
	
		}
		



