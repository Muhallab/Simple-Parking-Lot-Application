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
public class MotorBikeSpot extends ParkingSpot {
    public MotorBikeSpot(int number, int floorNumber) {
            super(number, floorNumber, ParkingSpotType.MOTORBIKE);
        }

        @Override
        public int getNumber() {
            return number;
        }
}
