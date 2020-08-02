/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.control.TextField;
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
class CustomerState extends AppState {
    Vehicle vehicle = new Vehicle(Vehicle.VehicleType.CAR, "temp", 0000L) {
    };
    Scene customerScene;
    long Balance;
    
    @Override
    public void setGUI(ParkingApp app){
        Pane customerPane = new Pane();
        customerScene = new Scene(customerPane,430,300);
        File file = ParkingApp.getSingletonExitPanel().currentMemberFile;
        vehicle = vehicle.getVehicleWithTicketNumber(Long.parseLong(file.getName().replace(".txt", ""))); 
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
		setDimensions(balanceLabel, 30, 50, 300, customerPane);
		balanceLabel.setText("Current balance to be paid is $" + Balance);
		balanceLabel.setAlignment(Pos.CENTER_RIGHT);
		balanceLabel.setFont(new Font("Calibri", 20));
                
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
//		setDimensions(customarScreenLabel, 10, 300, 280, customerPane);
		customarScreenLabel.setText("Choose your payment method");
//		customarScreenLabel.setAlignment(Pos.BOTTOM_LEFT);
		customarScreenLabel.setFont(new Font("Calibri", 20));
                root.relocate(30, 120);
                root.getChildren().addAll(customarScreenLabel, type);
                customerPane.getChildren().add(root);
                
                Button pay = new Button("Proceed");
//                pay.setOnAction(new );
                setDimensions(pay, 50, 230, 300, customerPane);
                
                app.stage2.setTitle("Customer Screen");
		app.stage2.setScene(customerScene);
                app.stage2.show();
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
