package ja.reflection.pro;

import java.lang.reflect.Method;

public class LearnReflection {

	public static void main(String[] args) throws ClassNotFoundException {
//Way 1
		Class<?> wrapper = Class.forName("wdMethods.SeMethods");		
		Method[] methods = wrapper.getDeclaredMethods();				
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
//Way 2		
	//	Class<SeMethods> sm = wdMethods.SeMethods.class;
		Method[] allMethods = wrapper.getDeclaredMethods();

		for (Method method1 : allMethods) {
			System.out.println(method1.getName());
		}


	}

}
