package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NotifierApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        VBox componentGroup = new VBox();
        componentGroup.setSpacing(10);
        
        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        
        button.setOnAction((event) -> {
            label.setText(textField.getText());
        });
        
        componentGroup.getChildren().addAll(textField, button, label);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }

}
