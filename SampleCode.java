package programs;

public class SampleCode {

	public static void main(String[] args) {
		/*
		 * If we want to print the multiples of 2 from 1 to 10 then we can do it with the help of running a for loop from 1 to 10 
		 * and then inside it check if it is multiple of 2 or not if yes then prints something or else print some other thing.
		 */
		
		for(int i=1;i<=10;i++) {
			if(i%2 == 0) {
				System.out.println(i+" is a multiple of 2");
			}else {
				System.out.println(i+" is not a multiple of 2");
			}			
		}
	}

}
