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
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Line;
/**
 *
 * @author almuh
 */
public class EntrancePanel extends AppState {
    Scene loginScene;
	
	@Override
	public void setGUI(ParkingApp app){
		Pane loginPane = new Pane();
		
		Label loginScreenLable = new Label();
		setDimensions(loginScreenLable, 0, 2, 400, loginPane);
		loginScreenLable.setText("FOR ADMIN USE ONLY: Enter login information");
		loginScreenLable.setAlignment(Pos.CENTER);
		loginScreenLable.setFont(new Font("Calibri", 20));
		
		Line topLineBreak = new Line();
		topLineBreak.setStartX(0);
		topLineBreak.setEndX(400);
		topLineBreak.setStartY(35);
		topLineBreak.setEndY(35);
		loginPane.getChildren().add(topLineBreak);
		
		Label usernameLabel = new Label();
		setDimensions(usernameLabel, 10, 50, 135, loginPane);
		usernameLabel.setText("User Name");
		usernameLabel.setAlignment(Pos.CENTER_RIGHT);
		usernameLabel.setFont(new Font("Calibri", 20));
		
		Label passwordLabel = new Label();
		setDimensions(passwordLabel, 10, 90, 135, loginPane);
		passwordLabel.setText("Password");
		passwordLabel.setAlignment(Pos.CENTER_RIGHT);
		passwordLabel.setFont(new Font("Calibri", 20));

		TextField usernameField = new TextField();
		setDimensions(usernameField, 155, 50, 135, loginPane);
		TextField passwordField = new TextField();
		setDimensions(passwordField, 155, 90, 135, loginPane);
		
                
                Line middleLineBreak = new Line();
		middleLineBreak.setStartX(0);
		middleLineBreak.setEndX(400);
		middleLineBreak.setStartY(170);
		middleLineBreak.setEndY(170);
		loginPane.getChildren().add(middleLineBreak);
                
                
		Button bookTicketButton = new Button();
		setDimensions(bookTicketButton, 28, 190, 350, loginPane);
		bookTicketButton.setText("Purchase a Ticket");
		bookTicketButton.setOnAction(new newCostumerEventHandler());
                
                
		Line bottomLineBreak = new Line();
		bottomLineBreak.setStartX(0);
		bottomLineBreak.setEndX(400);
		bottomLineBreak.setStartY(240);
		bottomLineBreak.setEndY(240);
		loginPane.getChildren().add(bottomLineBreak);
		
		Button loginButton = new Button();
		setDimensions(loginButton, 45, 130, 280, loginPane);
		loginButton.setText("Login");
		loginButton.setOnAction(new loginEventHandler(usernameField, passwordField));
		
		loginScene = new Scene(loginPane, 400, 250);
		
		app.stage1.setTitle("Login Screen");
		app.stage1.setScene(loginScene);
		app.stage1.show();
	}
	private static class newCostumerEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
//                Alert managerAttemptSuccess = new Alert(AlertType.NONE, "Ticket Purchased", ButtonType.OK);
//		managerAttemptSuccess.setTitle("Welcome");
//		managerAttemptSuccess.showAndWait();
                ParkingApp.getSingletonMain().setState(new RegistrationState());        }
    
}
	private static class loginEventHandler implements EventHandler<ActionEvent> {
		private final TextField usernameField;
		private final TextField passwordField;
                
		public loginEventHandler(TextField usernameField, TextField passwordField) {
			this.usernameField = usernameField;
			this.passwordField = passwordField;
		}
		
		@Override
		public void handle(ActionEvent e) {
			if((usernameField.getText().equals("admin")) && (passwordField.getText().equals("admin"))){
				Alert managerAttemptSuccess = new Alert(AlertType.NONE, "Manager Login Success", ButtonType.OK);
				managerAttemptSuccess.setTitle("Login Attempt Detected");
				managerAttemptSuccess.showAndWait();
				ParkingApp.getSingletonMain().setState(new ManagerState());
			}else{
				Alert managerAttemptFailure = new Alert(AlertType.NONE, "Login Failed - Incorrect admin credentials", ButtonType.OK);
				managerAttemptFailure.setTitle("Login Attempt Detected");
				managerAttemptFailure.showAndWait();
			}
		}
	}
	
	private static void setDimensions(Control c, int positionX, int positionY, int width, Pane pane){
		c.setMaxHeight(30);
		c.setMinHeight(30);
		c.setMaxWidth(width);
		c.setMinWidth(width);
		c.setLayoutX(positionX);
		c.setLayoutY(positionY);
		pane.getChildren().add(c);
	}
}
