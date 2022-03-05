package programs;

import java.lang.*;
import java.lang.reflect.Method;


public class DynamicClassLoading {

	public static void main(String[] args) {
		
		try {
			Class obj = Class.forName("AddTwoLinkedList");
			for(Method meth : obj.getDeclaredMethods()) {
				System.out.println(meth.getName());
			}
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
