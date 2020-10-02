package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.students;

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

public class studentController  implements Initializable  {

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
	private TextField year;
	
	@FXML
	private TextField semester;
	
	@FXML
	private TextField programme;
	
	@FXML
	private TextField gno;
	
	@FXML
	private TextField subgno;
	
	@FXML
	private TextField gid;
	
	@FXML
	private TextField subgid;
	
	@FXML
	private TableView<students> student_tbl;
	@FXML
	private TableColumn<students,String> sid_tbl;
	@FXML
	private TableColumn<students,String> gid_tbl;
	@FXML
	private TableColumn<students,Integer> sno_tbl;
	@FXML
	private TableColumn<students,Integer> gno_tbl;
	@FXML
	private TableColumn<students,Integer> year_tbl;
	@FXML
	private TableColumn<students,Integer> sem_tbl;
	@FXML
	private TableColumn<students,String> prog_tbl;
 
	private String selectedSGID;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		pane1.setTranslateX(-343);
		//pane1.setVisible(true);
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
	
	 @FXML
	public void addStudent(ActionEvent e) throws ClassNotFoundException, SQLException {


		 if(subgno.getText().equals("") || year.getText().equals("") ||semester.getText().equals("") || gno.getText().equals("") || programme.getText().equals("")  ){
				
			 TrayNotification tray = new TrayNotification();
			 	String title = "Empty!";
		        String message = "Please fill the fiels and try!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.WARNING);
		        tray.showAndDismiss(Duration.seconds(5));
		 }
		 else {
			 int v = Integer.parseInt(year.getText());
			 if( v == 1 ||v == 2 ||v == 3 ||v == 4) {
				 int s= Integer.parseInt(semester.getText());
				 if( s == 1 || s == 2) {
					 ObservableList<students> data  = FXCollections.observableArrayList();
					 	sid_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("SubGID"));
						gid_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("GID"));
						sno_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("SubGroupNo"));
						gno_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("GroupNo"));
						year_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("Year"));
						sem_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("Semester"));
						prog_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("Programme"));
						
				   int acyear = Integer.parseInt(year.getText());
					int acsem = Integer.parseInt(semester.getText());
					String prog = programme.getText();
					int g = Integer.parseInt(gno.getText());
				   int sg = Integer.parseInt(subgno.getText());
					
					String  idg , idsg;
					
				idg = "Y"+acyear+".S"+acsem+"."+prog+".0"+g+"";
				idsg = "Y"+acyear+".S"+acsem+"."+prog+".0"+g+"."+sg+"";
				gid.setText(idg);
				
				subgid.setText(idsg);
		     String sql1 = "INSERT INTO `student`(`SubGID`, `GID`, `SubGroupNo`, `GroupNo`, `Year`, `Semester`, `Programme`) VALUES ('"+idsg+"','"+idg+"','"+sg+"','"+g+"','"+acyear+"','"+acsem+"','"+prog+"')";
		     DbUtil.dbExecuteQuery(sql1);
		     
					  String sql2 ="SELECT * FROM student";
			      
			       ResultSet rs = DbUtil.getValues(sql2);
			       
			       students std =  new students(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
				    data.add(std);
			       student_tbl.setItems(data);
			       
			       TrayNotification tray = new TrayNotification();
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
				        String message = "Please fill by correct semester!";
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
			        String message = "Please fill by correct year!";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndDismiss(Duration.seconds(5));
			 }
		 }
	        
        		}
	 

	    
		public void clearAll(ActionEvent e) {
		 
		 year.setText(null);
		 semester.setText(null);
		  programme.setText(null);
		 gno.setText(null);
		 subgno.setText(null);
		 subgid.setText(null);
		 gid.setText(null);
		 student_tbl.setItems(null);
		 
	 }
	 
	     public void viewStudnets(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	 ObservableList<students> data  = FXCollections.observableArrayList();
 		 	sid_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("SubGID"));
 			gid_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("GID"));
 			sno_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("SubGroupNo"));
 			gno_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("GroupNo"));
 			year_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("Year"));
 			sem_tbl.setCellValueFactory(new PropertyValueFactory<students,Integer> ("Semester"));
 			prog_tbl.setCellValueFactory(new PropertyValueFactory<students,String> ("Programme"));
 			
 			  String sql1 ="SELECT * FROM student";
		      
		       ResultSet rs = DbUtil.getValues(sql1);
		       
		       
		       do{
					students std =  new students(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
					
		           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
					//table.getItems().add(profit);;
		       	    data.add(std);
					
		       }while(rs.next());
		        student_tbl.setItems(data);
		           
	     }
	     
	     public void getDetails(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
			
			  students selected = student_tbl.getSelectionModel().getSelectedItem();
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
				   int index =student_tbl.getSelectionModel().getSelectedIndex();
				   
				   System.out.println("================== "+index);
				   
					 year.setText(selected.getYear().toString());
					 semester.setText(selected.getSemester().toString());
					  programme.setText(selected.getProgramme());
					  gno.setText(selected.getGroupNo().toString());
					  subgno.setText(selected.getSubGroupNo().toString());
					  subgid.setText(selected.getSubGID());
					  selectedSGID = selected.getSubGID();
					  gid.setText(selected.getGID());
	
				   System.out.println("================== "+index);
			  }
			
			
		  }
	     
	    public void editStudents(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	if(subgno.getText().equals("") || year.getText().equals("") ||semester.getText().equals("") || gno.getText().equals("") || programme.getText().equals("")  ){
				   
	    		 TrayNotification tray = new TrayNotification();
				 	String title = "Unable edit!";
			        String message = "Select a row to get details.";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.WARNING);
			        tray.showAndDismiss(Duration.seconds(4));
			  
		   }
		   else {
			   TrayNotification tray = new TrayNotification();
			 	String title = "Updated!";
		        String message = "Successfully Updated.";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.SUCCESS);
		        tray.showAndDismiss(Duration.seconds(4));
				   int acyear = Integer.parseInt(year.getText());
					int acsem = Integer.parseInt(semester.getText());
					String prog = programme.getText();
					int g = Integer.parseInt(gno.getText());
				   int sg = Integer.parseInt(subgno.getText());
					
					String  idg , idsg;
					
				idg = "Y"+acyear+".S"+acsem+"."+prog+".0"+g+"";
				idsg = "Y"+acyear+".S"+acsem+"."+prog+".0"+g+"."+sg+"";
				gid.setText(idg);

				subgid.setText(idsg);
				
				String sql = "\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"UPDATE `student` SET `SubGID`='"+idsg+"',`GID`='"+idg+"',`SubGroupNo`='"+sg+"',`GroupNo`='"+g+"',`Year`='"+acyear+"',"
						+ "`Semester`='"+acsem+"',`Programme`='"+prog+"' "
						+ "WHERE `SubGID`= '"+selectedSGID+"'";
				
					DbUtil.dbExecuteQuery(sql);
					viewStudnets(e);
					
			   }
	    }
	 
	public void deleteStudent(ActionEvent e) throws ClassNotFoundException, SQLException {
		if(subgno.getText().equals("") || year.getText().equals("") ||semester.getText().equals("") || gno.getText().equals("") || programme.getText().equals("")  ){
			   
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
		System.out.println("=============="+selectedSGID);
		String sql = "DELETE FROM student WHERE `SubGID`= '"+selectedSGID+"'";
		DbUtil.dbExecuteQuery(sql);
		viewStudnets(e);
		TrayNotification tray = new TrayNotification();
	 	String title = "Deleted!";
        String message = "Successfully deleted.";
        //Notification notification = Notification.SUCCESS;
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(4));}
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
       public void loadTags(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/tags.fxml"));
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
 public void loadLectures(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Lecturers.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
