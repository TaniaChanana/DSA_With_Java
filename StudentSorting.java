package programs;

import java.util.*;

public class StudentSorting {

	public static void main(String[] args) {
		List<Student1> list = new ArrayList();
		list.add(new Student1(12,"A" , ""));
		list.add(new Student1(32,"B" , ""));
		list.add(new Student1(2,"C" , ""));
	
		Collections.sort(list);
		
		Collections.sort(list,  new Comparator<Student1>() {

			@Override
			public int compare(Student1 o1, Student1 o2) {
				// TODO Auto-generated method stub
				return o1.age-o2.age;
			}
		
		
		});
		
		
		
		for(Student1 stu : list)
		System.out.println(stu.firstName);
	}

}
