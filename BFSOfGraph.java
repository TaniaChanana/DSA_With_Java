package programs;

import java.util.*;

public class BFSOfGraph {

	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    BFSOfGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
	
    public void addEdge(int v,int w) {
    	adj[v].add(w);
    }
    
    public void BFS(int source) {
    	boolean visited[] = new boolean[V];
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(source);
    	
    	visited[source] = true;
    	while(q.size()>0) {
    		
    		int value = q.poll();
    		System.out.println(value);
    		Iterator<Integer> itr = adj[value].listIterator();
    		while(itr.hasNext()) {
    			int n = itr.next();
    			if (visited[n]!=true) {
    				visited[n] = true;
    				q.add(n);
    			}
    		}
    	}
    }
    
    public void DFS(int source) {
    	boolean visited[] = new boolean[V];
    	
    	DFSUtil(source,visited);
    }
    
    public void DFSUtil(int source,boolean[] visited) {
    	
    	if(visited[source] == true)
    		return ;

    	visited[source] = true;
    	System.out.println(source);
    	Iterator<Integer> itr = adj[source].listIterator();
    	while(itr.hasNext()) {
    		int n = itr.next();
    		if(!visited[n])
    			DFSUtil(n,visited);
    	}
    }
    
	public static void main(String[] args) {
		BFSOfGraph g = new BFSOfGraph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.BFS(2);
        g.DFS(2);
	}

}
