package testNG.listeners.pro;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
	
	int i = 1;
	int max_Count = 3;

	@Override
	public boolean retry(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE && i<=3) {			
			try {
				Thread.sleep(2000);
				System.out.println(String.format(""+result.getMethod(), result.getName()));
				System.out.println(i);
				i++;
				return true;				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;
	}
}
