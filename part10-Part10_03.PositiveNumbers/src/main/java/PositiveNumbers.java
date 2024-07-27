
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        System.out.println("Enter numbers. \"q\" to quit.");
        ArrayList<Integer> intList = new ArrayList<>();
        while (true) {
            String num = scanner.nextLine();
            if (num.equals("q")) {
                break;
            }
            intList.add(Integer.valueOf(num));
        }
        System.out.println("Entered numbers: " + intList);
        System.out.println("Positive numbers: " + positive(intList));
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(i -> i > 0).collect(Collectors.toList());
    }

}
