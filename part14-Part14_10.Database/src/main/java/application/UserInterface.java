package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit") || command.equals("x")) {
                break;
            }
            
            if (command.equals("list") || command.equals("1")) {
                System.out.println("Listing the database contents");
                database.list().forEach(todo -> System.out.println(todo.toString()));
            }
            if (command.equals("add") || command.equals("2")) {
                System.out.println("Adding a new todo");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                Todo newTodo = new Todo(name, description, false);
                database.add(newTodo);
            }
            if (command.equals("mark as done") || command.equals("3")) {
                System.out.print("Which todo should be marked as done (give the id)?: ");
                database.markAsDone(Integer.valueOf(scanner.nextLine()));
            }
            if (command.equals("remove") || command.equals("4")) {
                System.out.print("Which todo should be removed (give the id)?: ");
                database.remove(Integer.valueOf(scanner.nextLine()));
            }
            
        }

        System.out.println("Thank you!");
    }

}
