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
import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean on;
    
    public TemperatureSensor() {
        this.on = false;
    }
    
    public boolean isOn() {
        return this.on;
    }
    
    public void setOn() {
        this.on = true;
    }
    
    public void setOff() {
        this.on = false;
    }
    
    public int read() {
        if (this.on == true) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }    
    } 
}
