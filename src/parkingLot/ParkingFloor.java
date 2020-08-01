/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.util.ArrayList;

/**
 *
 * @author almuh
 */
class ParkingFloor {
    static ArrayList<ParkingFloor> floors = new ArrayList<>();
    int floorNumber;
    int maxSpots;
    int availableSpots;
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    
    ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
    }

    public boolean isFull(){
        if(maxSpots-availableSpots>0){
            return true;
        }
        else return false;
    }
    
    

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getMaxSpots() {
        return maxSpots;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    
}
