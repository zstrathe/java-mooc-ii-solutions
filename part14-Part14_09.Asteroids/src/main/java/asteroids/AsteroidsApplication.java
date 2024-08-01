package asteroids;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Pos;

public class AsteroidsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
    
    public static int WIDTH = 300;
    public static int HEIGHT = 200;
    
    @Override
    public void start(Stage window) {
        HashMap<KeyCode, Boolean> keyPresses = new HashMap<>();
        
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        // set score text
        Text scoreText = new Text(10, 20, "Score: 0");
        pane.getChildren().add(scoreText);
        
        AtomicInteger points = new AtomicInteger();
        
        Scene scene = new Scene(pane);
        
        Character ship = new Ship(WIDTH/2, HEIGHT/2);
        pane.getChildren().add(ship.getCharacter());
        
        List<Asteroid> asteroids = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<5; i++) {
            asteroids.add(new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT)));
        }
        asteroids.forEach(a -> pane.getChildren().add(a.getCharacter()));
        
        List<Projectile> projectiles = new ArrayList<>();
        
        window.setTitle("Asteroids");
        window.setScene(scene);
        window.show();
        
        scene.setOnKeyPressed(event -> {
            keyPresses.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            keyPresses.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(keyPresses.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                
                if(keyPresses.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                
                if(keyPresses.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                if(keyPresses.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    
                    pane.getChildren().add(projectile.getCharacter());
                }
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                asteroids.forEach(asteroid -> {
                    if(ship.collide(asteroid)) {
                        // create a VBox to represent the game over screen
                        VBox gameOverPane = new VBox();
                        gameOverPane.setAlignment(Pos.CENTER);
                        gameOverPane.setPrefSize(WIDTH, HEIGHT);
                        gameOverPane.setSpacing(10);
                        
                        Text gameOverText = new Text("GAME\nOVER");
                        gameOverText.setFont(new Font(50));
                        
                        Text gameOverPointsText = new Text("Score: " + points.get());
                        gameOverPointsText.setFont(new Font(20));
                        
                        // add both text to the VBox
                        gameOverPane.getChildren().addAll(gameOverText, gameOverPointsText);
                        
                        // clear the main layout and add the game over pane
                        pane.getChildren().clear();
                        pane.getChildren().add(gameOverPane);
                        
                        // stop program execution by stopping the AnimationTimer
                        stop();
                    }
                });
                
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(asteroid.collide(projectile)) {
                            asteroid.setAlive(false);
                            projectile.setAlive(false);
                        }
                    });
                    if (!projectile.isAlive()) {
                        scoreText.setText("Score: " + points.addAndGet(1000));
                    }
                    
                });
                
                List[] charactersToPrune = {projectiles, asteroids};
                for (List<Character> charactersList: charactersToPrune) {
                    // remove characters from the layout
                    charactersList.stream()
                        .filter(character -> (!character.isAlive()))
                        .forEach(character -> pane.getChildren().remove(character.getCharacter()));

                    // then remove characters from the ArrayList itself
                    charactersList.removeAll(charactersList.stream()
                                                    .filter(character -> !character.isAlive())
                                                    .collect(Collectors.toList()));
                }
                
                // randomly add more asteroids to the game
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    // ensure that new asteroid doesn't auto-collide with ship
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
            
        }.start();
    }
           
}
