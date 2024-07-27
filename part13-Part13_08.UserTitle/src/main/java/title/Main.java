package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title for the application window:");
        String windowTitle = scanner.nextLine();
        String windowTitleParam = "--title=" + windowTitle;
        Application.launch(UserTitle.class, windowTitleParam); 
    }

}
