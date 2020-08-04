/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author almuh
 */
class ParkingPrice {
    int Hours;
    double rate;
    double price=0;
    ParkingTicket ticket;
    LocalDateTime currently;
    
    ParkingPrice(long ticketNumber){
        ticket = ParkingTicket.getTicket(ticketNumber);
        currently = LocalDateTime.now();
        Hours = (int) Duration.between(ticket.getIssueTimeObject(), currently).toHours();
        if((int) Duration.between(ticket.getIssueTimeObject(), currently).toMinutes() > 1) Hours++;        
    }
    public double getPrice(){
        if (Hours > 0){
            price = 4;
        }
        if (Hours > 2){
            price = price + 3.5;
        }
        if (Hours > 3){
            price = price + 3.5;
        }
        if (Hours > 4){
            for(int count = 1; count < (Hours-2) ;count++){
                price = price+2.5;
            }
        }
        return price;
        
    }
    
    
}
