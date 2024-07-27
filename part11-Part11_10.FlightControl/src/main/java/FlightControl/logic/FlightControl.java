/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

/**
 *
 * @author zack
 */
import java.util.HashMap;
import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Airport> airports;
    private HashMap<String, Flight> flights;
    
    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
    }
    
    public void addPlane(String id, int capacity) {
        Airplane airplane = new Airplane(id, capacity);
        this.airplanes.putIfAbsent(id, airplane);
    }
    
    private Airport addAirport(String id) {
        Airport airport = new Airport(id);
        this.airports.putIfAbsent(id, airport);
        return airport;
    }
    
    public void addFlight(Airplane airplane, String originID, String destinationID) {
        //this.addPlane(airplane);
        Airport originAirport = this.addAirport(originID);
        Airport destinationAirport = this.addAirport(destinationID);
        Flight flight = new Flight(airplane, originAirport, destinationAirport);
        this.flights.putIfAbsent(flight.id(), flight);
    }
    
    public boolean planeInSystem(String planeID) {
        if (this.airplanes.containsKey(planeID)) {
            return true;
        }
        return false;
    }
    
    public Airplane getPlane(String planeID) {
        Airplane airplane = this.airplanes.getOrDefault(planeID, new Airplane("",0));
        return airplane;
    }
    
    public void printAirplanes() {
        for (Airplane plane: this.airplanes.values()) {
            System.out.println(plane);
        }
        System.out.println("");
    }
    
    public void printFlights() {
        for (Flight flight: this.flights.values()) {
            System.out.println(flight);
        }
        System.out.println("");
    }
    
}
