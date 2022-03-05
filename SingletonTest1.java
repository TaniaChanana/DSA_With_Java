package programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonTest1 {

	public static void main(String[] args) {

		// ------- clonable -------------------//
		Singleton s1 = Singleton.getInstance();
		Singleton s2;
		try {
			s2 = s1.clone();
			System.out.println(s1.hashCode() + "   " + s2.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// --------- Threading --------------//
//		Thread s3 = new Thread(Singleton.class);  
//		s3.start(); --  Lazy intialztion ,  synchorization , double checking

		// Serialization
		try {
		
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\jyoti\\OneDrive\\Desktop\\1.txt"));
			ObjectOutputStream oo =  new ObjectOutputStream(out);
			Singleton s4 = Singleton.getInstance();
			System.out.println(s4.hashCode());
			s4.setName("Tani");
			oo.writeObject(s4);

			FileInputStream fin = new FileInputStream(new File("C:\\Users\\jyoti\\OneDrive\\Desktop\\1.txt"));
			ObjectInputStream oin = new ObjectInputStream(fin);
			Singleton obj = (Singleton) oin.readObject();
			System.out.println(obj.hashCode());
			
			System.out.println(obj.getName());
			// fin.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
