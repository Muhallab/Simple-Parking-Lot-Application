/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.text.Font;

/**
 *
 * @author almuh
 */
class ExitPanel extends AppState {
    Vehicle vehicle;
    Scene ExitPanelScene;
    @Override
    public void setGUI(ParkingApp app){
        Pane exitPane = new Pane();
        ExitPanelScene = new Scene(exitPane,400,200);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        TextField licensePlate = new TextField();
        setDimensions(licensePlate, 20, 40, 300, exitPane);
        Label licensePlateLabel = new Label();
                setDimensions(licensePlateLabel, 20, 10, 280, exitPane);
		licensePlateLabel.setText("Enter Ticket Number");
		licensePlateLabel.setFont(new Font("Calibri", 20));
		Button confirm = new Button("Proceed");
                confirm.setOnAction(new confirmEventHandler(licensePlate));
                setDimensions(confirm, 50, 130, 300, exitPane);
                Label balanceLabel = new Label();
		setDimensions(balanceLabel, 10, 80, 300, exitPane);
		balanceLabel.setText("Current time: " + date.format(now));
		balanceLabel.setAlignment(Pos.CENTER_RIGHT);
		balanceLabel.setFont(new Font("Calibri", 20));
                
                
                app.stage2.setTitle("Exit Panel/Parking Attendant");
		app.stage2.setScene(ExitPanelScene);
                app.stage2.setX(150);
                app.stage2.setY(140);
		app.stage2.show();
    }
    private class confirmEventHandler implements EventHandler<ActionEvent> {
        private final TextField ticketNumber;
        public confirmEventHandler(TextField ticketNumber){
            this.ticketNumber = ticketNumber;
        }
        @Override
        public void handle(ActionEvent e) {
                File file = new File(ParkingApp.getSingletonExitPanel().currentDirectory + ticketNumber.getText() + ".txt");
                if(file.exists()){
                                        ParkingApp.getSingletonExitPanel().currentMemberFileExit = file;
                                        ParkingApp.getSingletonExitPanel().setStateExit(new CustomerState());
                                        
				}
                else{
					Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "Ticket does not exist", ButtonType.OK);
					duplicateUserError.setTitle("Error");
					duplicateUserError.showAndWait();
				}
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
