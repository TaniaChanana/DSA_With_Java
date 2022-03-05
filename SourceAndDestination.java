package programs;

import java.util.HashMap;
import java.util.HashSet;

public class SourceAndDestination {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Chennai", "Banglore");
		map.put("Bombay", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");

		HashMap<String, String> reverseMap = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		for (String str : map.keySet()) {
			String value = map.get(str);
			set.add(str);
			set.add(value);
			reverseMap.put(value, str);
		}

		String source = "";
		String destination = "";
		for (String str : set) {
			if (!map.containsKey(str)) {
				destination = str;
			} else if (!reverseMap.containsKey(str)) {
				source = str;
			}

			if ((!source.isEmpty()) && (!destination.isEmpty())) {
				break;
			}
		}

		if (source.isEmpty() && destination.isEmpty()) {
			System.out.println("Cycle exist");
		} else {
			System.out.println("Source is : " + source);
			System.out.println("Destination is : " + destination);
		}
	}
}
