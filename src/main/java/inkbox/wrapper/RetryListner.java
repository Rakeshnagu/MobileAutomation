package inkbox.wrapper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) { // Check if test not succeed
            if (retryCount < maxRetryCount) {
                iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed
                retryCount++;
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE); // If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
        }
        return false;
    }
}
