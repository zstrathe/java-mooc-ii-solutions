import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your test code here
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie);
 
        ollie.study();
        System.out.println(ollie);
        
        Counter counter = new Counter();
        Counter superCounter = new SuperCounter();
        int number = 3;
        number = superCounter.subtractFromNumber(number);
        number = superCounter.subtractFromNumber(number);
        number = superCounter.addToNumber(number);
        System.out.println(number);
    
    }
    
    public static void printPersons(ArrayList<Person> persons) {
        for (Person p: persons) {
            System.out.println(p);
        }
    }

}
