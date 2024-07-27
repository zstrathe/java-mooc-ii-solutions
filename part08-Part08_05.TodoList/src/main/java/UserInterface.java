/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList taskList;
    
    public UserInterface(TodoList todoList, Scanner scanner) {
        this.scanner = scanner;
        this.taskList = todoList;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            
            String command = this.scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("add")) {
                this.commandAdd();
            } else if (command.equals("list")) {
                this.commandList();
            } else if (command.equals("remove")) {
                this.commandRemove();
            }
        }
    }
    
    public void commandAdd() {
        System.out.print("To add: ");
        
        String toAdd = this.scanner.nextLine();
        
        if (!(toAdd.equals(""))) {
            this.taskList.add(toAdd);
        }
    }
    
    public void commandList() {
        this.taskList.print();
    }
    
    public void commandRemove() {
        System.out.print("To remove: ");
        
        int toRem = Integer.valueOf(this.scanner.nextLine());
        
        this.taskList.remove(toRem);
        
    }
    
}
