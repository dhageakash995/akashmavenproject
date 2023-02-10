package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResetPasswordPage;
import testbase.TestBase;
import util.Constants;

public class ResetPasstest extends TestBase{
	
	@Test
	public void navigateToResetPassword() 
	{
		LoginPage login=new LoginPage(driver);
		ResetPasswordPage resetPass=login.clickForgetPassLink();
				
		boolean isPresent=resetPass.isResetPassTextPresent();
		Assert.assertEquals(isPresent, true);
		
		String actual=resetPass.getResetPassText();
		Assert.assertEquals(actual,  Constants.RESET_PASS_TEXT);

	}

}
