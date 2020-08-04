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
public class Van extends Vehicle {
    LargeSpot tempSpot= new LargeSpot();
    public Van(String licensePlate, String floorNumber) {
    super(VehicleType.VAN, licensePlate);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
  }
    public Van(String licensePlate, long ticketNumber,LocalDateTime date, String floorNumber) {
        super(VehicleType.VAN, licensePlate, ticketNumber,date);
        this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));
      }
    
}
