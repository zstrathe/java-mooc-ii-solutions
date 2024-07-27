
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        Pair pairOne = new Pair("Walter", "cat");
        Pair pairTwo = new Pair("Bonnie", "cat");
        Pair pairThree = new Pair("Clyde", "cat");
        Pair pairFour = new Pair("Simon", "dog");
        
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.add("Walter", "cat");
        hashMap.add("Bonnie", "cat");
        hashMap.add("Clyde", "cat");
        hashMap.add("Simon", "dog");
        System.out.println(hashMap.toString());
        hashMap.remove("Simon", "dog");
        for (int i = 0; i < 200000000; i++) {
            hashMap.add("name" + i, "animal" + i);
        }
        long startTime = System.nanoTime();
        System.out.println(hashMap.get("name15488"));
        long endTime = System.nanoTime();
        long searchTime = endTime - startTime;
        System.out.println("Lookup time: " + searchTime / 1000000 + " ms (" + searchTime + " nanoseconds)");
    }

}
