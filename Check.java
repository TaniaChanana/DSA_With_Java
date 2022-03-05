package programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Check {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
//				 return o1-o2 ;
			}
			
		});
		
		queue.add(2);
		queue.add(18);
		System.out.println(queue);
		
		queue.add(14);
		System.out.println(queue);
		queue.add(6);
		System.out.println(queue);
		queue.add(1);
		System.out.println(queue);

	}

}
