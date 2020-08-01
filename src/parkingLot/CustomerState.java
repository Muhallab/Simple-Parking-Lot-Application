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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author almuh
 */
class CustomerState extends AppState {
    Vehicle vehicle;
    Scene customerScene;
    double Balance;
    
    public void setGUI(ParkingApp app){
        Pane customerPane = new Pane();
        customerScene = new Scene(customerPane,200,200);
        
        Label customarScreenLabe = new Label();
		setDimensions(customarScreenLabe, 10, 0, 280, customerPane);
		customarScreenLabe.setText("Vehicle with license plate\"" + vehicle.getLicensePlate() + "\" Account Center");
		customarScreenLabe.setAlignment(Pos.CENTER);
		customarScreenLabe.setFont(new Font("Calibri", 20));
		
		Line topLineBreak = new Line();
		topLineBreak.setStartX(0);
		topLineBreak.setEndX(300);
		topLineBreak.setStartY(35);
		topLineBreak.setEndY(35);
		customerPane.getChildren().add(topLineBreak);
                
                Label balanceLabel = new Label();
		setDimensions(balanceLabel, 10, 50, 135, customerPane);
		balanceLabel.setText("Current balance to be paid is $" + Balance);
		balanceLabel.setAlignment(Pos.CENTER_RIGHT);
		balanceLabel.setFont(new Font("Calibri", 20));
                
                
        
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
