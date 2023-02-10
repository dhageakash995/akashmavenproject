package tests;

import testbase.TestBase;
import util.Constants;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AttendancePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TimeTimesheetPage;

public class TimeSheetTest extends TestBase{
	
	
	@Test
	public void TimesheetTest1() throws InterruptedException
	{
		LoginPage login =new LoginPage(driver);
		HomePage homepage =login.DoLogin("Admin", "admin123");
		Assert.assertEquals(homepage.isUserNamePresent(), true);
		
		TimeTimesheetPage timesheetpage=homepage.clickLink();
		String actual=timesheetpage.getTitle();
		Assert.assertEquals(actual, Constants.TIMESHEET_HEADER);
		
		AttendancePage attPage=	timesheetpage.clickMyReports();
		
		boolean actualFlag=attPage.isHeaderCorrect("Attendance", "Attendance")	;
		Assert.assertEquals(actualFlag, true);
	}
	
	

}
