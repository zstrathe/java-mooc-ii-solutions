package textstatistics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        
        HBox bottomText = new HBox();
        bottomText.setSpacing(10);
        bottomText.getChildren().add(new Label("Letters: 0"));
        bottomText.getChildren().add(new Label("Words: 0"));
        bottomText.getChildren().add(new Label("The longest word is:"));
        
        layout.setBottom(bottomText);
        layout.setCenter(new TextArea());
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
}
