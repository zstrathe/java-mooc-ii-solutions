
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intList = new ArrayList<>();
        while (true) {
            int usrInput = Integer.valueOf(scanner.nextLine());
            if (usrInput < 0) {
                break;
            }
            intList.add(usrInput);
        }
        limitNumbers(intList);
    }
    
    public static void limitNumbers(ArrayList<Integer> inputList) {
        inputList.stream()
                .filter(i -> i >= 1 && i <= 5)
                .forEach(i -> System.out.println(i));
    }
}
