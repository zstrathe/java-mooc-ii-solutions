
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        while (true) {
            String usrInput = scanner.nextLine();
            if (usrInput.equals("")) {
                break;
            }
            inputList.add(usrInput);
        }
        printInput(inputList);
    }
    
    public static void printInput(ArrayList<String> list) {
        list.stream()
            .forEach(s -> System.out.println(s));
    }
}
