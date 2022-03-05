package programs;

import java.io.Serializable;

public class Singleton implements Cloneable, Runnable , Serializable{

	public static Singleton singleton = null;
	String name;

	private Singleton() {

	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public synchronized static Singleton getInstance() {
		if (singleton == null) {
			if (singleton == null) // double checking for synchornization 
				singleton = new Singleton();
		}

		return singleton;
	}

	@Override
	public Singleton clone() throws CloneNotSupportedException {

		return singleton;
	}

	@Override
	public void run() {

	}
	
	protected Object readResolve() {
		return singleton;
	}

}
