/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import parkingLot.Vehicle.VehicleType;

/**
 *
 * @author almuh
 */
class ParkingTicket {
    static ArrayList<ParkingTicket> tickets = new ArrayList();
    public enum parkingStatus{Active, Paid}
    private long ticketNumber;
    LocalDateTime issueTime;
    LocalDateTime paymentTime;
    parkingStatus status;
    double price =0;
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    void saveInDB() {
        tickets.add(this);
        
    }
    public long generateTicketNumber(){
              long tempTicketNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

            for(ParkingTicket ticket : tickets){
                if(tempTicketNumber == ticket.getTicketNumber()){
                    generateTicketNumber();
                }
            }
            return tempTicketNumber;
    }
    public ParkingTicket(){
        ticketNumber = generateTicketNumber();
        issueTime = LocalDateTime.now();
        status = parkingStatus.Active;
    }
    public ParkingTicket(long ticketNumber){
        this.ticketNumber = ticketNumber;
        issueTime = LocalDateTime.now();
        status = parkingStatus.Active;
    }   
    
    public boolean pay(double paidAmount) {
        price = price - paidAmount;
        if(price <= 0){
        this.status = parkingStatus.Paid;
        paymentTime = LocalDateTime.now();
        return true;
        }
        else{
            return false;
        }
    }

    public static ArrayList<ParkingTicket> getTickets() {
        return tickets;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public parkingStatus getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
    public String toString(){
        return ("Ticket Number: " + getTicketNumber() + "\nIssue Time: " + getIssueTime().format(date));
    }
}
