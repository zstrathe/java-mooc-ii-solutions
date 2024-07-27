/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

/**
 *
 * @author zack
 */
import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;

public class TextUI {
    private Scanner scanner;
    private FlightControl flightControl;
    
    public TextUI(Scanner scanner) {
        this.scanner = scanner;
        this.flightControl = new FlightControl();
    }
    
    public void startUI() {
        System.out.println("Airport Asset Control");
        while (true) {
            this.printOptionsAssetControl();
            String optInput = this.scanner.nextLine();
            
            if (optInput.toLowerCase().equals("x")) {
                break;
            } else if (optInput.equals("1")) {
                this.addAirplane();
            } else if (optInput.equals("2")) {
                this.addFlight();
            } 
        }
        System.out.println("Airport Flight Control");
        while (true) {
            this.printOptionsFlightControl();
            String optInput = this.scanner.nextLine();
            
            if (optInput.toLowerCase().equals("x")) {
                break;
            } else if (optInput.equals("1")) {
                this.flightControl.printAirplanes();
            } else if (optInput.equals("2")) {
                this.flightControl.printFlights();
            } else if (optInput.equals("3")) {
                System.out.print("Give the airplane id: ");
                String airplaneID = scanner.nextLine();
                Airplane airplane = this.flightControl.getPlane(airplaneID);
                System.out.println(airplane);
            }
        }
    }
    
    public void printOptionsAssetControl() {
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[x] Exit Airport Asset Control");
    }
    
    public void printOptionsFlightControl() {
        System.out.println("[1] Print airplanes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print airplane details");
        System.out.println("[x] Quit");
    }
    
    public void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(this.scanner.nextLine());
        this.flightControl.addPlane(id, capacity);
    }
    
    public void addFlight() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        if (!this.flightControl.planeInSystem(id)) {
            System.out.println("Airplane not in flight control system! Please add plane first before continuing!");
            return;
        }
        Airplane airplane = this.flightControl.getPlane(id);
        System.out.print("Give the departure airport id: ");
        String originAirportID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationAirportID = scanner.nextLine();
        this.flightControl.addFlight(airplane, originAirportID, destinationAirportID);
    }
}
