
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = inputBooks(scanner);
        System.out.println("");
        System.out.println(countBooks(books) + " books in total.");
        System.out.println("");
        sortBooks(books);
        printBooks(books);
        
    }
    
    public static ArrayList<Book> inputBooks(Scanner scanner) {
        ArrayList<Book> books = new ArrayList<>();
        while (true) {
            System.out.print("\nInput the name of the book, empty stops: ");
            String bookTitle = scanner.nextLine();
            if (bookTitle.equals("")) {
                break;
            }
            System.out.print("Imput the age recommendation: ");
            int ageRec = Integer.valueOf(scanner.nextLine());
            books.add(new Book(bookTitle, ageRec));
        }
        return books;
    }
    
    public static long countBooks(ArrayList<Book> books) {
        long numBooks = books.stream().count();
        return numBooks;
    }
    
    public static void printBooks(ArrayList<Book> books) {
        System.out.println("Books:");
        books.stream()
                .forEach(b -> System.out.println(b));
    }
    
    public static void sortBooks(ArrayList<Book> books) {
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRec)
                .thenComparing(Book::getTitle);
        
        Collections.sort(books, comparator);
    }

}
