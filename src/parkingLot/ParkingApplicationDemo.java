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
		ParkingApp.getSingletonMain().setStateMain(new EntrancePanel());
                
                Stage secondaryStage = new Stage();
                ParkingApp.getSingletonExitPanel().stage2 = secondaryStage ;
		ParkingApp.getSingletonExitPanel().setStateExit(new ExitPanel());
                
                Stage DisplayBoardStage = new Stage();
                ParkingApp.getSingletonDisplayBoard().stage3 = DisplayBoardStage ;
		ParkingApp.getSingletonDisplayBoard().setStateDisplay(new ParkingDisplayBoard());
                
                Stage ElectricPanelStage = new Stage();
                ParkingApp.getSingletonElectricPanel().stage4 = ElectricPanelStage ;
		ParkingApp.getSingletonElectricPanel().setStateElectric(new ElectricPanel());
                
                Stage infoPanelStage = new Stage();
                ParkingApp.getSingletonInfoPortal().stage5 = infoPanelStage ;
		ParkingApp.getSingletonInfoPortal().setStateInfo(new InfoPortal());
	}
	public static void main(String[] args){
		launch(args);
	}
        
}

