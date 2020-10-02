package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.Lecturers;
import database.DbUtil;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class LecturersController implements Initializable {
	
	@FXML
	private Button homebutton;
	@FXML
	private Pane homepane;
	@FXML
	private Pane pane1;
	@FXML
	private ScrollPane spane;
	@FXML
	private AnchorPane pane2;
	
	@FXML
	private TextField fname;
	@FXML
	private TextField lname;

	@FXML
	private ComboBox<String> faculty;
	@FXML
	private ComboBox<String> department;
	@FXML
	private ComboBox<String> center;
	@FXML
	private ComboBox<String> building;
	@FXML
	private ComboBox<String> type;
	
	
	@FXML
	private TableView<Lecturers> lecturers_tbl;
	@FXML
	private TableColumn<Lecturers,Integer> eid_tbl;
	@FXML
	private TableColumn<Lecturers,String> fname_tbl;
	@FXML
	private TableColumn<Lecturers,String> lname_tbl;
	@FXML
	private TableColumn<Lecturers,String> faculty_tbl;
	@FXML
	private TableColumn<Lecturers,String> department_tbl;
	@FXML
	private TableColumn<Lecturers,String> center_tbl;
	@FXML
	private TableColumn<Lecturers,String> building_tbl;
	@FXML
	private TableColumn<Lecturers,String> type_tbl;
	
	private String p ;
	private Integer y, sem;
	private Integer selectedLec;
	
	ObservableList<String> list = FXCollections.observableArrayList("Computing","Engineering","Business","Humanities & Science");
	ObservableList<String> list2 = FXCollections.observableArrayList("Software Engineering","Information Technology","Cyber Security","Networking","Management");
    ObservableList<String> list3 = FXCollections.observableArrayList("Malabe","Metro","Matara","Kandy","Kurunagala","Jaffna");
    ObservableList<String> list4 = FXCollections.observableArrayList("New Building","D- Block");
    ObservableList<String> list5 = FXCollections.observableArrayList("1- Professor","2- Assistant Professor","3- Senior Lecturer(HG)","4- Senior Lecturer","5- Lecturer","6- Assistant Lecturer","7- Instructors");
	@FXML
	private TextField prog;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		faculty.setItems(list);
		department.setItems(list2);
		center.setItems(list3);
		building.setItems(list4);
		type.setItems(list5);
		
		pane1.setTranslateX(-343);
	}

	@FXML
	public void run2(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.4));
			slide.setNode(pane1);
			
			slide.setToX(-343);
			slide.play();
		 
			
			pane1.setTranslateX(0);
			
			slide.setOnFinished(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					//pane1.setVisible(true);
					//spane.setVisible(true);
					//pane2.setVisible(true);
				}
			});
			 
		
		
	}
	
	@FXML
	public void run1(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.4));
		slide.setNode(pane1);
		
		slide.setToX(0);
		//slide.set
		slide.play();
		
		pane1.setTranslateX(-343);
		
		slide.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				//pane1.setVisible(false);
				//spane.setVisible(true);
				//pane2.setVisible(true);
			}
		});
	}
	
	 
	
	public void addLecturers(ActionEvent e) throws ClassNotFoundException, SQLException {
		System.out.println("================== ");
		//if(eid.getText().equals("")||fname.getText().equals("")||lname.getText().equals("")||category.getText().equals("")||level.getValue()==null||center.getValue()==null||building.getValue()==null||faculty.getValue()==null||department.getValue()==null){
			System.out.println("================== ");
			//TrayNotification tray = new TrayNotification();
			   // String title = "Empty!";
		        //String message ="Please fill the fiels and try!";
		        //Notification notification = Notification.SUCCESS;
		        //tray.setTitle(title);
		        //tray.setMessage(message);
		        //tray.setNotificationType(NotificationType.WARNING);
		        //tray.showAndDismiss(Duration.seconds(5));
			//}
			 
				
				 
				 String v = faculty.getValue();
				 if( v == "Computing" ||v == "Engineering" ||v == "Business" ||v == "Humanities & Science") {
				 String s1 = department.getValue();
				 if( s1 == "Software Emgineering"|| s1 == "Information Technology"||s1 == "Cyber Security"||s1==  "Networking"|| s1 == "Management" ) {
				 String s2=center.getValue();
				 if(s2=="Malabe"|| s2 == "Metro"|| s2 == "Matara"|| s2 == "Kandy"||s2 == "Kurunagala"|| s2 == "Jaffna") {
				 String s3=building.getValue();	
				 if(s3 == "New Building"||s3 == "D- Block"){
				 String s4=type.getValue();
			     if(s4 == "1- Professor"||s4 == "2- Assistant Professor"||s4 == "3- Senior Lecturer(HG)"||s4 == "4- Senior Lecturer"||s4 == "5- Lecturer"||s4 == "6- Assistant Lecturer"||s4 == "7- Instructors"){
				
					  
			   	ObservableList<Lecturers> data  = FXCollections.observableArrayList();
			   	data.clear();
			   	eid_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,Integer>("EID"));
				fname_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("FirstName"));
				lname_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("LastName"));
				faculty_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Faculty"));
				department_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Department"));
				center_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Center"));
				building_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Building"));
				type_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Type"));
				
				
				
				   // int eeid = Integer.parseInt(eid.getText());
					String fnam = fname.getText();
					String lnam = lname.getText();
					String fac = faculty.getValue();
					String dep = department.getValue();
					String cen = center.getValue();
					String bul = building.getValue();
					String typ=type.getValue();
					
					
					
					
					
					int level = 0;
					
				 String sql1 = "INSERT INTO employee(`FirstName`, `LastName`, `Type`,`Level`, `Center`, `Building`, `Faculty`, `Department`) VALUES ('"+fnam+"','"+lnam+"','"+typ+"','"+level+"','"+cen+"','"+bul+"','"+fac+"','"+dep+"')";
				 		    DbUtil.dbExecuteQuery(sql1);
		     
					  String sql2 ="SELECT * FROM employee";
			      
			       ResultSet rs = DbUtil.getValues(sql2);
			       do {
			       Lecturers std =  new Lecturers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				    data.add(std);
			       }while(rs.next());
			       lecturers_tbl.setItems(data);
			       System.out.println("================== ");
			       TrayNotification tray = new TrayNotification();
			      // 
				 	String title = "Success!";
			        String message = "Details entered succsessfully!";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			       tray.setMessage(message);
			        tray.setNotificationType(NotificationType.SUCCESS);
			        tray.showAndDismiss(Duration.seconds(5));

					
				 }
					 else {
						 TrayNotification tray = new TrayNotification();
						 	String title = "Wrong!";
					        String message = "Please fill by correct Level!";
					        //Notification notification = Notification.SUCCESS;
					        tray.setTitle(title);
					        tray.setMessage(message);
					        tray.setNotificationType(NotificationType.ERROR);
					        tray.showAndDismiss(Duration.seconds(5));
					 }
					
				 }
				 else {
					 TrayNotification tray = new TrayNotification();
					 	String title = "Wrong!";
					 	String message = "Please fill by correct Center!";
				        
				        //Notification notification = Notification.SUCCESS;
				        tray.setTitle(title);
				        tray.setMessage(message);
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndDismiss(Duration.seconds(5));
				 }
			 }
				 else {
					 TrayNotification tray = new TrayNotification();
					 	String title = "Wrong!";
					 	String message = "Please fill by correct Building!";
				        //Notification notification = Notification.SUCCESS;
				        tray.setTitle(title);
				        tray.setMessage(message);
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndDismiss(Duration.seconds(5));
				 }
			 }
				else {
					 TrayNotification tray = new TrayNotification();
					 	String title = "Wrong!";
					 	String message = "Please fill by correct Faculty!";
				        
				        //Notification notification = Notification.SUCCESS;
				        tray.setTitle(title);
				        tray.setMessage(message);
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndDismiss(Duration.seconds(5));
				 }
			 }
				else {
					 TrayNotification tray = new TrayNotification();
					 	String title = "Wrong!";
					 	 String message = "Please fill by correct Department!";
				        //Notification notification = Notification.SUCCESS;
				        tray.setTitle(title);
				        tray.setMessage(message);
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndDismiss(Duration.seconds(5));
				 }
			 }
		
		

	
	public void clearAll(ActionEvent e) {
		
		// eid.setText(null);
		 fname.setText(null);
		 lname.setText(null);
		 type.setItems(null);
		 center.setItems(null);
		 building.setItems(null);
		 faculty.setItems(null);
		 department.setItems(null);
		 
		 lecturers_tbl.setItems(null);
		 
	 }
	 public void viewLectures(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	 ObservableList<Lecturers> data  = FXCollections.observableArrayList();
	    	 System.out.println("================== a");
	    	 	eid_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,Integer>("EID"));
				fname_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("FirstName"));
				lname_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("LastName"));
				faculty_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Faculty"));
				department_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Department"));
				center_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Center"));
				building_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Building"));
				type_tbl.setCellValueFactory(new PropertyValueFactory<Lecturers,String> ("Type"));
				System.out.println("================== b");
 			  String sql1 ="SELECT * FROM employee";
 			 System.out.println("================== c");
		       ResultSet rs = DbUtil.getValues(sql1);
		       
		       
		       do{
					Lecturers std =  new Lecturers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
					System.out.println("================== d");
		       	    data.add(std);
					
		       }while(rs.next());
		        lecturers_tbl.setItems(data);
		           
	     }
	     
	     public void getDetails(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
			
			  Lecturers selected =lecturers_tbl.getSelectionModel().getSelectedItem();
			  if(selected == null) {
				  TrayNotification tray = new TrayNotification();
				 String title = "Row isn't selected!";
			        String message = "Please select a row in table.";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			       tray.setMessage(message);
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndDismiss(Duration.seconds(4));
			
				  
			  }
			  else {
				   int index =lecturers_tbl.getSelectionModel().getSelectedIndex();
				   
				     System.out.println("================== "+index);
				   
				     selectedLec=selected.getEID();
					
					 fname.setText(selected.getFirstName());
					 lname.setText(selected.getLastName());
					 faculty.setValue(selected. getFaculty().toString());
					 department.setValue(selected.getDepartment().toString());
					 center.setValue(selected.getCenter().toString());
					 building.setValue(selected.getBuilding().toString());
					 type.setValue(selected.getType());
					 
	
				   System.out.println("================== "+index);
			  }
			
			
		  }
	     
	    public void editLecturers(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	if( fname.getText().equals("") || lname.getText().equals("")||type.getValue() == null||center.getValue() == null ||faculty.getValue() == null|| department.getValue() == null || building.getValue() == null ){
	    		 TrayNotification tray = new TrayNotification();
				 	String title = "Unable edit!";
			        String message = "Select a row to get details.";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			      tray.setMessage(message);
			        tray.setNotificationType(NotificationType.WARNING);
			        tray.showAndDismiss(Duration.seconds(4));
			  
		 }
		   
			   TrayNotification tray = new TrayNotification();
			 	String title = "Updated!";
		       String message = "Successfully Updated.";
		       // Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.SUCCESS);
		        tray.showAndDismiss(Duration.seconds(4));
			    
				String fnam = fname.getText();
				String lnam = lname.getText();
				String typ=type.getValue();
				String cen = center.getValue();
				String bul = building.getValue();
				String fac = faculty.getValue();
				String dep = department.getValue();
				
				String sql = "\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"UPDATE employee SET `FirstName`='"+fnam+"',`LastName`='"+lnam+"',`Type`='"+typ+"',`Center`='"+cen+"',`Building`='"+bul+"',`Faculty`='"+fac+"',`Department`='"+dep+"'"
						+ "WHERE `EID`='"+selectedLec+"'";
				
					DbUtil.dbExecuteQuery(sql);
					viewLectures(e);}
					
			   
	   
	 
	public void deleteLecturers(ActionEvent e) throws ClassNotFoundException, SQLException {
		if( fname.getText().equals("") || lname.getText().equals("")||faculty.getValue() == null|| department.getValue() == null ||center.getValue() == null || building.getValue() == null||type.getValue() == null) {
	    		    
			     TrayNotification tray = new TrayNotification();
			 	  String title = "Unable delete!";
		           String message = "Select a row to get details.";
		        //Notification notification = Notification.SUCCESS;
		         tray.setTitle(title);
		         tray.setMessage(message);
		         tray.setNotificationType(NotificationType.WARNING);
		          tray.showAndDismiss(Duration.seconds(4));
		  
	   }
	   else {
		System.out.println("=============="+selectedLec);
		String sql1 = "DELETE FROM `employee` WHERE `EID`='"+selectedLec+"'";
		DbUtil.dbExecuteQuery(sql1);
		viewLectures(e);
		TrayNotification tray = new TrayNotification();
	 	String title = "Deleted!";
         String message = "Successfully deleted.";
        //Notification notification = Notification.SUCCESS;
          tray.setTitle(title);
         tray.setMessage(message);
         tray.setNotificationType(NotificationType.SUCCESS);
         tray.showAndDismiss(Duration.seconds(4));
         }
	}


	 @FXML
		public void loadHome(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/home.fxml"));
			homepane.getChildren().setAll(pane);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	 @FXML
     public void loadSubject(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Subjects.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		@FXML
		public void loadStudent(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/student.fxml"));
			homepane.getChildren().setAll(pane);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	@FXML
    public void loadTags(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/tags.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
