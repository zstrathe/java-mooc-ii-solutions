
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here
        List<String> testList = new List<>();
        testList.add("test");
        testList.add("Walter");
        testList.add("Bonnie");
        testList.add("Clyde");
        testList.add("Clyde2");
        testList.add("Clyde3");
        testList.add("Clyde4");
        testList.add("Clyde5");
        testList.add("Clyde6");
        testList.add("Clyde7");
        testList.remove("Clyde7");
        System.out.println(testList.size());
        System.out.println(testList.contains("test"));
        System.out.println(testList.toString());
        testList.remove("test");
        System.out.println(testList.size());
        System.out.println(testList.toString());
        System.out.println(testList.contains("test"));
        System.out.println(testList.value(0));
       // System.out.println(testList.value(9));
    }

}
