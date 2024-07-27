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
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public boolean isOn() {
        for (Sensor s: this.sensors) {
            if (s.isOn() == false) {
                return false;
            }
        }
        return true;
    }
    
    public void setOn() {
        this.sensors.stream().forEach(sensor -> sensor.setOn());
    }
    
    public void setOff() {
        this.sensors.stream().forEach(sensor -> sensor.setOff());
    }
    
    public int read() {
        if (this.isOn()) {
            int sum = this.sensors.stream()
                    .filter(sensor -> sensor.isOn())
                    .mapToInt(sensor -> sensor.read())
                    .reduce(0, (val1, val2) -> val1 + val2);
            int reading = sum / this.sensors.size();
            this.readings.add(reading);
            return reading;
        } else {
            throw new IllegalStateException();
        }
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
}
