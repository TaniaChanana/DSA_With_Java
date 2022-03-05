package programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BagSolutionPrioritQueue {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;   //max heap
				// return o1-o2 min heap
			}
			
		});
////		
//		PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				String c1 = ""+o1.charAt(2);
//				String c2 = ""+o2.charAt(2);
//				System.out.println(c1 + "---"+ c2);
//				return c2.compareTo(c1);
//				// return o1-o2 min heap
//			}
//			
//		});
//		
		
//		
//		
//		
//		queue.add("A:2");
//		queue.add("B:3");
//		queue.add("C:1");
//		queue.add("D:4");
//		System.out.println(queue);
//		while(!queue.isEmpty()) {
//			String str = queue.poll();
//			System.out.print(str.charAt(0)+"   ");
//		}
//		
//		
//		queue.add(20);
//		queue.add(21);
//		System.out.println(queue);
//		for (int i:queue) {
//			System.out.println(i);
//		}
		queue.add(2);
		queue.add(8);
		queue.add(6);
		queue.add(4);
		queue.add(10);
		System.out.println(queue);
		
//		int max = 0;
//		for (int i=0;i<5;i++) {
//			int val = queue.poll();
//			max+=val;
//			queue.add(val/2);
//		}
//		System.out.println(max);
	}

}
