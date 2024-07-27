package buttonandtextfield;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        Button button = new Button("Hi Walter!");
        TextField text = new TextField("How are you today??");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().addAll(button, text);
        
        Scene scene = new Scene(componentGroup);
        
        window.setScene(scene);
        window.show();
    }

}
