package testCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAn implements IRetryAnalyzer {
	int count=0;
	@Override
	public boolean retry(ITestResult result)
	{
		
		if(count<2)
		{
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	
}
