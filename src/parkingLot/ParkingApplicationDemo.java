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
import javafx.application.Application;
import static javafx.application.Application.launch;
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
import javafx.stage.Stage;
/**
 *
 * @author almuh
 */
public class ParkingApplicationDemo extends Application{
	@Override
	public void start(Stage primaryStage){
		ParkingApp.getSingletonMain().stage1 = primaryStage;
		ParkingApp.getSingletonMain().setState(new EntrancePanel());
                
                Stage secondaryStage = new Stage();
                ParkingApp.getSingletonExitPanel().stage2 = secondaryStage ;
		ParkingApp.getSingletonExitPanel().setState(new ExitPanel());
                
	}
	public static void main(String[] args){
		launch(args);
	}
        
}

