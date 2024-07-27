/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author zack
 */
public class Airplane {
    private String id;
    private int capacity;
    
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    
    public int capcity() {
        return this.capacity;
    }
    
    public String id() {
        return this.id;
    }
    
    public String toString() {
        return this.id + " (" + this.capacity + " capacity)";
    }
}
