package buttonandlabel;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        Label label = new Label("Hi Walter");
        Button button = new Button("How are you today?");
        
        FlowPane compGroup = new FlowPane();
        compGroup.getChildren().addAll(label, button);
        
        Scene scene = new Scene(compGroup);
        
        window.setScene(scene);
        window.show();
    }

}
