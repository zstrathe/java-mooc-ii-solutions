package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        GameLogic gameLogic = new GameLogic();
        
        BorderPane mainLayout = new BorderPane();
        
        // add turn status to top of window
        Label turnStatus = new Label("Turn: " + gameLogic.getCurrentPlayer());
        turnStatus.setFont(Font.font("Monospaced", 40));
        mainLayout.setTop(turnStatus);
        
        // setup 3x3 grid
        GridPane playGrid = new GridPane();
        playGrid.setPadding(new Insets(10, 10, 10, 10));
        playGrid.setHgap(10);
        playGrid.setVgap(10);
        Button[][] buttons = new Button[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button(" ");
                Button btn = buttons[row][col];
                btn.setFont(Font.font("Monospaced", 40));
                playGrid.add(btn, col, row);
                int btnRow = row;
                int btnCol = col;
                btn.setOnMouseClicked((event) -> {
                    // check if the game is already finished first so that nothing further will happen
                    if (gameLogic.gameOver() == true) {
                        return;
                    }
               
                    // try to play a move (mark as X or O, depending on current player)
                    // if move is possible (square empty), then check for win condition
                    // then change player for next turn
                    if (gameLogic.playMove(btnRow, btnCol) == true) {
                        btn.setText(gameLogic.getCurrentPlayer());
                        if (gameLogic.gameOver() == true) {
                            //turnStatus.setText("WINNER: " + gameLogic.getCurrentPlayer());
                            turnStatus.setText("The end!");
                            return;
                        }
                        gameLogic.changePlayer();
                        turnStatus.setText("Turn: " + gameLogic.getCurrentPlayer());
                    // if move was not possible, then do nothing and return 
                    // to continue current player's turn
                    } else {
                        return;
                    }
                });
            }
        }
        mainLayout.setCenter(playGrid);
        
        // setup the scene and stage
        Scene scene = new Scene(mainLayout);
        window.setScene(scene);
        window.show();
        
        
    }

}
