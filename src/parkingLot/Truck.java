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
public class Truck extends Vehicle {
    LargeSpot tempSpot = new LargeSpot();
    public Truck(String licensePlate, String floorNumber) {
    super(VehicleType.TRUCK, licensePlate);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
  }
    public Truck(String licensePlate, long ticketNumber, LocalDateTime date, String floorNumber) {
    super(VehicleType.TRUCK, licensePlate, ticketNumber, date);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
  }
}
