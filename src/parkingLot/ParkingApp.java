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
	public AppState currentAppStateMain;
        public AppState currentAppStateExit;
	public AppState currentAppStateDisplay;
	public AppState currentAppStateElectric;
	public AppState currentAppStateInfo;
	public File currentMemberFileMain;
        public File currentMemberFileExit;
	public File currentMemberFileDisplay;
	public File currentMemberFileElectric;
	public File currentMemberFileInfo;

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
	public static ParkingApp getSingletonDisplayBoard(){return AppInstanceDisplay==null ? AppInstanceDisplay = new ParkingApp() : AppInstanceDisplay;}
        public static ParkingApp getSingletonElectricPanel(){return AppInstanceElectric==null ? AppInstanceElectric = new ParkingApp() : AppInstanceElectric;}
        public static ParkingApp getSingletonInfoPortal(){return AppInstanceInfo==null ? AppInstanceInfo = new ParkingApp() : AppInstanceInfo;}

	private static ParkingApp AppInstance = null;
	private static ParkingApp AppInstanceExit = null;
        private static ParkingApp AppInstanceDisplay = null;
	private static ParkingApp AppInstanceElectric = null;
	private static ParkingApp AppInstanceInfo = null;

        
	
	//Private Constructor - To ensure no undesired copies of the ParkingApp are able to be constructed
	//Requires : Nothing
	//Modifies : Nothing
	//Effects  : Ensures no duplicates of the program
	private ParkingApp(){}
	
	//Handling Function - Is responsible for actually altering the state of the program and reseting the GUI as required
	//Requires : A valid concrete implementation of the abstract class AppState to switch states to
	//Modifies : The program's current state and also the JavaFX GUI by calling a specific setGUI()
	//Effects  : Changes the GUI in a responsive fashion
	public void setStateMain(AppState newState){
		currentAppStateMain = newState;
		System.out.println(toString());
		currentAppStateMain.setGUI(this);
	}
        public void setStateExit(AppState newState){
		currentAppStateExit = newState;
		System.out.println(toString());
		currentAppStateExit.setGUI(this);
	}
        public void setStateDisplay(AppState newState){
		currentAppStateDisplay = newState;
		System.out.println(toString());
		currentAppStateDisplay.setGUI(this);
	}
        public void setStateElectric(AppState newState){
		currentAppStateElectric = newState;
		System.out.println(toString());
		currentAppStateElectric.setGUI(this);
	}
        public void setStateInfo(AppState newState){
		currentAppStateInfo = newState;
		System.out.println(toString());
		currentAppStateInfo.setGUI(this);
	}
	
	//Rep Invariant
	//  currentAppState is always a member of the set {EntrancePanel, ManagerState, ExitPanel, ElectricPanel, RegistrationState, ParkingDisplayBoard, ElectricCustomerState, InfoPortal, CustomerStateInfoPortal or CustomerState}
	public boolean repOKMain(){
		return ((currentAppStateMain.getClass()==EntrancePanel.class)||
				(currentAppStateMain.getClass()==ManagerState.class)||
				(currentAppStateMain.getClass()==RegistrationState.class));
	}
        public boolean repOKDisplay(){
		return (currentAppStateDisplay.getClass()==ParkingDisplayBoard.class);
        }public boolean repOKExit(){
		return ((currentAppStateExit.getClass()==ExitPanel.class)||
				(currentAppStateExit.getClass()==CustomerState.class));
        }public boolean repOKElectric(){
		return ((currentAppStateElectric.getClass()==ElectricPanel.class)||
				(currentAppStateElectric.getClass()==ElectricCustomerState.class));
        }public boolean repOKInfo(){
		return ((currentAppStateInfo.getClass()==InfoPortal.class)||
				(currentAppStateInfo.getClass()==CustomerStateInfoPortal.class));
        }
        
			
	
	//Abstract Function
	//  AF = Representation of GUI elements currently being displayed
	//       More detailed information in concrete classes instead of this dispatch class
//	@Override
//	public String toString(){
//		String str = "";
//		str += ("Currently displaying the UI for the Entrance panel program state of " + currentAppStateMain.getClass().getSimpleName());
//		if (currentMemberFileMain == null){
//			str += ("; No specific member data loaded");
//		}else{
//			try{
//				str += ("; Displaying user data of \"" + currentMemberFileMain.getCanonicalPath());
//				str = str.replace(currentDirectory, "").replace(".txt", "");
//				str += "\"";
//			}catch(IOException error){
//				System.out.println("IO Error Caught : " + error);			
//			}
//		}
//                str += "\n";
//		str += ("Currently displaying the UI for the Display Board program state of " + currentAppStateDisplay.getClass().getSimpleName());
//		if (currentMemberFileDisplay == null){
//			str += ("; No specific member data loaded");
//		}else{
//			try{
//				str += ("; Displaying user data of \"" + currentMemberFileDisplay.getCanonicalPath());
//				str = str.replace(currentDirectory, "").replace(".txt", "");
//				str += "\"";
//			}catch(IOException error){
//				System.out.println("IO Error Caught : " + error);			
//			}
//		}
//                str += "\n";
//		str += ("Currently displaying the UI for the Electric Panel program state of " + currentAppStateElectric.getClass().getSimpleName());
//		if (currentMemberFileElectric == null){
//			str += ("; No specific member data loaded");
//		}else{
//			try{
//				str += ("; Displaying user data of \"" + currentMemberFileElectric.getCanonicalPath());
//				str = str.replace(currentDirectory, "").replace(".txt", "");
//				str += "\"";
//			}catch(IOException error){
//				System.out.println("IO Error Caught : " + error);			
//			}
//		}
//                str += "\n";
//		str += ("Currently displaying the UI for the Info Port program state of " + currentAppStateInfo.getClass().getSimpleName());
//		if (currentMemberFileInfo == null){
//			str += ("; No specific member data loaded");
//		}else{
//			try{
//				str += ("; Displaying user data of \"" + currentMemberFileInfo.getCanonicalPath());
//				str = str.replace(currentDirectory, "").replace(".txt", "");
//				str += "\"";
//			}catch(IOException error){
//				System.out.println("IO Error Caught : " + error);			
//			}
//		}
//                str += "\n";
//		str += ("Currently displaying the UI for the Exit Panel program state of " + currentAppStateExit.getClass().getSimpleName());
//		if (currentMemberFileExit == null){
//			str += ("; No specific member data loaded");
//		}else{
//			try{
//				str += ("; Displaying user data of \"" + currentMemberFileExit.getCanonicalPath());
//				str = str.replace(currentDirectory, "").replace(".txt", "");
//				str += "\"";
//			}catch(IOException error){
//				System.out.println("IO Error Caught : " + error);			
//			}
//		}
//		return str;
//	}
}

