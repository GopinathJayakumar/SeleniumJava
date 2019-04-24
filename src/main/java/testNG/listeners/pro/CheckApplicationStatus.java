package testNG.listeners.pro;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CheckApplicationStatus implements ISuiteListener{

	@Override()
	public void onStart(ISuite suite) {
		System.out.println("Check Appliation Status");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
