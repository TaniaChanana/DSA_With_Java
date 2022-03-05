package programs;

import java.util.*;

public class KruskalAlgo {

	public static void main(String[] args) {
		List<NodeG> list = new ArrayList();
		list = create(list);

		TreeMap<Integer, ArrayList<String>> map = new TreeMap();

		for (NodeG node : list) {

			String str = node.source + ":" + node.dest;

			map.putIfAbsent(node.size, new ArrayList());

			map.get(node.size).add(str);

		}

		Map<String, Integer> result = new HashMap<>();

		Set<Integer> set = new HashSet<>();

		for (Integer weight : map.keySet()) {
			List<String> childList = map.get(weight);

			for (String srcDest : childList) {

				if (!cycleDetected(set, srcDest)) {
					
					result.put(srcDest, weight);
					
					String a[] = srcDest.split(":");
					
					set.add(Integer.parseInt(a[0]));
					set.add(Integer.parseInt(a[1]));
				}
			}
		}
		
		System.out.println(result);
	}

	private static boolean cycleDetected(Set<Integer> set, String srcDest) {
		String a[] = srcDest.split(":");
		int src = Integer.parseInt(a[0]);
		int dest = Integer.parseInt(a[1]);
		if(set.contains(src) && set.contains(dest)) {
			return true;
		}
		
		return false;
	}

	private static List<NodeG> create(List<NodeG> list) {

		list.add(new NodeG(0, 1, 4));
		list.add(new NodeG(0, 7, 8));
		list.add(new NodeG(1, 2, 8));
		list.add(new NodeG(2, 1, 8));
		list.add(new NodeG(1, 7, 11));
		list.add(new NodeG(7, 1, 11));
		list.add(new NodeG(2, 3, 7));
		list.add(new NodeG(2, 8, 2));
		list.add(new NodeG(2, 5, 4));
		list.add(new NodeG(7, 8, 7));
		list.add(new NodeG(7, 6, 1));
		list.add(new NodeG(8, 6, 6));
		list.add(new NodeG(8, 7, 7));
		list.add(new NodeG(8, 2, 2));
		list.add(new NodeG(6, 8, 6));
		list.add(new NodeG(6, 7, 1));
		list.add(new NodeG(6, 5, 2));
		list.add(new NodeG(3, 2, 7));
		list.add(new NodeG(3, 5, 14));
		list.add(new NodeG(3, 4, 9));
		list.add(new NodeG(5, 3, 14));
		list.add(new NodeG(5, 2, 4));
		list.add(new NodeG(5, 6, 2));
		list.add(new NodeG(5, 4, 10));
		list.add(new NodeG(4, 3, 9));
		list.add(new NodeG(4, 5, 10));
		return list;
	}
}
