package smiley;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        // define the canvas and painter
        Canvas canvas = new Canvas(700, 700);
        GraphicsContext painter = canvas.getGraphicsContext2D();

        // define layout and add canvas to it
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        
        // draw the smiley face
        drawSmiley(painter);
        
        // setup scene and stage
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    
    public void drawSmiley(GraphicsContext painter) {
        // define dimensions
        int unitWidth = 80;
        int topPadding = 100;
        int sidePadding = 85;
        int bottomPadding = 120;
        
        int canvasWidth = (int)painter.getCanvas().getWidth();
        int canvasHeight = (int)painter.getCanvas().getHeight();
        
        // calculate starting point for each eye
        // from top-left corner of each component
        int leftEyeXPos = (canvasWidth/3) - unitWidth;
        int rightEyeXPos = canvasWidth - (canvasWidth/3);
        int bothEyeYPos = topPadding;
        
        // calculate the starting point for each component of mouth
        // from top-left corner of each component
        int middleSmileYPos = canvasHeight - bottomPadding - unitWidth;
        int middleSmileXPos = unitWidth + sidePadding;
        int middleSmileWidth = canvasWidth - unitWidth*2 - sidePadding*2;
        int leftSmileXPos = sidePadding;
        int leftSmileYPos = middleSmileYPos - unitWidth;
        int rightSmileXPos = canvasWidth - sidePadding - unitWidth;
        int rightSmileYPos = leftSmileYPos;
   
        // fill the background white
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, canvasWidth, canvasHeight);
        
        // iterate through the parts (squares) to draw for the smile
        painter.setFill(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            if (i==0) {
                // draw the left eye
                painter.fillRect(leftEyeXPos, bothEyeYPos, unitWidth, unitWidth);
            }
            if (i==1) {
                // draw the right eye
                painter.fillRect(rightEyeXPos, bothEyeYPos, unitWidth, unitWidth);
            }
            if (i==2) {
                // draw the left part of the smile
                painter.fillRect(leftSmileXPos, leftSmileYPos, unitWidth, unitWidth);
            }
            if (i==3) {
                // draw the middle part of the smile
                painter.fillRect(middleSmileXPos, middleSmileYPos, middleSmileWidth, unitWidth);
            }
            if (i==4) {
                // draw the right part of the smile
                painter.fillRect(rightSmileXPos, rightSmileYPos, unitWidth, unitWidth);
            }
        }
        
        
    }

}
