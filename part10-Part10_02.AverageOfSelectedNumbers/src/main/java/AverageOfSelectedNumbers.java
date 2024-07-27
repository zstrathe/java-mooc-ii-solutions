
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        System.out.println("Input numbers, type \"end\" to stop.");
        ArrayList<String> numbers = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            numbers.add(input);
        }
        System.out.println("Print the average of the negative or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        double posAverage = numbers.stream().mapToInt(s -> Integer.valueOf(s))
                .filter(num -> num > 0).average().getAsDouble();
        
        double negAverage = numbers.stream().mapToInt(s -> Integer.valueOf(s))
                .filter(num -> num < 0).average().getAsDouble();
        
        System.out.print("Average of the numbers: ");
        if (choice.equals("n")) {
            System.out.print(negAverage);
        } else  {
            System.out.print(posAverage);
        }

    }
}
