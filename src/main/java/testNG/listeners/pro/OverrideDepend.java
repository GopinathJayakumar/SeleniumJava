package testNG.listeners.pro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class OverrideDepend implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {	
		if(testMethod.getName().equals("deleteContact")){			
			annotation.setDependsOnMethods(null);
		} 
	}
}
