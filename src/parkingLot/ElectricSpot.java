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
public class ElectricSpot extends ParkingSpot {
        ElectricPanel panel;
        static ArrayList<ElectricSpot> electricSpots = new ArrayList<>();
     public ElectricSpot(String number, String floorNumber) {
            super(number, floorNumber, ParkingSpotType.ELECTRIC);
            panel = new ElectricPanel();
            electricSpots.add(this);
            

        }

    public ElectricSpot() {
            super("1", "1", ParkingSpotType.ELECTRIC);

    }

        @Override
        public String getNumber() {
            return number;
        }

    public static ArrayList<ElectricSpot> getElectricSpots() {
        return electricSpots;
    }
    public ParkingSpot getFreeParkingSpot(String floorNumber){
        String tempString;
        for(ParkingSpot spot : electricSpots){
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
