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

    public Truck(String licensePlate) {
    super(VehicleType.TRUCK, licensePlate);
  }
    public Truck(String licensePlate, long ticketNumber, LocalDateTime date) {
    super(VehicleType.TRUCK, licensePlate, ticketNumber, date);
  }
}
