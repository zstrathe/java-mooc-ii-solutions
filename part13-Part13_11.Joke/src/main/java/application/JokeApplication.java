package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(JokeApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        // 1. Create main layout
        BorderPane layout = new BorderPane();

        // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Create buttons for menu
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(joke, answer, explanation);

        layout.setTop(menu);


        // 2. Add subviews and add them to the menu buttons
        // 2.1. Create subview layout
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Isn't it obvious, stupid?");

        // 2.2. Add subviews to button. Pressing the buttons will change the view
        joke.setOnAction((event) -> layout.setCenter(jokeLayout));
        answer.setOnAction((event) -> layout.setCenter(answerLayout));
        explanation.setOnAction((event) -> layout.setCenter(explanationLayout));

        // 2.3. Set initial view
        layout.setCenter(jokeLayout);

        // 3. Create main scene with layout 
        Scene scene = new Scene(layout);

        // 4. Show the main scene
        window.setScene(scene);
        window.show();
     
    }
    
    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label("tesst1"));
        layout.getChildren().add(new Label(text));
        layout.getChildren().add(new Label("test2"));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

}
