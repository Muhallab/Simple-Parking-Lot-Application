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
public class HandicappedSpot extends ParkingSpot {
        static ArrayList<HandicappedSpot> handicappedSpots = new ArrayList<>();
        public HandicappedSpot(String number, String floorNumber) {
            super(number, floorNumber, ParkingSpotType.HANDICAPPED);
            handicappedSpots.add(this);
        }
        public HandicappedSpot(){
            super("1", "1", ParkingSpotType.HANDICAPPED);

        }
        @Override
        public String getNumber() {
            return number;
        }
        
    public ParkingSpot getFreeParkingSpot(String floorNumber){
        String tempString;
        for(ParkingSpot spot : handicappedSpots){
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
