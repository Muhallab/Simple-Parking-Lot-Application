/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import parkingLot.Vehicle.VehicleType;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
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

    public String getIssueTime() throws ParseException {
        
        return issueTime.format(formatter);
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public parkingStatus getStatus() {
        return status;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }
    
    public double getPrice() {
        return price;
    }
    public String toString(){
        try {
            return ("Ticket Number: " + getTicketNumber() + "\nIssue Time: " + getIssueTime());
        } catch (ParseException ex) {
            Logger.getLogger(ParkingTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
