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
    static int spotNumber;
    String floorNumber;
    int maxSpots;
    int availableSpots;
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    
    ParkingFloor(String floorNumber){
        this.floorNumber = floorNumber;
        floors.add(this);
        spotNumber = 1;
        for(int spots=0; spots<20 ;spots++){
            ParkingSpot compactParkingSpots = new CompactSpot(this.getFloorNumber() + Integer.toString(spotNumber), floorNumber);
            spotNumber++;
        }
         for(int spots=0; spots<10 ;spots++){
            ParkingSpot motorBikeSpot = new MotorBikeSpot(this.getFloorNumber() + Integer.toString(spotNumber), floorNumber);
            spotNumber++;
        }
        for(int spots=0; spots<10 ;spots++){
            ParkingSpot largeSpot = new LargeSpot(this.getFloorNumber() + Integer.toString(spotNumber), floorNumber);
            spotNumber++;
        }
        for(int spots=0; spots<10 ;spots++){
            ParkingSpot handicappedSpot = new HandicappedSpot(this.getFloorNumber() + Integer.toString(spotNumber), floorNumber);
            spotNumber++;
        }
        for(int spots=0; spots<10 ;spots++){
            ParkingSpot electricSpot = new ElectricSpot(this.getFloorNumber() + Integer.toString(spotNumber), floorNumber);
            spotNumber++;
        }
        this.maxSpots = spotNumber;
        this.availableSpots = spotNumber;
    }

    public boolean isFull(){
        if(maxSpots-availableSpots<maxSpots){
            return true;
        }
        else return false;
    }
    
    

    public String getFloorNumber() {
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
