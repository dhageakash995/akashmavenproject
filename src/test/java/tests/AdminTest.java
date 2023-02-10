package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;

public class AdminTest extends TestBase {
	
	@Test
	public void checkAdmin()
	{
		LoginPage login =new LoginPage(driver);
		HomePage homepage =login.DoLogin("Admin", "admin123");
		
		AdminPage admin=homepage.ClickAdminLink();
		
		String actual=admin.getAdminTitle();
		
		Assert.assertEquals(actual, Constants.ADMIN_USERMANAGEMENT_HEADER);
		
		
	
	}

}
