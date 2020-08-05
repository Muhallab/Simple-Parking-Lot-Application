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
    enum parkingStatus{Active, Paid}
    long ticketNumber;
    LocalDateTime issueTime;
    parkingStatus status;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);

    
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
        this.ticketNumber = generateTicketNumber();
        issueTime = LocalDateTime.now();
        status = parkingStatus.Active;
        tickets.add(this);
    }
    public ParkingTicket(long ticketNumber){
        this.ticketNumber = ticketNumber;
        issueTime = LocalDateTime.now();
        status = parkingStatus.Active;
        tickets.add(this);

    }
    

    public static ParkingTicket getTicket(long ticketNumber) {
        for(ParkingTicket ticket : tickets){
            if (ticket.getTicketNumber() == ticketNumber) return ticket;
        }
        System.out.println("Ticket with number " + ticketNumber + " does not exist");
        return null;
    }
    

    public static ArrayList<ParkingTicket> getTickets() {
        return tickets;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }
    public LocalDateTime getIssueTimeObject(){
        return issueTime;
    }
    public String getIssueTime() throws ParseException {
        
        return issueTime.format(formatter);
    }

    public void setStatus(parkingStatus status){
        this.status = status;
    }
    public parkingStatus getStatus() {
        return status;
    }
    public boolean isActive(){
        return getStatus().equals(parkingStatus.Active);
    }
    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
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
