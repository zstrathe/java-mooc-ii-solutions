package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        VBox firstView = new VBox();
        Label firstLabel = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");
        firstView.setSpacing(15);
        firstView.setAlignment(Pos.CENTER);
        firstView.setPrefSize(300, 300);
        firstView.getChildren().addAll(firstLabel, nameField, startButton);
        Scene firstScene = new Scene(firstView);
        
        BorderPane secondView = new BorderPane();
        secondView.setPrefSize(300, 300);
        Label welcomeText = new Label();
        secondView.setCenter(welcomeText);
        Scene secondScene = new Scene(secondView);
        
        startButton.setOnAction((event) -> {
            welcomeText.setText("Welcome " + nameField.getText() + "!");
            window.setScene(secondScene);
        });
        
        window.setScene(firstScene);
        window.show();
    }
}
