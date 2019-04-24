package testNG.listeners.pro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class OverrideCount implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		if(testMethod.getName().equals("createContact")){			
			annotation.setInvocationCount(1);					
			//annotation.setEnabled(false);
		} else if(testMethod.getName().equals("deleteContact")){			
			annotation.setDependsOnMethods(null);
		} 
		
	}
	
	
	

}
