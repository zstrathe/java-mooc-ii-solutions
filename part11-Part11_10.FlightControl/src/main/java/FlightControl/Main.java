package FlightControl;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControl.ui.TextUI ui = new FlightControl.ui.TextUI(scanner);
        ui.startUI();
    }
}