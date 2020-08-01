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
    boolean unoccupied;
    int number;
    ParkingSpotType type;

    public void setNumber(int number) {
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
    
    public ParkingSpot(int number,int floorNumber, ParkingSpotType type ){
        this.number = number;
        this.type = type;
        getParkingFloor(floorNumber).getParkingSpots().add(this);
        
    }
    public ParkingFloor getParkingFloor(int floorNumber){
        for(ParkingFloor floor : floors){
            if(floor.getFloorNumber() == floorNumber) return floor;
            }
        System.out.println("Parking Floor does not exist");
        return null;
        }

    public int getNumber() {
        return number;
    }
    
    
}

    
