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
    
    @Override
    public void setGUI(ParkingApp app){
        Pane exitPane = new Pane();
        Scene ExitPanelScene = new Scene(exitPane,400,300);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        HBox select = new HBox(20);
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
        TextField licensePlate = new TextField();
        setDimensions(licensePlate, 20, 160, 300, exitPane);
        Label licensePlateLabel = new Label();
                setDimensions(licensePlateLabel, 20, 130, 280, exitPane);
		licensePlateLabel.setText("Enter License Plate");
		licensePlateLabel.setFont(new Font("Calibri", 20));
        Label customarScreenLabel = new Label();
		setDimensions(customarScreenLabel, 10, 0, 280, exitPane);
		customarScreenLabel.setText("Choose your payment method");
		customarScreenLabel.setAlignment(Pos.CENTER);
		customarScreenLabel.setFont(new Font("Calibri", 20));
                
                select.getChildren().addAll(customarScreenLabel, type);
                exitPane.getChildren().add(select);
//                Vehicle vehicle = new Vehicle((Vehicle.VehicleType) typeSelect.getUserData(), );
                
		Button confirm = new Button("Proceed");
                confirm.setOnAction(new confirmEventHandler(licensePlate,typeSelect));
                setDimensions(confirm, 50, 250, 300, exitPane);
                Label balanceLabel = new Label();
		setDimensions(balanceLabel, 10, 200, 300, exitPane);
		balanceLabel.setText("Current time: " + date.format(now));
		balanceLabel.setAlignment(Pos.CENTER_RIGHT);
		balanceLabel.setFont(new Font("Calibri", 20));
                
                
                app.stage2.setTitle("Exit Panel");
		app.stage2.setScene(ExitPanelScene);
                app.stage2.setX(150);
                app.stage2.setY(190);
		app.stage2.show();
    }
    private class confirmEventHandler implements EventHandler<ActionEvent> {
        private final TextField licensePlate;
        private final ToggleGroup typeSelect;
        public confirmEventHandler(TextField licensePlate, ToggleGroup typeSelect){
            this.licensePlate = licensePlate;
            this.typeSelect = typeSelect;
        }
        @Override
        public void handle(ActionEvent e) {
                File file = new File(ParkingApp.getSingletonMain().currentDirectory + licensePlate.getText()+ ".txt");
                if(file.exists()){
					Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "Price is" , ButtonType.OK);
                                        
					duplicateUserError.setTitle("Vehicle registration Attempt Detected");
					duplicateUserError.showAndWait();
				}
                else{
					Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
					duplicateUserError.setTitle("Vehicle with this license plate is not registered");
					duplicateUserError.showAndWait();
				}
//                ParkingApp.getSingleton().setState(new RegistrationState());        
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
