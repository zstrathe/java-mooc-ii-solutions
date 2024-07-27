package textstatistics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea textArea = new TextArea();
        layout.setCenter(textArea);
        
        HBox statisticsBox = new HBox();
        statisticsBox.setSpacing(10);
        Label charCount = new Label("Letters: ");
        Label wordCount = new Label("Words: ");
        Label longestWord = new Label("The longest word is: ");
        statisticsBox.getChildren().addAll(charCount, wordCount, longestWord);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
                    
            charCount.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);          
        });
        
        layout.setBottom(statisticsBox);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}
