/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author almuh
 */
public class RegistrationState extends AppState {
    Vehicle vehicle;
    Scene RegistrationScene;
    String floorNumber = "1";

    public void setGUI(ParkingApp app){
        Pane customerPane = new Pane();
        RegistrationScene = new Scene(customerPane,430,350);
         DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();
        HBox select = new HBox(1);
        VBox type = new VBox(10);
        ToggleGroup typeSelect = new ToggleGroup();
	RadioButton car = new RadioButton();
//	setDimensions(car, 300, 120, 290, customerPane);
	car.setText("Car");
	car.setUserData(Vehicle.VehicleType.CAR);
	car.setToggleGroup(typeSelect);
	car.setSelected(true);
	RadioButton van = new RadioButton();
	van.setText("Van");
	van.setUserData(Vehicle.VehicleType.VAN);
	van.setToggleGroup(typeSelect);
	van.setSelected(false);
        RadioButton truck = new RadioButton();
	truck.setText("Truck");
	truck.setUserData(Vehicle.VehicleType.TRUCK);
	truck.setToggleGroup(typeSelect);
	truck.setSelected(false);
        RadioButton motorBike = new RadioButton();
	motorBike.setText("Motor Bike");
	motorBike.setUserData(Vehicle.VehicleType.MOTORBIKE);
	motorBike.setToggleGroup(typeSelect);
	motorBike.setSelected(false);
        RadioButton electricCar = new RadioButton();
	electricCar.setText("Electric Car");
	electricCar.setUserData(Vehicle.VehicleType.ELECTRIC);
	electricCar.setToggleGroup(typeSelect);
	electricCar.setSelected(false);
        SpinnerValueFactory<Integer> floor = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,3,1,1);
        Spinner floors = new Spinner();
        floors.setPrefSize(50, 30);
        floors.setValueFactory(floor);
        Label floorLabel = new Label("Select Floor");
	floorLabel.setFont(new Font("Calibri", 15));
        VBox floorVbox = new VBox();
        floorVbox.getChildren().addAll(floorLabel,floors);
        floors.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
            floorNumber = Integer.toString(newValue);
            }
    });
        RadioButton handicappedSpot = new RadioButton();
	handicappedSpot.setText("Compact vehicle\nfor Handicapped");
	handicappedSpot.setUserData(Vehicle.VehicleType.HANDICAPPED);
	handicappedSpot.setToggleGroup(typeSelect);
	handicappedSpot.setSelected(false);
        customerPane.getChildren().add(floorVbox);
        floorVbox.relocate(330, 170);
        type.getChildren().addAll(car,van,truck,motorBike,electricCar, handicappedSpot);
        TextField licensePlate = new TextField();
        setDimensions(licensePlate, 20, 190, 300, customerPane);
        Label licensePlateLabel = new Label();
                setDimensions(licensePlateLabel, 20, 160, 280, customerPane);
		licensePlateLabel.setText("Enter License Plate (No Spaces)");
		licensePlateLabel.setFont(new Font("Calibri", 20));
        Label customarScreenLabe = new Label();
		setDimensions(customarScreenLabe, 10, 0, 280, customerPane);
		customarScreenLabe.setText("Choose your Vehicle type:");
		customarScreenLabe.setAlignment(Pos.CENTER);
		customarScreenLabe.setFont(new Font("Calibri", 20));
                
                select.getChildren().addAll(customarScreenLabe, type);
                customerPane.getChildren().add(select);
//                Vehicle vehicle = new Vehicle((Vehicle.VehicleType) typeSelect.getUserData(), );
                Button home = new Button("Home");
                home.setOnAction(new homeEventHandler());
                setDimensions(home, 50, 310, 300, customerPane);
		Button confirm = new Button("Proceed");
                confirm.setOnAction(new confirmEventHandler(licensePlate,typeSelect));
                setDimensions(confirm, 50, 280, 300, customerPane);
                Label balanceLabel = new Label();
		setDimensions(balanceLabel, 10, 230, 300, customerPane);
		balanceLabel.setText("Current time: " + date.format(now));
		balanceLabel.setAlignment(Pos.CENTER_RIGHT);
		balanceLabel.setFont(new Font("Calibri", 20));
                
                
                app.stage1.setTitle("Registration Screen");
		app.stage1.setScene(RegistrationScene);
		app.stage1.show();
    }
    private static class homeEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			ParkingApp.getSingletonMain().setState(new EntrancePanel());
		}}  
    private class confirmEventHandler implements EventHandler<ActionEvent> {
        private final TextField licensePlate;
        private final ToggleGroup typeSelect;
        public confirmEventHandler(TextField licensePlate, ToggleGroup typeSelect){
            this.licensePlate = licensePlate;
            this.typeSelect = typeSelect;
        }
        @Override
        public void handle(ActionEvent e) {
            if(licensePlate.getText().matches("[a-zA-Z0-9]+")){
            try{
                makeVehicle((Vehicle.VehicleType) typeSelect.getSelectedToggle().getUserData(), licensePlate.getText());
            }catch(NullPointerException error){
                Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "Parking spots for your vehicle are full", ButtonType.OK);
		duplicateUserError.setTitle("Sorry!");
		duplicateUserError.showAndWait();
                return;
                
            }
                File file = new File(ParkingApp.getSingletonMain().currentDirectory + vehicle.getTicket().getTicketNumber()+ ".txt");
                if(file.exists()){
					Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "Vehicle registration failed - Please try again", ButtonType.OK);
					duplicateUserError.setTitle("Vehicle registration Attempt Detected");
					duplicateUserError.showAndWait();
				}
                else{
					try{
                                               SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
						List<String> lines = Arrays.asList(vehicle.getLicensePlate() + "\n" + vehicle.getType() + "\n"+ vehicle.getTicket().getIssueTime() + "\n" + floorNumber);
						Path path = Paths.get(ParkingApp.getSingletonMain().currentDirectory + vehicle.getTicket().getTicketNumber()+ ".txt");
						Files.write(path, lines, StandardCharsets.UTF_8);
                                                LocalDateTime dateNow = null;
						Alert userCreationSuccess = new Alert(Alert.AlertType.NONE, "Vehicle registration success - Vehicle entered parking lot at " + vehicle.getTicket().getIssueTime() + "\nTicketNumber: " + vehicle.getTicket().getTicketNumber(), ButtonType.OK);
						userCreationSuccess.setTitle("Account Creation Attempt Detected");
						userCreationSuccess.showAndWait();
                                                ParkingApp.getSingletonDisplayBoard().setState(new ParkingDisplayBoard());
					}catch(IOException error){
						Alert fileCreationError = new Alert(Alert.AlertType.NONE, "Vehicle registration failed - File Creation Error", ButtonType.OK);
						fileCreationError.setTitle("Account Creation Attempt Detected");
						fileCreationError.showAndWait();
					} catch (ParseException ex) {
                        Logger.getLogger(RegistrationState.class.getName()).log(Level.SEVERE, null, ex);
                    }
				}}
            else{
                Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "Vehicle registration failed - Please enter License Plate again", ButtonType.OK);
		duplicateUserError.setTitle("Vehicle registration Attempt Detected");
		duplicateUserError.showAndWait();
            }
//                ParkingApp.getSingleton().setState(new RegistrationState());        
        }
}
    public Vehicle makeVehicle(Vehicle.VehicleType type, String licensePlate){
      if(type.equals(Vehicle.VehicleType.CAR)){
          vehicle = new Car(licensePlate, floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else if(type.equals(Vehicle.VehicleType.VAN)){
          vehicle = new Van(licensePlate,floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else if(type.equals(Vehicle.VehicleType.TRUCK)){
          vehicle = new Truck(licensePlate,floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else if(type.equals(Vehicle.VehicleType.ELECTRIC)){
          vehicle = new Electric(licensePlate,floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else if(type.equals(Vehicle.VehicleType.MOTORBIKE)){
          vehicle = new MotorBike(licensePlate,floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else if(type.equals(Vehicle.VehicleType.HANDICAPPED)){
          vehicle = new Handicapped(licensePlate,floorNumber);
          if(vehicle.getSpot().equals(null)) return null;
          else return vehicle;
      }
      else{
          System.out.println("No Valid Vehicle Type Entered");
          return null;
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
