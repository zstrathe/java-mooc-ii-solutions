/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

/**
 *
 * @author zack
 */

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Polygon;

public abstract class Character {
    private Polygon character;
    private Point2D movement;
    private boolean alive;
    
    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.alive = true;
        
        // think of movment as the directional movement speed
        // how many steps are taken in each X and Y for each move() call
        this.movement = new Point2D(0, 0);
    }
    
    public Polygon getCharacter() {
        return this.character;
    }
    
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }
    
    public Point2D getMovement() {
        return this.movement;
    }
    
    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }
    
    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }
    
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
        
        // reset out of bounds coordinates
        if(this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
        }
        if(this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }
        if(this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.WIDTH);
        }
        if(this.character.getTranslateY() < 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }
    }
    
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));
        
        changeX *= 0.05;
        changeY *= 0.05;
        
        this.movement = this.movement.add(changeX, changeY);
    }
    
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
    
    public void setAlive(boolean bool) {
        this.alive = bool;
    }
    
    public boolean isAlive() {
        return this.alive;
    }
    
}
