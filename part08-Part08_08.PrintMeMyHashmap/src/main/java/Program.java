
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }
    
    public static void printKeys(HashMap<String, String> hashMap) {
        for (String key: hashMap.keySet()) {
            System.out.println(key);
        }
    }
    
    public static void printKeysWhere(HashMap<String, String> hashMap, String text) {
        for (String key: hashMap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
    }
    
    public static void printValuesOfKeysWhere(HashMap<String, String> hashMap, String text) {
        for (String key: hashMap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashMap.get(key));
            }
        }
    }

}
