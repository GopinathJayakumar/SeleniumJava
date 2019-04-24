package testNG.listeners.pro;

import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

public class DataProviderListeners implements IDataProviderListener{

	@Override
	public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method,
			ITestContext iTestContext) {
		System.out.println(dataProviderMethod.getIndices());
		
	}

	@Override
	public void afterDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method,
			ITestContext iTestContext) {
		
		
	}

}
