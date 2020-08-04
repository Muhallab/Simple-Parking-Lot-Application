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
public class CompactSpot extends ParkingSpot{
    static ArrayList<CompactSpot> compactSpots = new ArrayList<>();
    public CompactSpot(String number, String floorNumber) {
            super(number, floorNumber, ParkingSpotType.COMPACT);
            compactSpots.add(this);
        }
    public CompactSpot(){
    super("1", "1", ParkingSpotType.COMPACT);

    }
        @Override
        public String getNumber() {
            return number;
        }

    public static ArrayList<CompactSpot> getCompactSpots() {
        return compactSpots;
    }
    public ParkingSpot getFreeParkingSpot(String floorNumber){
        String tempString;
        for(ParkingSpot spot : compactSpots){
            tempString = spot.getNumber();
            if(tempString.startsWith(floorNumber)){
            if(spot.isUnoccupied()){
                spot.setUnoccupied(false);
                return spot;
            }
        }}
        System.out.println("No more free parking lots in the selected floor");
        return null;
    }}
