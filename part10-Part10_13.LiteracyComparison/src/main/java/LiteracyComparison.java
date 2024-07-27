
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        readCSV("literacy.csv");
    }
    
    public static void readCSV(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(filename))
                    .map(l -> l.split(","))
                    .filter(parts -> parts.length == 6)
                    .map(parts -> new LiteracyStatistic(
                            parts[4],
                            parts[3],
                            parts[2],
                            parts[5]))
                    .sorted((s1, s2) -> {
                        return s1.getLiteracyRate().compareTo(s2.getLiteracyRate());
                    })
                    .forEach(s -> System.out.println(s));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
