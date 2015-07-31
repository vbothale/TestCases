package utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class TestCaseSorter {

	// Method read all the declared methods in specified class and sort them in
	// proper execution order.
	public static Method[] getDeclaredMethods(Class<?> clazz) {

		Method[] methods = clazz.getDeclaredMethods();

		Arrays.sort(methods, new Comparator<Method>() {
			public int compare(Method method1, Method method2) {
				int stepNum1 = Integer.parseInt(method1.getName().substring(
						method1.getName().indexOf("_") + 1,
						method1.getName().lastIndexOf("_")));
				int stepNum2 = Integer.parseInt(method2.getName().substring(
						method2.getName().indexOf("_") + 1,
						method2.getName().lastIndexOf("_")));
				return stepNum1 != stepNum2 ? stepNum1 - stepNum2 : method1
						.toString().compareTo(method2.toString());
			}
		});

		return methods;
	}

}
