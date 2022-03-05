package programs;
import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class PrintTree {
	
	public static TreeNodee root;
	public static Map<String,List<String>> map = new HashMap<>();
	
	public static void main(String[] args) {
		List<Relation> input = new ArrayList<>();
		input.add(new Relation("animal","mammal"));
		input.add(new Relation("animal","bird"));
		input.add(new Relation("lifeform","animal"));
		input.add(new Relation("cat","lion"));
		input.add(new Relation("mammal","cat"));
		input.add(new Relation("animal","fish"));
		
		Set<String> set= new HashSet<>();
		
		String rootFromSet = "";
		Set<String> allChilds = new HashSet();
		
		for (Relation l:input) {
			set.add(l.parent);
			set.add(l.child);
			
			allChilds.add(l.child);
			
			if(!map.containsKey(l.parent)) {
				List<String> temp = new ArrayList<>();
				temp.add(l.child);
				map.put(l.parent, temp);
			}else {
				List<String> t1 = map.get(l.parent);
				t1.add(l.child);
				map.put(l.parent, t1);
			}
		}
		boolean flag = false;
		TreeNodee temp = null;
		
		for(String str : set) {
			if(!allChilds.contains(str)) {
				rootFromSet = str;
				break;
			}
		}
		
		root = new TreeNodee(rootFromSet,new ArrayList<>());
		fillTree(root);
		printTree(root);
		
	}
	private static void printTree(TreeNodee root2) {
		if (root2.childern.isEmpty()) {
			return;
		}
		
		
		for (int i=0;i<root2.childern.size();i++) {
			System.out.print(root2.data + " : " + root2.childern.get(i).data + " ");
			printTree(root2.childern.get(i));
		}
		
		System.out.println();
	}
	private static void fillTree(TreeNodee root2) {
		if ((!map.containsKey(root2.data)))
			return;
		
		List<String> child = map.get(root2.data);
		for (int i=0;i<child.size();i++) {
			TreeNodee childernOfNode = new TreeNodee(child.get(i),new ArrayList<>());
			root2.childern.add(childernOfNode);
			fillTree(childernOfNode);
		}
	}

}


class Relation {
	String parent;
	String child;
	public Relation(String parent, String child) {
		super();
		this.parent = parent;
		this.child = child;
	}
	
}

class TreeNodee{
	String data;
	List<TreeNodee> childern = new ArrayList<>();

	public TreeNodee(String data, List<TreeNodee> childern) {
		super();
		this.data = data;
		this.childern = childern;
	}
	
}
