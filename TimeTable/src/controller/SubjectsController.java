package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.Subjects;
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


public class SubjectsController implements Initializable {
	
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
	private ComboBox<Integer> offeredyear;
	@FXML
	private ComboBox<Integer> offeredsemester;
	@FXML
	private TextField subjectcode;
	@FXML
	private TextField subjectname;
	
	@FXML
	private TextField lechours;
	@FXML
	private TextField thours;
	@FXML
	private TextField lhours;
	@FXML
	private TextField ehours;
	
	@FXML
	private TableView<Subjects> subjects_tbl;
	@FXML
	private TableColumn<Subjects,Integer> offeredyear_tbl;
	@FXML
	private TableColumn<Subjects,Integer> offeredsemester_tbl;
	@FXML
	private TableColumn<Subjects,String> subjectcode_tbl;
	@FXML
	private TableColumn<Subjects,String> subjectname_tbl;
	@FXML
	private TableColumn<Subjects,Integer> lechours_tbl;
	@FXML
	private TableColumn<Subjects,Integer> thours_tbl;
	@FXML
	private TableColumn<Subjects,Integer> lhours_tbl;
	@FXML
	private TableColumn<Subjects,Integer> ehours_tbl;
	
	
	private String p ;
	private Integer y, sem;

	private String selectedSub;
	ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4);
    ObservableList<Integer> list2 = FXCollections.observableArrayList(1,2);
    
	@FXML
	private TextField prog;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		offeredyear.setItems(list);
		offeredsemester.setItems(list2);
		
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
	
	
	


	
	 
	
	public void addsubject(ActionEvent e) throws ClassNotFoundException, SQLException {
		 if(offeredyear.getValue() == null || offeredsemester.getValue() == null ||subjectcode.getText().equals("")||subjectname.getText().equals("")||lechours.getText().equals("")||thours.getText().equals("")||lhours.getText().equals("")||ehours.getText().equals("")){
				
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
				 int v = offeredyear.getValue();
				 if( v == 1 ||v == 2 ||v == 3 ||v == 4) {
					 int s1 = offeredsemester.getValue();
					 if( s1 == 1 || s1 == 2) {
				
			   	 ObservableList<Subjects> data  = FXCollections.observableArrayList();
			   	 data.clear();
			   	
				subjectcode_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,String> ("SubjectCode"));
				subjectname_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,String> ("SubjectName"));
				lechours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("LectureHours"));
				thours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("TutorialHour"));
				lhours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("LabHour"));
				ehours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("EvaluationHour"));
				offeredyear_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer>("OfferedYear"));
				offeredsemester_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("OfferedSemester"));
					
					
					
					String scod = subjectcode.getText();
					String sname = subjectname.getText();
					int lthou = Integer.parseInt(lechours.getText());
					int thou = Integer.parseInt(thours.getText());
					int lhou = Integer.parseInt(lhours.getText());
					int ehou = Integer.parseInt(ehours.getText());
					int y = offeredyear.getValue();
				   	int sm = offeredsemester.getValue();
					
				
				String sql ="INSERT INTO subject (`SubjectCode`,`SubjectName`,`NoOfLectureHours`,`NoOfTutorialHours`,`NoOfLabeHours`,`NoOfEvaluationHours`,`OfferdYear`,`OfferdSemester`)  VALUES('"+scod+"','"+sname+"','"+lthou+"','"+thou+"','"+lhou+"','"+ehou+"','"+y+"','"+sm+"')";
				
		     DbUtil.dbExecuteQuery(sql);
		     System.out.println("============");
		     
					 String sql1 ="SELECT * FROM subject";
			      
			       ResultSet rs = DbUtil.getValues(sql1);
			       
			    do {
			       Subjects std =  new Subjects(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
				    data.add(std);
				    
			    } while(rs.next());
			    subjects_tbl.setItems(data);
			        
			       
			       
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
					 
						 
					System.out.println("_____________");
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
		 
		offeredyear.setValue(null);
		 offeredsemester.setValue(null);
		 subjectcode.setText(null);
		 subjectname.setText(null);
		 lechours.setText(null);
		 thours.setText(null);
		 lhours.setText(null);
		 ehours.setText(null);
		 
		 subjects_tbl.setItems(null);
		
		 
	 }
	 
	     public void viewSubjects(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	 ObservableList<Subjects> data  = FXCollections.observableArrayList();
		
		subjectcode_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,String> ("SubjectCode"));
		subjectname_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,String> ("SubjectName"));
		lechours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("LectureHours"));
		thours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("TutorialHour"));
		lhours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("LabHour"));
		ehours_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("EvaluationHour"));
		offeredyear_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer>("OfferedYear"));
		offeredsemester_tbl.setCellValueFactory(new PropertyValueFactory<Subjects,Integer> ("OfferedSemester"));
			
			  String sql1 ="SELECT * FROM subject";
		      
		       ResultSet rs = DbUtil.getValues(sql1);
		       
		       
		       do{
		    	   Subjects std =  new Subjects(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
					
		       	    data.add(std);
					
		       }while(rs.next());
		        subjects_tbl.setItems(data);
		           
	     }
	     
	     public void getDetails(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
			
			  Subjects selected = subjects_tbl.getSelectionModel().getSelectedItem();
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
				   int index =subjects_tbl.getSelectionModel().getSelectedIndex();
				   
				   System.out.println("================== "+index);
				   
				   	 selectedSub=selected.getSubjectCode();
					 subjectcode.setText(selected.getSubjectCode());
					  subjectname.setText(selected. getSubjectName());
					  lechours.setText(selected. getLectureHours().toString());
					  thours.setText(selected.getTutorialHour().toString());
					  lhours.setText(selected.getLabHour().toString());
					  ehours.setText(selected.getEvaluationHour().toString());
					  offeredyear.setValue(selected.getOfferedYear());
					  offeredsemester.setValue(selected.getOfferedSemester());
					  
					
					  
	
				   System.out.println("================== "+index);
			  }
			
			
		  }
	     
	    public void editSubjects(ActionEvent e) throws ClassNotFoundException, SQLException {
	    	if(offeredyear.getValue() == null || offeredsemester.getValue() == null || subjectcode.getText().equals("")||subjectname.getText().equals("")||lechours.getText().equals("")||thours.getText().equals("")||lhours.getText().equals("")||ehours.getText().equals("")){
				   
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
		       
		       
				
			
					
					
		        String scod = subjectcode.getText();
				String sname = subjectname.getText();
				int lthou = Integer.parseInt(lechours.getText());
				int thou = Integer.parseInt(thours.getText());
				int lhou = Integer.parseInt(lhours.getText());
				int ehou = Integer.parseInt(ehours.getText());
				int y = offeredyear.getValue();
			   	int sm = offeredsemester.getValue();
				   
				
				String sql = "\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"UPDATE subject SET `SubjectCode`='"+scod+"',`SubjectName`='"+sname+"',`NoOfLectureHours`='"+lthou+"',`NoOfTutorialHours`='"+thou+"',`NoOfLabeHours`='"+lhou+"',`NoOfEvaluationHours`='"+ehou+"',`OfferedYear`='"+y+"',`OfferedSemester`='"+sm+"' WHERE `SubjectCode`='"+selectedSub+"'";
				
					DbUtil.dbExecuteQuery(sql);
					viewSubjects(e);

					
				           
					 }
	    }
	 
	public void deleteSubjects(ActionEvent e) throws ClassNotFoundException, SQLException {
		if(offeredyear.getValue() == null || offeredsemester.getValue() == null || subjectcode.getText().equals("")||subjectname.getText().equals("")||lechours.getText().equals("")||thours.getText().equals("")||lhours.getText().equals("")||ehours.getText().equals("")){
			   
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
		System.out.println("=============="+selectedSub);
		String sql = "DELETE FROM subject WHERE `SubjectCode`='"+selectedSub+"'";
		DbUtil.dbExecuteQuery(sql);
		
		viewSubjects(e);
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
	    public void loadLectures(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Lecturers.fxml"));
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
