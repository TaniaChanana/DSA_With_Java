package programs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class SingletonTest {

	public static void main(String[] args) {
//
		int gen = Gender.getAgeForGender(Gender.FEMALE);
		System.out.println(gen);
//		Singleton s1 = Singleton.singleton;
//		Singleton s2 = Singleton.singleton;
//		
		Class c1 = Singleton.class;
		
//		Method[] m = c1.getDeclaredMethods();
//		for(Method m1 : m) {
//			System.out.println(m1.getName());
//		}
		Constructor[] con  = c1.getDeclaredConstructors();
		System.out.println(con);
		for(Constructor conn : con) {
			conn.setAccessible(true);
			try {
				System.out.println(conn.newInstance().hashCode() +"    "+ conn.newInstance().hashCode());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		System.out.println(s1.hashCode() +"    "+ s2.hashCode());
	}

}
