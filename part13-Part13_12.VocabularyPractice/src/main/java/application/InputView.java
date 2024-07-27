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
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputView {
    private VocabDictionary dict;
    
    public InputView(VocabDictionary dictionary) {
        this.dict = dictionary;
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        
        Label wordInstruction = new Label("Enter word:");
        TextField wordInput = new TextField();
        Label translationInstruction = new Label("Enter translation:");
        TextField translationInput = new TextField();
        Button enterButton = new Button("Add word pair");
        
        layout.add(wordInstruction, 0, 0);
        layout.add(wordInput, 1, 0);
        layout.add(translationInstruction, 0, 2);
        layout.add(translationInput, 1, 2);
        layout.add(enterButton, 0, 3);
        
        enterButton.setOnMouseClicked((event) -> {
            String wordToAdd = wordInput.getText();
            String translationToAdd = translationInput.getText();
            this.dict.addWord(wordToAdd, translationToAdd);
            
            wordInput.clear();
            translationInput.clear();
        });
        
        return layout;
    }
}
