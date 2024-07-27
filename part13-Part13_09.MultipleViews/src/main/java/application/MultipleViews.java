package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
    
    @Override
    public void start(Stage window) {
        BorderPane firstGroup = new BorderPane();
        Label firstSceneText = new Label("First view!");
        Button firstSceneButton = new Button("To the second view!");
        firstGroup.setTop(firstSceneText);
        firstGroup.setCenter(firstSceneButton);
        Scene firstScene = new Scene(firstGroup);
        
        VBox secondGroup = new VBox();
        secondGroup.setSpacing(10);
        Button secondSceneButton = new Button("To the third view!");
        Label secondSceneText = new Label("Second view!");
        secondGroup.getChildren().addAll(secondSceneButton, secondSceneText);
        Scene secondScene = new Scene(secondGroup);
        
        GridPane thirdGroup = new GridPane();
        Label thirdSceneText = new Label("Third view!");
        Button thirdSceneButton = new Button("To the first view!");
        thirdGroup.add(thirdSceneText, 0, 0);
        thirdGroup.add(thirdSceneButton, 1, 1);
        Scene thirdScene = new Scene(thirdGroup);
        
        firstSceneButton.setOnAction((event) -> {
            window.setScene(secondScene);
        });
        
        secondSceneButton.setOnAction((event) -> {
            window.setScene(thirdScene);
        });
        
        thirdSceneButton.setOnAction((event) -> {
            window.setScene(firstScene);
        });
        
        window.setScene(firstScene);
        window.show();
    }

}
