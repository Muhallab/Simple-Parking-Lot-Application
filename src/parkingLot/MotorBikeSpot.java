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
    public MotorBikeSpot(int number, int floorNumber, ParkingSpotType type) {
            super(number, floorNumber, type);
        }

        @Override
        public int getNumber() {
            return number;
        }
}
