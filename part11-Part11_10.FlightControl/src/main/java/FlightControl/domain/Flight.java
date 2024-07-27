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
public class Flight {
    private Airplane plane;
    private Airport origin;
    private Airport destination;
    
    public Flight(Airplane plane, Airport origin, Airport destination) {
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
    }
    
    public String id() {
        return this.origin.id() + "-" + this.destination.id();
    }
    
    public String toString() {
        return this.plane.toString() + " (" + this.id() + ")";
    }
}
