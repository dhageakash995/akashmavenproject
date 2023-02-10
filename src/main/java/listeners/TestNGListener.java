package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{

	public void onTestStart(ITestResult result) {
	
		System.out.println("onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("onTestFailure");
			}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.err.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("onTestFailedWithTimeout");
	}

	public void onStart(ITestContext context) {
		
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
	
		System.out.println("onFinish");
	}
	
	

}
