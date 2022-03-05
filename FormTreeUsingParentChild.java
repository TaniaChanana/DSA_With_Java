package programs;
import java.util.*;

public class FormTreeUsingParentChild {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("2","4");
		map.put("6","4");
		map.put("1","2");
		map.put("3","2");		
		map.put("5","6");
		map.put("7","6");
		
		Set<String> set = new HashSet<>();
		Set<String> child = new HashSet<>();
		
		for (String str : map.keySet()) {
			set.add(str);
			set.add(map.get(str));
			child.add(str);
		}
		String rootFromSet = "";
		
		for (String str:set) {
			if (!child.contains(str))
				rootFromSet = str;
		}
		
		Map<String,List<String>> parentAndChild = new LinkedHashMap<>();
		parentAndChild.put(rootFromSet, new ArrayList());
		List<String> temp;
		for (String str : map.keySet()) {
			if (!parentAndChild.containsKey(map.get(str))) {
				temp = new ArrayList<>();
			}else {
				temp = parentAndChild.get(map.get(str));
			}
			temp.add(str);
			parentAndChild.put(map.get(str), temp);
		}
		
		String str1 = "1";
		String str2 = "3";
		if (str1 == rootFromSet && str2 == rootFromSet)
		{
			System.out.println("0");
			return;
		}
		findDistance(parentAndChild,rootFromSet,str1,str2);
		
	}

	private static void findDistance(Map<String, List<String>> parentAndChild, String rootFromSet, String first, String second) {
		String temp = "";
		if (first == rootFromSet || second == rootFromSet)
			temp = (first == rootFromSet)?second:first;
		int count = 1;
		if (!temp.isEmpty()) {
			count = findDistance(temp,parentAndChild);
		}else {
			
		}
	}

	private static int findDistance(String temp, Map<String, List<String>> parentAndChild) {
		
		return 0;
	}

}
