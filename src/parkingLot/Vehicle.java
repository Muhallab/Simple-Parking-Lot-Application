/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author almuh
 */
public abstract class Vehicle {
    public enum VehicleType {
  CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
}
    static int count=1;
  static ArrayList<Vehicle> vehicles = new ArrayList<>();
  private String licensePlate;
  private final VehicleType type;
  private ParkingTicket ticket;

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
    
    public ParkingTicket getTicket() {
        return ticket;
    }
    
    
    public void setLicensePlate (String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setTicket(){
        ticket = new ParkingTicket();
    }
    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
  public void getVehicles(){
      for(Vehicle vehicle : vehicles){
          System.out.println(vehicle);
      }
  }
  public Vehicle getVehicleWithTicketNumber(long number){
      for(Vehicle vehicle : vehicles){
          if(vehicle.getTicket().getTicketNumber() == number){
              return vehicle;
          }
      }
      System.out.println("Ticket number is not valid");
      return null;
  }
  
  public Vehicle(VehicleType type, String licensePlate) {
    this.type = type;
    this.licensePlate = licensePlate;
    ticket = new ParkingTicket();
    vehicles.add(this);
}
  public Vehicle(VehicleType type, String licensePlate,long ticketNumber) {
    this.type = type;
    this.licensePlate = licensePlate;
    ticket = new ParkingTicket(ticketNumber);
    vehicles.add(this);
    }

 
  public void assignTicket(ParkingTicket ticket) {
    this.ticket = ticket;
  }
  public String toString(){
      return ("Vehicle Type: " + getType() + "\nLicense Plate: " + getLicensePlate() + "\n" + getTicket());
  }
}

