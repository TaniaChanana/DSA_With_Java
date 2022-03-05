package programs;

import java.util.*;

public class CPUScheduling {
	
	public static void main(String[] args) {
		
		List<CPUProcess> list = new ArrayList();
		
		list.add(new CPUProcess(10,13,15));
		list.add(new CPUProcess(11,12,10));
		list.add(new CPUProcess(13,16,20));
		list.add(new CPUProcess(14,15,18));
		
		int[] st = new int[4];
		int[] et = new int[4];
		int total = 50;
		int i=0;
		HashMap<Integer,Integer> map = new HashMap();
		
		for (CPUProcess process:list) {
			st[i] = process.startTime;
			et[i] = process.endTime;
			map.put(i, process.noOfCPU);
			i++;
		}
		Arrays.sort(st);
		Arrays.sort(et);
//		for(int y:et)
//			System.out.println(y);
		int reqCPU = 0;
		int maxSoFar = 0;
		i=0;
		int j=0;
		while(i<st.length) {
			if (st[i]<=et[j]) {
				reqCPU+=map.get(i);
				i++;
			}else if(et[j]<st[i]) {
				reqCPU-=map.get(j);
				j++;
			}
			if (maxSoFar<reqCPU)
				maxSoFar = reqCPU;
			if (maxSoFar>total)
			{
				System.out.println("unsufficient amount of cpu");
				return ;
			}
		}
		
		if (maxSoFar<=total) {
			System.out.println("cpu are sufficient");
			System.out.println("all processes are executed only with "+maxSoFar+" cpus");
		}
	}

}
