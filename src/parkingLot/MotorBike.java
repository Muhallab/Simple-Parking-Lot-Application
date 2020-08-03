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
public class MotorBike extends Vehicle {

    public MotorBike(String licensePlate) {
    super(VehicleType.MOTORBIKE, licensePlate);
  }
    public MotorBike(String licensePlate, long ticketNumber, LocalDateTime date) {
    super(VehicleType.MOTORBIKE, licensePlate, ticketNumber,date);
  }
    
}
