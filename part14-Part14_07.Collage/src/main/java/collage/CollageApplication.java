package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);
                
                //top left
                imageWriter.setColor(xCoordinate/2, yCoordinate/2, newColor);
                //top right
                imageWriter.setColor(width/2 + xCoordinate/2, yCoordinate/2, newColor);
                //bottom left
                imageWriter.setColor(xCoordinate/2, height/2 + yCoordinate/2, newColor);
                //bottom right
                imageWriter.setColor(width/2 + xCoordinate/2, height/2 + yCoordinate/2, newColor);

                xCoordinate+=2;
            }

            yCoordinate+=2;
        }
        
        int newWidth = (int) targetImage.getWidth();
        int newHeight = (int) targetImage.getHeight();
        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);
        
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
