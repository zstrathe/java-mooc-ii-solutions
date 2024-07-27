package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    private VocabDictionary dictionary;

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
    
    @Override
    public void init() {
        this.dictionary = new VocabDictionary();
    }
    
    @Override
    public void start(Stage window) {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(300, 150);
        
        HBox menuLayout = new HBox();
        Button inputButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        menuLayout.getChildren().addAll(inputButton, practiceButton);
        
        mainLayout.setTop(menuLayout);
        
        inputButton.setOnMouseClicked((event) -> {
            mainLayout.setCenter(inputView.getView());
        });
        
        practiceButton.setOnMouseClicked((event) -> {   
            mainLayout.setCenter(practiceView.getView());
        });
        
        mainLayout.setCenter(inputView.getView());
        
        Scene scene = new Scene(mainLayout);
        window.setScene(scene);
        window.show();
    }
}
