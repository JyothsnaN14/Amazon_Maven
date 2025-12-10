package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerlogic implements IRetryAnalyzer{
int initial_count=0;
int retry_count=2;
	@Override
	public boolean retry(ITestResult result) {
		if(initial_count<retry_count) {
			initial_count ++;
			return true;
		}
		return false;
	}

}
