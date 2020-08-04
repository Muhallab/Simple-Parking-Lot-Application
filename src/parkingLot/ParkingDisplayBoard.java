/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.Duration;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import static parkingLot.CompactSpot.compactSpots;
import static parkingLot.ElectricSpot.electricSpots;
import static parkingLot.HandicappedSpot.handicappedSpots;
import static parkingLot.LargeSpot.largeSpots;
import static parkingLot.MotorBikeSpot.motorBikeSpots;

/**
 *
 * @author almuh
 */
public class ParkingDisplayBoard extends AppState {
  Scene DisplayBoard;
   static int handicappedFreeSpot1;
   static int compactFreeSpot1;
   static int largeFreeSpot1;
   static int motorbikeFreeSpot1;
   static int electricFreeSpot1;
   static int handicappedFreeSpot2;
   static int compactFreeSpot2;
   static int largeFreeSpot2;
   static int motorbikeFreeSpot2;
   static int electricFreeSpot2;
   static int handicappedFreeSpot3;
   static int compactFreeSpot3;
   static int largeFreeSpot3;
   static int motorbikeFreeSpot3;
   static int electricFreeSpot3;
  
        @Override
	public void setGUI(ParkingApp app){
            String msg = showEmptySpotNumber();
            Label label = new Label(msg);
            DisplayBoard = new Scene(label,300,400);
            app.stage3.setScene(DisplayBoard);
            app.stage3.setTitle("Parking Display Board");
            app.stage3.setX(1100);
            app.stage3.setY(50);
            app.stage3.show();
        }

  public String showEmptySpotNumber() {
    String message = "";
    compactFreeSpot1=0;
    compactFreeSpot2=0;
    compactFreeSpot3=0;
    largeFreeSpot1=0;
    largeFreeSpot2=0;
    largeFreeSpot3=0;
    handicappedFreeSpot1=0;
    handicappedFreeSpot2=0;
    handicappedFreeSpot3=0;
    motorbikeFreeSpot1=0;
    motorbikeFreeSpot2=0;
    motorbikeFreeSpot3=0;
    electricFreeSpot1=0;
    electricFreeSpot2=0;
    electricFreeSpot3=0;
    message += "Floor 1 \n";
    for(ParkingSpot spot : handicappedSpots ){
        if(spot.getNumber().startsWith(Integer.toString(1))){
            if(spot.isUnoccupied()){
            handicappedFreeSpot1++;
            }}}
            if(handicappedFreeSpot1 == 0) {
            message += "Handicapped Spots are full";
            }
             else{
            message += "Free Handicapped Spots: " + handicappedFreeSpot1;
    }
            message += System.lineSeparator();
    for(ParkingSpot spot : compactSpots ){
        if(spot.getNumber().startsWith(Integer.toString(1))){
            if(spot.isUnoccupied()){
            compactFreeSpot1++;
            }}}
            if(compactFreeSpot1 == 0) {
            message += "Compact Spots are full";
            }
             else{
            message += "Free Compact Spots: " + compactFreeSpot1;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : motorBikeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(1))){
            if(spot.isUnoccupied()){
            motorbikeFreeSpot1++;
            }}}
            if(motorbikeFreeSpot1 == 0) {
            message += "Motor Bike Spots are full";
            }
             else{
            message += "Free Motor Bike Spots: " + motorbikeFreeSpot1;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : largeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(1))){
            if(spot.isUnoccupied()){
            largeFreeSpot1++;
            }}}
            if(largeFreeSpot1 == 0) {
            message += "Large Spots are full";
            }
             else{
            message += "Free Large Spots: " + largeFreeSpot1;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : electricSpots ){
        if(spot.getNumber().startsWith(Integer.toString(1))){
            if(spot.isUnoccupied()){
            electricFreeSpot1++;
            }}}
            if(electricFreeSpot1 == 0) {
            message += "Electric Spots are full";
            }
             else{
            message += "Electric Large Spots: " + electricFreeSpot1;
    }
            message += "\n\nFloor 2 \n";
    for(ParkingSpot spot : handicappedSpots ){
        if(spot.getNumber().startsWith(Integer.toString(2))){
            if(spot.isUnoccupied()){
            handicappedFreeSpot2++;
            }}}
            if(handicappedFreeSpot2 == 0) {
            message += "Handicapped Spots are full";
            }
             else{
            message += "Free Handicapped Spots: " + handicappedFreeSpot2;
    }
            message += System.lineSeparator();
    for(ParkingSpot spot : compactSpots ){
        if(spot.getNumber().startsWith(Integer.toString(2))){
            if(spot.isUnoccupied()){
            compactFreeSpot2++;
            }}}
            if(compactFreeSpot2 == 0) {
            message += "Compact Spots are full";
            }
             else{
            message += "Free Compact Spots: " + compactFreeSpot2;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : motorBikeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(2))){
            if(spot.isUnoccupied()){
            motorbikeFreeSpot2++;
            }}}
            if(motorbikeFreeSpot2 == 0) {
            message += "Motor Bike Spots are full";
            }
             else{
            message += "Free Motor Bike Spots: " + motorbikeFreeSpot2;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : largeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(2))){
            if(spot.isUnoccupied()){
            largeFreeSpot2++;
            }}}
            if(largeFreeSpot2 == 0) {
            message += "Large Spots are full";
            }
             else{
            message += "Free Large Spots: " + largeFreeSpot2;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : electricSpots ){
        if(spot.getNumber().startsWith(Integer.toString(2))){
            if(spot.isUnoccupied()){
            electricFreeSpot2++;
            }}}
            if(electricFreeSpot2 == 0) {
            message += "Electric Spots are full";
            }
             else{
            message += "Electric Large Spots: " + electricFreeSpot2;
    }   
            message += "\n\nFloor 3 \n";
    for(ParkingSpot spot : handicappedSpots ){
        if(spot.getNumber().startsWith(Integer.toString(3))){
            if(spot.isUnoccupied()){
            handicappedFreeSpot3++;
            }}}
            if(handicappedFreeSpot3 == 0) {
            message += "Handicapped Spots are full";
            }
             else{
            message += "Free Handicapped Spots: " + handicappedFreeSpot3;
    }
            message += System.lineSeparator();
    for(ParkingSpot spot : compactSpots ){
        if(spot.getNumber().startsWith(Integer.toString(3))){
            if(spot.isUnoccupied()){
            compactFreeSpot3++;
            }}}
            if(compactFreeSpot3 == 0) {
            message += "Compact Spots are full";
            }
             else{
            message += "Free Compact Spots: " + compactFreeSpot3;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : motorBikeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(3))){
            if(spot.isUnoccupied()){
            motorbikeFreeSpot3++;
            }}}
            if(motorbikeFreeSpot3 == 0) {
            message += "Motor Bike Spots are full";
            }
             else{
            message += "Free Motor Bike Spots: " + motorbikeFreeSpot3;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : largeSpots ){
        if(spot.getNumber().startsWith(Integer.toString(3))){
            if(spot.isUnoccupied()){
            largeFreeSpot3++;
            }}}
            if(largeFreeSpot3 == 0) {
            message += "Large Spots are full";
            }
             else{
            message += "Free Large Spots: " + largeFreeSpot3;
    }
            message += System.lineSeparator();
            for(ParkingSpot spot : electricSpots ){
        if(spot.getNumber().startsWith(Integer.toString(3))){
            if(spot.isUnoccupied()){
            electricFreeSpot3++;
            }}}
            if(electricFreeSpot3 == 0) {
            message += "Electric Spots are full";
            }
             else{
            message += "Electric Large Spots: " + electricFreeSpot3;
    }
            return message;
  }
}

