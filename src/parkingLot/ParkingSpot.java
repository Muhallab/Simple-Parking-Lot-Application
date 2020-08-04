/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import static parkingLot.ParkingFloor.floors;

/**
 *
 * @author almuh
 */
    public class ParkingSpot {
    public enum ParkingSpotType {
  HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
    }
     boolean unoccupied = true;
    String number;
    ParkingSpotType type;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public boolean isUnoccupied() {
        return unoccupied;
    }

    public void setUnoccupied(boolean unoccupied) {
        this.unoccupied = unoccupied;
    }
    
    
    
    public ParkingSpotType getType() {
        return type;
    }
    
    public ParkingSpot(String number,String floorNumber, ParkingSpotType type ){
        this.number = number;
        this.type = type;
        getParkingFloor(floorNumber).getParkingSpots().add(this);
        
    }
    public ParkingFloor getParkingFloor(String floorNumber){
        for(ParkingFloor floor : floors){
            if(floor.getFloorNumber() == floorNumber) return floor;
            }
        System.out.println("Parking Floor does not exist");
        return null;
        }

    public String getNumber() {
        return number;
    }
    
    
}

    
