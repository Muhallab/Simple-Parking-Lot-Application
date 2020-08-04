/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author almuh
 */
public class ElectricCustomerState extends CustomerState {

Vehicle vehicle = new Vehicle(Vehicle.VehicleType.CAR, "temp") {
    };
    Scene customerScene;
    double Balance;
    
    @Override
    public void setGUI(ParkingApp app){
        Pane customerPane = new Pane();
        customerScene = new Scene(customerPane,430,300);
        File file = ParkingApp.getSingletonExitPanel().currentMemberFile;
        vehicle = vehicle.getVehicleWithTicketNumber(Long.parseLong(file.getName().replace(".txt", ""))); 
        ParkingPrice price = new ParkingPrice(vehicle.getTicket().getTicketNumber());
        Balance = price.getPrice();
        Label customarScreenLabe = new Label();
		setDimensions(customarScreenLabe, 10, 0, 400, customerPane);
		customarScreenLabe.setText("Vehicle with license plate\"" + vehicle.getLicensePlate() + "\" Account Center");
		customarScreenLabe.setAlignment(Pos.CENTER);
		customarScreenLabe.setFont(new Font("Calibri", 20));
		
		Line topLineBreak = new Line();
		topLineBreak.setStartX(0);
		topLineBreak.setEndX(430);
		topLineBreak.setStartY(35);
		topLineBreak.setEndY(35);
		customerPane.getChildren().add(topLineBreak);
                
                Label balanceLabel = new Label();
		setDimensions(balanceLabel, 30, 80, 300, customerPane);
                Label time = new Label();
		setDimensions(time, 30, 50, 300, customerPane);
                balanceLabel.setText("Current balance to be paid is $" + Balance);
                try {
                    time.setText("Car entered at: " + vehicle.getTicket().getIssueTime());
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerState.class.getName()).log(Level.SEVERE, null, ex);
                }
		balanceLabel.setAlignment(Pos.CENTER);
		balanceLabel.setFont(new Font("Calibri", 20));
                time.setFont(new Font("Calibri", 20));
                HBox root = new HBox(20);
                VBox type = new VBox(10);
                ToggleGroup typeSelect = new ToggleGroup();
                RadioButton credit = new RadioButton();
                credit.setText("Credit");
                credit.setUserData("Credit");
                credit.setToggleGroup(typeSelect);
                credit.setSelected(true);
                RadioButton cash = new RadioButton();
                cash.setText("Cash");
                cash.setUserData("Cash");
                cash.setToggleGroup(typeSelect);
                cash.setSelected(false);
                RadioButton paid = new RadioButton();
                paid.setText("Paid already");
                paid.setUserData("Paid");
                paid.setToggleGroup(typeSelect);
                paid.setSelected(false);
                type.getChildren().addAll(credit, cash, paid);
                Label customarScreenLabel = new Label();
		customarScreenLabel.setText("Choose your payment method");
		customarScreenLabel.setFont(new Font("Calibri", 20));
                root.relocate(30, 120);
                root.getChildren().addAll(customarScreenLabel, type);
                customerPane.getChildren().add(root);
                
                Button pay = new Button("Proceed");
                Button home = new Button("Home");
                Button charge = new Button("Charge");
                pay.setOnAction(new proceedEventHandler(typeSelect));
                home.setOnAction(new homeEventHandler());
                charge.setOnAction(new chargeEventHandler());
                setDimensions(home, 50, 260, 300, customerPane);
                setDimensions(pay, 50, 230, 300, customerPane);
                setDimensions(charge, 50, 200, 300, customerPane);
                
                app.stage4.setTitle("Customer Screen");
		app.stage4.setScene(customerScene);
                app.stage4.show();
    }

    private static class chargeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
                            Alert success = new Alert(Alert.AlertType.NONE, "Charging...", ButtonType.OK);
                            success.setTitle("Charge is on");        
                            success.showAndWait();
                                                }
    }
                private class homeEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
                        ParkingApp.getSingletonExitPanel().currentMemberFile = null;
			ParkingApp.getSingletonExitPanel().setState(new ExitPanel());
		}}
                private class proceedEventHandler implements EventHandler<ActionEvent> {
                    ToggleGroup paymentMethod;
                    public proceedEventHandler(ToggleGroup paymentMethod){
                    this.paymentMethod = paymentMethod;
                            }
                    @Override
                    public void handle(ActionEvent e) {
                        if(paymentMethod.getSelectedToggle().getUserData().toString().equals("Paid")){
                        if( vehicle.getTicket().isActive()){
                            Alert failed = new Alert(Alert.AlertType.NONE, "Ticket Status is Active", ButtonType.OK);
                            failed.setTitle("Ticket has not been paid yet");
                            failed.showAndWait();
                        } else {
                            Alert success = new Alert(Alert.AlertType.NONE, "Thank you for using out parking lot, Have a nice day!", ButtonType.OK);
                            success.setTitle("Ticket is Paid");
                            success.showAndWait();
                            vehicle.getSpot().setUnoccupied(true);
                            deleteTicket(vehicle.getTicket().getTicketNumber());
                            ParkingApp.getSingletonDisplayBoard().setState(new ParkingDisplayBoard());
                            ParkingApp.getSingletonElectricPanel().currentMemberFile = null;
                            ParkingApp.getSingletonElectricPanel().setState(new ElectricPanel());
                        }}
                        else{
                            Alert success = new Alert(Alert.AlertType.NONE, "Thank you for using our parking lot, Have a nice day!", ButtonType.OK);
                            success.setTitle("Ticket is Paid");
                            success.showAndWait();
                            vehicle.getSpot().setUnoccupied(true);
                            deleteTicket(vehicle.getTicket().getTicketNumber());
                            ParkingApp.getSingletonDisplayBoard().setState(new ParkingDisplayBoard());
                            ParkingApp.getSingletonElectricPanel().currentMemberFile = null;
                            ParkingApp.getSingletonElectricPanel().setState(new ElectricPanel());
                        }
                    }
                }
                    
                
                private void deleteTicket(long ticketNumber){
                    File file = new File(ParkingApp.getSingletonMain().currentDirectory + ticketNumber + ".txt");
			if(file.exists()){
				file.delete();
                        }
                }
                private void setDimensions(Control c, int positionX, int positionY, int width, Pane pane){
		c.setMaxHeight(30);
		c.setMinHeight(30);
		c.setMaxWidth(width);
		c.setMinWidth(width);
		c.setLayoutX(positionX);
		c.setLayoutY(positionY);
		pane.getChildren().add(c);
    }
}

    

