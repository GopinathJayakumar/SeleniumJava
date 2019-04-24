package ja.collections.pro;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class sample {
	
	public static void main(String[] args) {			
		
		Map<Character, Integer> m = new HashMap<>();
		Map<Character, Integer> maxEntry = new HashMap<>();
		m.put('s', 5);
		m.put('v', 3);
		m.put('h', 1);	
		
		int max =0;
		for (Entry<Character, Integer> x : m.entrySet()) {
			if(x.getValue()>max) {
				maxEntry.clear();
				maxEntry.put(x.getKey(), x.getValue());
				max= x.getValue();
			}
		}
		
		System.out.println(maxEntry);
		
		
		
		
		
		
		
		
		
		
		/*Map<Character, Integer> m = new HashMap<>();
		m.put('s', 5);
		m.put('v', 3);
		m.put('h', 1);		
		
		List<Integer> ls = new ArrayList<>();		
		for (Entry<Character, Integer> x : m.entrySet()) {
			ls.add(x.getValue());
		}		
		Collections.sort(ls);		
		Integer lastVal = ls.get(ls.size()-1);
		
		for (Entry<Character, Integer> x : m.entrySet()) {
			if(x.getValue()==lastVal) {
				System.out.println(x.getKey());
			}
		}
		*/
			
	}
	/*String txt = "test";
	
	char[] ch = txt.toCharArray();
	
	Map<Character, Integer> m = new HashMap<>();
	
	for (char c : ch) {
		if(m.containsKey(c)) {
			m.put(c, m.get(c)+1);
		}else {
			m.put(c, 1);
		}
	}

	System.out.println(m);*/
	

}
