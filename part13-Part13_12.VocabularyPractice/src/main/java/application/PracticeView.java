/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author zack
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PracticeView {
    private VocabDictionary dict;
    String practiceWord;
    int attempts;
    
    public PracticeView(VocabDictionary dict) {
        this.dict = dict;
//        this.practiceWord = dict.getRandomWord();
        this.attempts = 0;
    }
    
    public Parent getView() {
        practiceWord = this.dict.getRandomWord();
        if (practiceWord == null) {
            StackPane nullLayout = new StackPane();
            Label nullErrorLabel = new Label("No words are present in dictionary,\nadd words first before practicing!");
            nullLayout.getChildren().add(nullErrorLabel);
            return nullLayout;
        }
        
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        
        Label word = new Label("Word to translate: " + this.practiceWord);
        TextField input = new TextField();
        Button enter = new Button("Check answer");
        Label result = new Label();
        
        layout.add(word, 0, 0);
        layout.add(input, 0, 1);
        layout.add(enter, 0, 2);
        layout.add(result, 0,3);
        
        enter.setOnMouseClicked((event) -> {
            if (enter.getText() == "Continue") {
                this.attempts = 0;
                practiceWord = this.dict.getRandomWord();
                word.setText("Word to translate: " + practiceWord);
                input.setPromptText("");
                input.setMouseTransparent(false);
                input.setEditable(true);
                result.setText("");
                input.setVisible(true);
                enter.setText("Check answer");
                return;
            }
            String entered = input.getText();
            String correctAnswer = this.dict.getTranslation(this.practiceWord);
            this.attempts++;
            if (entered.equals(correctAnswer)) {
                result.setText("Correct!");   
            } else if (this.attempts < 3) {
                int remainingAttempts = 3 - this.attempts;
                result.setText("Incorrect, try again! " + remainingAttempts + " attempts remaining");
                return;
            } else {
                result.setText("Incorrect! The correct word was " + correctAnswer);
            }
            input.clear();
            input.setPromptText(entered);
            input.setMouseTransparent(true);
            input.setEditable(false);
            
            enter.setText("Continue");
        });
        
        return layout;
    }
    
}
