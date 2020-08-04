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
public class Car extends Vehicle{
    CompactSpot tempSpot = new CompactSpot();
    public Car(String licensePlate, String floorNumber) {
    super(VehicleType.CAR, licensePlate);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
     
  }
    public Car(String licensePlate, long ticketNumber, LocalDateTime date, String floorNumber) {
    super(VehicleType.CAR, licensePlate, ticketNumber, date);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));

  }
}
