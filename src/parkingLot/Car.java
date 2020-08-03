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
    
    public Car(String licensePlate) {
    super(VehicleType.CAR, licensePlate);
  }
    public Car(String licensePlate, long ticketNumber, LocalDateTime date) {
    super(VehicleType.CAR, licensePlate, ticketNumber, date);
  }
}
