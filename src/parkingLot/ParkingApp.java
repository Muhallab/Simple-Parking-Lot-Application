/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author almuh
 */
public class ParkingApp {
    
	public String currentDirectory = System.getProperty("user.dir") + "\\";
	public AppState currentAppState;
	public File currentMemberFile;
	public Stage stage1;
	public Stage stage2;
        public Stage stage3;
        public Stage stage4;
        public Stage stage5;
	public Scene scene;
	
	//Singleton Getter - Is responsible for maintaining exactly one cope of the application to maintain state coherency
	//Requires : Nothing
	//Modifies : In the case that the ParkingApp object was not instantiated, it modifies AppInstance to point to the singular instantiation of the object
	//Effects  : Ensures no duplicates of the program
	public static ParkingApp getSingletonMain(){return AppInstance==null ? AppInstance = new ParkingApp() : AppInstance;}
	public static ParkingApp getSingletonExitPanel(){return AppInstanceExit==null ? AppInstanceExit = new ParkingApp() : AppInstanceExit;}
	public static ParkingApp getSingletonDisplayBoard(){return AppInstanceExit==null ? AppInstanceExit = new ParkingApp() : AppInstanceExit;}
        public static ParkingApp getSingletonElectricPanel(){return AppInstanceExit==null ? AppInstanceExit = new ParkingApp() : AppInstanceExit;}
        public static ParkingApp getSingletonInfoPortal(){return AppInstanceExit==null ? AppInstanceExit = new ParkingApp() : AppInstanceExit;}

	private static ParkingApp AppInstance = null;
	private static ParkingApp AppInstanceExit = null;
	
	//Private Constructor - To ensure no undesired copies of the ParkingApp are able to be constructed
	//Requires : Nothing
	//Modifies : Nothing
	//Effects  : Ensures no duplicates of the program
	private ParkingApp(){}
	
	//Handling Function - Is responsible for actually altering the state of the program and reseting the GUI as required
	//Requires : A valid concrete implementation of the abstract class AppState to switch states to
	//Modifies : The program's current state and also the JavaFX GUI by calling a specific setGUI()
	//Effects  : Changes the GUI in a responsive fashion
	public void setState(AppState newState){
		currentAppState = newState;
		System.out.println(toString());
		currentAppState.setGUI(this);
	}
	
	//Rep Invariant
	//  currentAppState is always a member of the set {EntrancePanel, ManagerState, ExitPanel, ElectricPanel, RegistrationState, ParkingDisplayBoard, or CustomerState}
	public boolean repOK(){
		return ((currentAppState.getClass()==EntrancePanel.class)||
				(currentAppState.getClass()==ManagerState.class)||
				(currentAppState.getClass()==ExitPanel.class)||
                                (currentAppState.getClass()==ElectricPanel.class)||
                                (currentAppState.getClass()==RegistrationState.class)||
                                (currentAppState.getClass()==ParkingDisplayBoard.class)||
                                (currentAppState.getClass()==ElectricCustomerState.class))||
                                (currentAppState.getClass()==InfoPortal.class)||
                                (currentAppState.getClass()==CustomerStateInfoPortal.class)||
                                (currentAppState.getClass()==CustomerState.class);
	}
	
	//Abstract Function
	//  AF = Representation of GUI elements currently being displayed
	//       More detailed information in concrete classes instead of this dispatch class
	@Override
	public String toString(){
		String str = "";
		str += ("Currently displaying the UI for the program state of " + currentAppState.getClass().getSimpleName());
		if (currentMemberFile == null){
			str += ("; No specific member data loaded");
		}else{
			try{
				str += ("; Displaying user data of \"" + currentMemberFile.getCanonicalPath());
				str = str.replace(currentDirectory, "").replace(".txt", "");
				str += "\"";
			}catch(IOException error){
				System.out.println("IO Error Caught : " + error);			
			}
		}
		return str;
	}
}

