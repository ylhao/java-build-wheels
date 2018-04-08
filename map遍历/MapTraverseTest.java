import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTraverseTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("01", "zhangsan");
		map.put("02", "lisi");
		map.put("03", "wangwu");

		Collection<String> collection = map.values();
		System.out.println(collection);
		for(String s : collection) {
			System.out.println(s);
		}

		Set<String> keySet = map.keySet();
		Iterator<String> it1 = keySet.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			String value = map.get(key);
			System.out.println(key + ": " + value);
		}

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> me = it2.next();
		    String key = me.getKey();
		    String value = me.getValue();
		    System.out.println(key + ": " + value);
		}
	}
}

