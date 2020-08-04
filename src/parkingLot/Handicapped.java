/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.LocalDateTime;

/**
 *
 * @author almuh
 */
public class Handicapped extends Vehicle {
   HandicappedSpot tempSpot = new HandicappedSpot();
    public Handicapped(String licensePlate, String floorNumber) {
    super(Vehicle.VehicleType.HANDICAPPED, licensePlate);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
     
  }
    public Handicapped(String licensePlate, long ticketNumber, LocalDateTime date, String floorNumber) {
    super(Vehicle.VehicleType.HANDICAPPED, licensePlate, ticketNumber, date);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));


  }
}