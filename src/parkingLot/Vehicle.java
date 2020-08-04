/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;


/**
 *
 * @author almuh
 */
public abstract class Vehicle {
    public enum VehicleType {
  CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE, HANDICAPPED
}
    static int count=1;
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    String licensePlate;
    final VehicleType type;
    ParkingTicket ticket;
    ParkingSpot spot;

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
  public Vehicle(VehicleType type, String licensePlate,long ticketNumber, LocalDateTime date) {
      this.type = type;
    this.licensePlate = licensePlate;
    ticket = new ParkingTicket(ticketNumber);
    ticket.setIssueTime(date);
    vehicles.add(this);
    }

    public ParkingSpot getSpot() {
        return spot;
    }

  public void assignSpot(ParkingSpot spot){
      this.spot = spot;
      this.spot.setUnoccupied(false);
  }
  public void assignTicket(ParkingTicket ticket) {
    this.ticket = ticket;
  }
  public String toString(){
      return ("Vehicle Type: " + getType() + "\nLicense Plate: " + getLicensePlate() + "\n" + getTicket());
  }
}

