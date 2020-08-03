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

    public Van(String licensePlate) {
    super(VehicleType.VAN, licensePlate);
  }
    public Van(String licensePlate, long ticketNumber,LocalDateTime date) {
        super(VehicleType.VAN, licensePlate, ticketNumber,date);
      }
    
}
