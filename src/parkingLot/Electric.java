/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

/**
 *
 * @author almuh
 */
public class Electric extends Vehicle {

    public Electric(String licensePlate) {
    super(VehicleType.ELECTRIC, licensePlate);
  }
   public Electric(String licensePlate, long ticketNumber) {
    super(VehicleType.ELECTRIC, licensePlate, ticketNumber);
  } 
}
