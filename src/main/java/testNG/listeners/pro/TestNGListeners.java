package testNG.listeners.pro;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestNGListeners implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Welcome");
	}
	
	
	

}
