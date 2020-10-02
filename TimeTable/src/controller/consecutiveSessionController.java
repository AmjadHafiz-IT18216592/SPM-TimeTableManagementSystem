package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DbUtil;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class consecutiveSessionController implements Initializable {
	@FXML
	private AnchorPane painPane;
	@FXML
	private Pane pane1;
	@FXML
	private Pane homepane;
	@FXML
	private Button homebutton;
	@FXML
	private Button daybutton;
	@FXML
	private Button lecturerbutton1;
	@FXML
	private Button studentbutton;
	@FXML
	private Button subjectbutton;
	@FXML
	private Button tagbutton;
	@FXML
	private Button locationbutton;
	@FXML
	private Button timetab;
	@FXML
	private TextField sto;
	@FXML
	private TextField to;
	@FXML
	private ComboBox<String> tag;
	@FXML
	private ComboBox<String> con;
   @FXML
   private Label sid,sub,loc,due,pretag;
   
 
   ObservableList<String> list1 = FXCollections.observableArrayList();

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		  ObservableList<String> list = FXCollections.observableArrayList("Lecture","Tutorial","Lab");
		  
		  
		pane1.setTranslateX(-343);
		sid.setText(Demo2Controller.val.getSid());
		sub.setText(Demo2Controller.val.getSsub());
		loc.setText(Demo2Controller.val.getSloc());
		due.setText(Demo2Controller.val.getSto().toString());
		pretag.setText(Demo2Controller.val.getStag());
		tag.setItems(list);
		
		
		
	}
	public void setfields(KeyEvent e) throws ClassNotFoundException, SQLException {
		list1.clear();
		String sql7 = "SELECT `FirstName`, `LastName` FROM `employee`";
		ResultSet rs7;
		
			rs7 = DbUtil.getValues(sql7);
			do{
				list1.add(rs7.getString(1)+" "+rs7.getString(2));
		         con.setItems(list1);
		        
	       } while(rs7.next()); 
		
	}
	
	
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
	
	
	public void run1(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.4));
		slide.setNode(pane1);
		
		slide.setToX(0);
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
		public void loadSession(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Demo2.fxml"));
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
    public void loadavail(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/availablity.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void addConsecutiveSession(ActionEvent e) throws ClassNotFoundException, SQLException {
		
		if(sto.getText().equals("")||con.getValue().equals("")||tag.getValue().equals("")) {
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
			String slotID= null;
			int flag = -1;
			float from = Float.parseFloat( due.getText());
			float to = Float.parseFloat(sto.getText());
			
			
			if(Demo2Controller.val.getSday().equalsIgnoreCase("monday")) {//Monday----------------------------------------
				
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`Monday` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);
				
				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `Monday`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				
				if(rs4.getRow() != 0) {
					flag = 1;
				}
				else
					flag = 0;
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("Tuesday")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`TuesDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);
			
				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `TuesDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;
				}
				else
					flag = 0;
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("WednesDay")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`WednesDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);
				
				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `WednesDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;
				}
				else
					flag = 0;
				
			  
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("ThursDay")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`ThursDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);

				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `ThursDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;
				}
				else
					flag = 0;
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("FriDay")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`FriDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);


				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `FriDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;
				}
				else
					flag = 0;
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("SatureDay")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`SatureDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);

				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `SatureDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;
					
				}
				else
					flag = 0;
			}
			else if(Demo2Controller.val.getSday().equalsIgnoreCase("SunDay")) {
				String sql4 = "\r\n" + 
						"select *\r\n" + 
						"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
						"where s.`SID` = l.`SID` AND\r\n" + 
						"      l.`EID` = e.`EID` AND\r\n" + 
						"      e.`EID` = we.`EID` AND\r\n" + 
						"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
						"      s.`LocationID` = '"+loc.getText()+"' AND\r\n" + 
						"      wt.`SunDay` = true AND\r\n" + 
						"      wt.`WorkingFrom` = '"+from+"' AND\r\n" + 
						"      wt.`WorkingTo` = '"+to+"'\r\n" + 
						"      \r\n" + 
						"";
				ResultSet rs4 = DbUtil.getValues(sql4);
				
				String sql11 ="SELECT `SlotID` FROM `workingday&time`"
						+ " WHERE `WorkingDays`=1 AND `SunDay`= true AND `WorkingFrom`='"+from+"' AND `WorkingTo`='"+to+"'";
				ResultSet rs11 = DbUtil.getValues(sql11);
				
				slotID = rs11.getString(1);
				if(rs4.getRow() != 0) {
					flag = 1;//Already fixed
					
				}
				else
					flag = 0;//Not fix yet
			}
			else {
				TrayNotification tray = new TrayNotification();
			 	String title = "Error!";
		        String message = "Please fill with valid day!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.ERROR);
		        tray.showAndDismiss(Duration.seconds(5));
			}
			
			
			
			if(flag == 0) {
				System.out.println("------------------"+flag);
				
				
				//float to = Float.parseFloat(sto.getText().toString());
				float duration = (to-Demo2Controller.val.getSfrom())/10000;
				
				int scount = Demo2Controller.val.getSs();
				
				String sql1 = "SELECT `SubjectCode` FROM `subject` WHERE `SubjectName` = '"+sub.getText()+"'";
				ResultSet rs1 = DbUtil.getValues(sql1);

				String sql2 = "SELECT `LocationID` FROM `location` WHERE `Room` ='"+loc.getText()+"'";
				ResultSet rs2 = DbUtil.getValues(sql2);
				
				System.out.println("--------------------------"+loc.getText());
				String sql3 ="INSERT INTO `session`(`Duration`, `StudentCount`, `LocationID`, `SubjectCode`, `SubGID`, `Type`) "
						+ "VALUES ('"+duration+"','"+scount+"','"+rs2.getString(1)+"','"+rs1.getString(1)+"','"+sid.getText()+"','"+tag.getValue()+"')";
				
				DbUtil.dbExecuteQuery(sql3);
				

				String sql5 ="SELECT `SID` FROM `session` WHERE `LocationID`='"+rs2.getString(1)+"' AND `SubjectCode`='"+rs1.getString(1)+"'  AND `SubGID` ='"+sid.getText()+"' AND `Type`='"+tag.getValue()+"'";
				ResultSet rs5 = DbUtil.getValues(sql5);
				
				//String sql6 = "SELECT `EID` FROM `employee` WHERE `FirstName`, `LastName`";
				//ResultSet rs6 = DbUtil.getValues(sql6);
				
				String sql7 = "SELECT `FirstName`,`LastName` FROM `employee`";
				ResultSet rs7 = DbUtil.getValues(sql7);
				
				do{
					
					if(con.getValue().equals(rs7.getString(1)+" "+rs7.getString(2))) {
						
						String sql8 = "SELECT `EID` FROM `employee` WHERE  `FirstName`='"+rs7.getString(1)+"' AND `LastName`='"+rs7.getString(2)+"'";
						ResultSet rs8 = DbUtil.getValues(sql8);
						String sql9 = "INSERT INTO `lectures`(`EID`, `SID`) VALUES ('"+rs8.getString(1)+"','"+rs5.getString(1)+"')";
						DbUtil.dbExecuteQuery(sql9);
						
						String sql10 = "INSERT INTO `workingemployee`(`EID`, `SlotID`) VALUES ('"+rs8.getString(1)+"','"+slotID+"')";
						DbUtil.dbExecuteQuery(sql10);
					}
			         
		       } while(rs7.next());
			
				
				
				
			       TrayNotification tray = new TrayNotification();
				 	String title = "Success!";
			        String message = "Session added succsessfully!";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.SUCCESS);
			        tray.showAndDismiss(Duration.seconds(5));
			}else {

			       TrayNotification tray = new TrayNotification();
				 	String title = "Error";
			        String message = "Location already booked from '"+from/10000+"'0 to '"+to/10000+"'0 ";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndDismiss(Duration.seconds(6));
			}
		}
		
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
