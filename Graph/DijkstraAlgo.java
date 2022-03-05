package programs;

import java.util.*;

public class DijkstraAlgo {

	public static void main(String[] args) {
	
		List<NodeG> list = new ArrayList();
		list = create(list);
		
		Map<Integer, Map<Integer, Integer>> map = new HashMap();
		
		for(NodeG node : list) {
			
			map.putIfAbsent(node.source, new HashMap());
			
			map.get(node.source).put(node.dest, node.size);
			
		}
		
		boolean[] visited = new boolean[10];
		
		TreeMap<Integer,Integer> resultMap = new TreeMap();
		
		resultMap.put(0,0);
		
		Queue<Integer> queue = new LinkedList();
		
		queue.add(0);
		
		while(queue.size()>0) {
				//Dest key , EdgeSize from Zero source to dest is value
			int source = queue.poll();
			
			visited[source] = true;
			
			Map<Integer,Integer> destEdgeSize = map.get(source);
			
			for (Integer dest:destEdgeSize.keySet()) {
				if (!resultMap.containsKey(dest)) {
					// 
					resultMap.put(dest, destEdgeSize.get(dest)+resultMap.get(source));
				}else {
					int size = resultMap.get(dest);
					int curr = destEdgeSize.get(dest) + resultMap.get(source);   // 5 - 16
					
					resultMap.put(dest, Math.min(curr, size));
				}
				if(!visited[dest])
				queue.add(dest);
			}
		}

		
		System.out.println(resultMap);
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


class NodeG{
	
	int source;
	int dest;
	int size;
	
	
	public NodeG(int source, int dest, int size) {
		super();
		this.source = source;
		this.dest = dest;
		this.size = size;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}