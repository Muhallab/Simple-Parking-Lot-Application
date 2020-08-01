/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import parkingLot.CompactSpot;
import parkingLot.ElectricSpot;
import parkingLot.HandicappedSpot;
import parkingLot.LargeSpot;
import parkingLot.MotorBikeSpot;

/**
 *
 * @author almuh
 */
public class ParkingDisplayBoard {
  private String id;
  private HandicappedSpot handicappedFreeSpot;
  private CompactSpot compactFreeSpot;
  private LargeSpot largeFreeSpot;
  private MotorBikeSpot motorbikeFreeSpot;
  private ElectricSpot electricFreeSpot;

  public void showEmptySpotNumber() {
    String message = "";
    if(handicappedFreeSpot.isUnoccupied()){
      message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
    } else {
      message += "Handicapped is full";
    }
    message += System.lineSeparator();

    if(compactFreeSpot.isUnoccupied()){
      message += "Free Compact: " + compactFreeSpot.getNumber();
    } else {
      message += "Compact is full";
    }
    message += System.lineSeparator();

    if(largeFreeSpot.isUnoccupied()){
      message += "Free Large: " + largeFreeSpot.getNumber();
    } else {
      message += "Large is full";
    }
    message += System.lineSeparator();

    if(motorbikeFreeSpot.isUnoccupied()){
      message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
    } else {
      message += "Motorbike is full";
    }
    message += System.lineSeparator();

    if(electricFreeSpot.isUnoccupied()){
      message += "Free Electric: " + electricFreeSpot.getNumber();
    } else {
      message += "Electric is full";
    }

    System.out.print(message);
  }
}

