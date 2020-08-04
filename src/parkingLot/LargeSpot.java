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
public class LargeSpot extends ParkingSpot {
        static ArrayList<LargeSpot> largeSpots = new ArrayList<>();
        public LargeSpot(String number, String floorNumber) {
            super(number, floorNumber, ParkingSpotType.LARGE);
            largeSpots.add(this);
        }
        public LargeSpot(){
            super("1", "1", ParkingSpotType.LARGE);
        }

        @Override
        public String getNumber() {
            return number;
        }  
    
     public ParkingSpot getFreeParkingSpot(String floorNumber){
        String tempString;
        for(ParkingSpot spot : largeSpots){
            tempString = spot.getNumber();
            if(tempString.startsWith(floorNumber)){
            if(spot.isUnoccupied()){
                spot.setUnoccupied(false);
                return spot;
            }
        }}
        System.out.println("No more free parking lots in the selected floor");
        return null;
    }
        
}
