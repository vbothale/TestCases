package utility;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod invokeMethod, ITestResult result) {
		if (result.getThrowable() != null) {
			result.setThrowable(null);
			result.setStatus(ITestResult.FAILURE);
		}

	}

	@Override
	public void beforeInvocation(IInvokedMethod invokeMethod, ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext testContext) {
		Reporter.log("Execution completed ::" + testContext.getName(), true);
		

	}

	@Override
	public void onStart(ITestContext testContext) {
		Reporter.log("Execution starts ::" + testContext.getName(),
true);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {

	}

	@SuppressWarnings("unused")
	private void printTestResults(ITestResult result) {
		Reporter.log("TestName = " + result.getTestName(), true);
		Reporter.log("Test Method resides in "
				+ result.getTestClass().getName(), true);
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}
			Reporter.log(
					"Test Method had the following parameters : " + params,
					true);
		}
		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

}
