package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.available;

import database.DbUtil;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class availablityController {
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
	private TableView<available> avail1_tbl,ses_tbl,g_tbl,sg_tbl;
	@FXML
	private TableColumn<available,String> day_tbl,sd,dg,dsg;
	@FXML
	private TableColumn<available,String> slot_tbl,sn,sg,ssg;
	@FXML
	private TextField fn,ln , year,sem,prog,yg,semg,progg,ysg,semsg,progsg;
	
	@FXML
     public ComboBox<String> dayf , dayf1,dayf2, dayf3,gid,sgid;
	
	@FXML
    public ComboBox<String> sub ;
	@FXML
    public ComboBox<String> ty ;
	String lname , fname,day,p;
	int y,semes;
	ObservableList<String> list2 = FXCollections.observableArrayList();
	ObservableList<String> list3 = FXCollections.observableArrayList();
	ObservableList<String> list4 = FXCollections.observableArrayList();
	ObservableList<String> list5 = FXCollections.observableArrayList();
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		pane1.setTranslateX(-343);
		//pane1.setTranslateX(-343);
		//pane1.setVisible(true);
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
	
	
	
	public void setComboBox(KeyEvent e) throws ClassNotFoundException, SQLException {
		
		
		ObservableList<String> list1 = FXCollections.observableArrayList("Monday","Tuesday","Wednessday","Thursday","Friday","Satureday","Sunday");
		  dayf.setItems(list1);
		  dayf1.setItems(list1);
		  dayf2.setItems(list1);
		  dayf3.setItems(list1);
       
	}
	public void fillLecturers(ActionEvent e) throws ClassNotFoundException, SQLException {
		
		avail1_tbl.setItems(null);
		 ObservableList<available> data  = FXCollections.observableArrayList();
 		 day_tbl.setCellValueFactory(new PropertyValueFactory<available,String> ("Day"));
 			slot_tbl.setCellValueFactory(new PropertyValueFactory<available,String> ("Not_Available_Slot"));
 			
		fname = fn.getText();
		lname = ln.getText();
		day = dayf.getValue();
		
		if(lname.equals(null)||fname.equals(null)|| dayf.getValue() == null) {
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
			
			String sql = "SELECT `EID` FROM employee WHERE `FirstName`='"+fname+"' AND `LastName` ='"+lname+"'";
			ResultSet rs = DbUtil.getValues(sql);
			
			if(rs.getRow() == 0) {
				TrayNotification tray = new TrayNotification();
			 	String title = "Wrong!";
		        String message = "Please try with a valid name!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.ERROR);
		        tray.showAndDismiss(Duration.seconds(5));
			}
			else {
				if(day.equalsIgnoreCase("Monday")) {

String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
						"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
						"WHERE  e.`EID`= we.`EID`\r\n" + 
						"       AND  wd.`Monday`=1\r\n" + 
						"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
						"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
				ResultSet rs1 = DbUtil.getValues(sql1);
				      
				       do{
							available al =  new available("Monday",rs1.getString(1)+" - "+rs1.getString(2));
							
				           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
							//table.getItems().add(profit);;
				       	    data.add(al);
							
				       }while(rs1.next());
				       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Tuesday")) {
					String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
							"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
							"WHERE  e.`EID`= we.`EID`\r\n" + 
							"       AND  wd.`TuesDay`=1\r\n" + 
							"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
							"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);
					      
					       do{
								available al =  new available("Tuesday",rs1.getString(1)+" - "+rs1.getString(2));
								
					           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
								//table.getItems().add(profit);;
					       	    data.add(al);
								
					       }while(rs1.next());
					       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Wednessday")) {
					String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
							"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
							"WHERE  e.`EID`= we.`EID`\r\n" + 
							"       AND  wd.`WednesDay`=1\r\n" + 
							"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
							"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);
					      
					       do{
								available al =  new available("Wednessday",rs1.getString(1)+" - "+rs1.getString(2));
								
					           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
								//table.getItems().add(profit);;
					       	    data.add(al);
								
					       }while(rs1.next());
					       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Thursday")) {
					String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
							"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
							"WHERE  e.`EID`= we.`EID`\r\n" + 
							"       AND  wd.`ThursDay`=1\r\n" + 
							"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
							"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);
					      
					       do{
								available al =  new available("Thursday",rs1.getString(1)+" - "+rs1.getString(2));
								
					           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
								//table.getItems().add(profit);;
					       	    data.add(al);
								
					       }while(rs1.next());
					       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Friday")) {
					String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
							"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
							"WHERE  e.`EID`= we.`EID`\r\n" + 
							"       AND  wd.`FriDay`=1\r\n" + 
							"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
							"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);
					      
					       do{
								available al =  new available("Friday",rs1.getString(1)+" - "+rs1.getString(2));
								
					           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
								//table.getItems().add(profit);;
					       	    data.add(al);
								
					       }while(rs1.next());
					       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Satureday")) {
					String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
							"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
							"WHERE  e.`EID`= we.`EID`\r\n" + 
							"       AND  wd.`SatureDay`=1\r\n" + 
							"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
							"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);
					      
					       do{
								available al =  new available("Satureday",rs1.getString(1)+" - "+rs1.getString(2));
								
					           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
								//table.getItems().add(profit);;
					       	    data.add(al);
								
					       }while(rs1.next());
					       avail1_tbl.setItems(data);
				}
				else if(day.equalsIgnoreCase("Sunday")) {String sql1 = "SELECT  `WorkingFrom`, `WorkingTo`\r\n" + 
						"FROM `workingemployee` we,`employee` e,`workingday&time` wd\r\n" + 
						"WHERE  e.`EID`= we.`EID`\r\n" + 
						"       AND  wd.`SunDay`=1\r\n" + 
						"       AND we.`SlotID` = wd.`SlotID`\r\n" + 
						"       AND e.`FirstName`='"+fname+"' AND e.`LastName` ='"+lname+"'";
				ResultSet rs1 = DbUtil.getValues(sql1);
				      
				       do{
							available al =  new available("Sunday",rs1.getString(1)+" - "+rs1.getString(2));
							
				           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
							//table.getItems().add(profit);;
				       	    data.add(al);
							
				       }while(rs1.next());
				       avail1_tbl.setItems(data);}
				else {
					System.out.println("00000000000000000000000000000000000000");
				}
				
			}
			
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
	
	public void setfields(KeyEvent e) throws ClassNotFoundException, SQLException {
		list2.clear();
		y = Integer.parseInt(year.getText());
		semes = Integer.parseInt(sem.getText());
		
		
		p = prog.getText();
		 //System.out.println("---------------------------------"+p.toString());
		String sql1 = "SELECT DISTINCT `SubjectName`  FROM subject WHERE `OfferdYear` ='"+y+"' AND `OfferdSemester` = '"+semes+"'  AND `SubjectCode` LIKE '"+p+"%'"; // 
		ResultSet rs1 = DbUtil.getValues(sql1);
		do{
			list2.add(rs1.getString(1));
	         sub.setItems(list2);
       } while(rs1.next());
		
		
	}
	public void setfTagCombo(ActionEvent e) throws ClassNotFoundException, SQLException {
		list3.clear();
	
		String s = sub.getValue();
		 //System.out.println("---------------------------------"+p.toString());
		String sql1 = "SELECT t.`Type` FROM subject s ,tag t WHERE t.`SubjectCode`=s.`SubjectCode` AND s.`SubjectName` ='"+s+"'";
		ResultSet rs1 = DbUtil.getValues(sql1);
		do{
			list3.add(rs1.getString(1));
	       //  sub.setItems(list3);
			ty.setItems(list3);
       } while(rs1.next());
		
		
	}
	
	public void fillSession(ActionEvent e) throws ClassNotFoundException, SQLException {
		
         ses_tbl.setItems(null);
         ObservableList<available> data  = FXCollections.observableArrayList();
 		 sd.setCellValueFactory(new PropertyValueFactory<available,String> ("Day"));
 			sn.setCellValueFactory(new PropertyValueFactory<available,String> ("Not_Available_Slot"));
 			
       
         int  v = Integer.parseInt(year.getText());
         int s1 = Integer.parseInt(sem.getText());
         String prog1 = prog.getText();
         
         if(year.getText().equals(null)||sem.getText().equals(null)||prog1.equals(null)||sub.getValue() == null||dayf1.getValue() == null|| ty.getValue() == null) {
        	
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
        	 
        	 if( v == 1 ||v == 2 ||v == 3 ||v == 4) {
				 if( s1 == 1 || s1 == 2) {
					 
					 String s = sub.getValue();
					 String t = ty.getValue();
					 day = dayf1.getValue();
						/*
						 * String sql = "SELECT `SubjectCode` FROM `subject` WHERE  `SubjectName` = '"+s+"'";
						ResultSet rs1 = DbUtil.getValues(sql);
						
						 */
					 if(day.equalsIgnoreCase("Monday")) {

						 String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
				      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
				      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
				      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
				      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
				      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
				      				"        AND se.`Type`='"+t+"'\r\n" +
				      				"        AND  wd.`Monday`=1\r\n" +
				      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
				      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
				      				"        AND se.`SID`= l.`SID`\r\n" + 
				      				"        AND e.`EID`= l.`EID`\r\n" + 
				      				"        AND e.`EID`= we.`EID`\r\n" + 
				      				"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql2);
							
								 do{
										available al =  new available("Monday",rs2.getString(1)+" - "+rs2.getString(2));
										
							           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
										//table.getItems().add(profit);;
							       	    data.add(al);
										
							       }while(rs2.next());
							       ses_tbl.setItems(data);
					 }
					 else if(day.equalsIgnoreCase("Tuesday")) {
						 //`TuesDay`=1
						 String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
				      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
				      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
				      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
				      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
				      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
				      				"        AND se.`Type`='"+t+"'\r\n" +
				      				"        AND  wd.`TuesDay`=1\r\n" +
				      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
				      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
				      				"        AND se.`SID`= l.`SID`\r\n" + 
				      				"        AND e.`EID`= l.`EID`\r\n" + 
				      				"        AND e.`EID`= we.`EID`\r\n" + 
				      				"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql2);
							
								 do{
										available al =  new available("Tuesday",rs2.getString(1)+" - "+rs2.getString(2));
										
							           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
										//table.getItems().add(profit);;
							       	    data.add(al);
										
							       }while(rs2.next());
							       ses_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Wednessday")) {
							//`WednesDay`=1
							 String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
					      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
					      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
					      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
					      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
					      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
					      				"        AND se.`Type`='"+t+"'\r\n" +
					      				"        AND  wd.`WednesDay`=1\r\n" +
					      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
					      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
					      				"        AND se.`SID`= l.`SID`\r\n" + 
					      				"        AND e.`EID`= l.`EID`\r\n" + 
					      				"        AND e.`EID`= we.`EID`\r\n" + 
					      				"        AND wd.`SlotID`= we.`SlotID`";
							 
								ResultSet rs2 = DbUtil.getValues(sql2);
								
									 do{
											available al =  new available("Wednesday",rs2.getString(1)+" - "+rs2.getString(2));
											
								           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
											//table.getItems().add(profit);;
								       	    data.add(al);
											
								       }while(rs2.next());
								       ses_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Thursday")) {
							//`ThursDay`=1
							 String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
					      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
					      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
					      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
					      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
					      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
					      				"        AND se.`Type`='"+t+"'\r\n" +
					      				"        AND  wd.`ThursDay`=1\r\n" +
					      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
					      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
					      				"        AND se.`SID`= l.`SID`\r\n" + 
					      				"        AND e.`EID`= l.`EID`\r\n" + 
					      				"        AND e.`EID`= we.`EID`\r\n" + 
					      				"        AND wd.`SlotID`= we.`SlotID`";
							 
								ResultSet rs2 = DbUtil.getValues(sql2);
								
									 do{
											available al =  new available("Thursday",rs2.getString(1)+" - "+rs2.getString(2));
											
								           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
											//table.getItems().add(profit);;
								       	    data.add(al);
											
								       }while(rs2.next());
								       ses_tbl.setItems(data);
						}
						else if(day.equalsIgnoreCase("Friday")) {
							//`FriDay`=1
							String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
				      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
				      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
				      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
				      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
				      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
				      				"        AND se.`Type`='"+t+"'\r\n" +
				      				"        AND  wd.`FriDay`=1\r\n" +
				      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
				      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
				      				"        AND se.`SID`= l.`SID`\r\n" + 
				      				"        AND e.`EID`= l.`EID`\r\n" + 
				      				"        AND e.`EID`= we.`EID`\r\n" + 
				      				"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql2);
							
								 do{
										available al =  new available("Friday",rs2.getString(1)+" - "+rs2.getString(2));
										
							           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
										//table.getItems().add(profit);;
							       	    data.add(al);
										
							       }while(rs2.next());
							       ses_tbl.setItems(data);
						}
						else if(day.equalsIgnoreCase("Satureday")) {
							//`SatureDay`=1
							String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
				      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
				      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
				      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
				      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
				      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
				      				"        AND se.`Type`='"+t+"'\r\n" +
				      				"        AND  wd.`SatureDay`=1\r\n" +
				      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
				      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
				      				"        AND se.`SID`= l.`SID`\r\n" + 
				      				"        AND e.`EID`= l.`EID`\r\n" + 
				      				"        AND e.`EID`= we.`EID`\r\n" + 
				      				"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql2);
							
								 do{
										available al =  new available("Satureday",rs2.getString(1)+" - "+rs2.getString(2));
										
							           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
										//table.getItems().add(profit);;
							       	    data.add(al);
										
							       }while(rs2.next());
							       ses_tbl.setItems(data);
						}
						else if(day.equalsIgnoreCase("Sunday")) {
							//`SunDay`
							String sql2 ="SELECT `WorkingFrom`, `WorkingTo`\r\n" + 
				      				"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`subject` sb,`session` se,`student` s,`lectures` l\r\n" + 
				      				"WHERE   sb.`SubjectName`='"+s+"'\r\n" + 
				      				"        AND sb.`OfferdYear`='"+v+"'\r\n" + 
				      				"        AND sb.`OfferdSemester`='"+s1+"'\r\n" + 
				      				"        AND s.`Programme`='"+prog1+"'\r\n" + 
				      				"        AND se.`Type`='"+t+"'\r\n" +
				      				"        AND  wd.`SunDay`=1\r\n" +
				      				"        AND sb.`SubjectCode`=se.`SubjectCode`\r\n" + 
				      				"        AND se.`SubGID`= s.`SubGID`\r\n" + 
				      				"        AND se.`SID`= l.`SID`\r\n" + 
				      				"        AND e.`EID`= l.`EID`\r\n" + 
				      				"        AND e.`EID`= we.`EID`\r\n" + 
				      				"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql2);
							
								 do{
										available al =  new available("Sunday",rs2.getString(1)+" - "+rs2.getString(2));
										
							           //data.add( new Profit(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5),rs.getDouble(6)));
										//table.getItems().add(profit);;
							       	    data.add(al);
										
							       }while(rs2.next());
							       ses_tbl.setItems(data);
						}
						else {
							System.out.println("00000000000000000000000000000000000000");
						}
						
						
						
						
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
				 }else {
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
	
	public void fillgidCombo(KeyEvent e) throws ClassNotFoundException, SQLException {
		list4.clear();
		int v = Integer.parseInt(yg.getText());
		int s1 = Integer.parseInt(semg.getText());
		String p = progg.getText();
		
		String sql = "SELECT DISTINCT  `GID` FROM student WHERE `Year` = '"+v+"' AND `Semester` = '"+s1+"' AND `Programme` = '"+p+"'";
		ResultSet rs = DbUtil.getValues(sql);
		do{
			list4.add(rs.getString(1));
	         gid.setItems(list4);
       } while(rs.next());
	}
	public void fillsubgidCombo(KeyEvent e) throws ClassNotFoundException, SQLException {
		list5.clear();
		int v = Integer.parseInt(ysg.getText());
		int s1 = Integer.parseInt(semsg.getText());
		String p = progsg.getText();
		
		String sql = "SELECT DISTINCT `SubGID` FROM student WHERE `Year` = '"+v+"' AND `Semester` = '"+s1+"' AND `Programme` = '"+p+"'";
		ResultSet rs = DbUtil.getValues(sql);
		do{
			list5.add(rs.getString(1));
	         sgid.setItems(list5);
       } while(rs.next());
	}
	
	
	
	public void fillGroup(ActionEvent e) throws ClassNotFoundException, SQLException {
		//group
		g_tbl.setItems(null);
		 ObservableList<available> data  = FXCollections.observableArrayList();
		 dg.setCellValueFactory(new PropertyValueFactory<available,String> ("Day"));
			sg.setCellValueFactory(new PropertyValueFactory<available,String> ("Not_Available_Slot"));
			
		int v = Integer.parseInt(yg.getText());
		int s1 = Integer.parseInt(semg.getText());
		String p = progg.getText();
		String g = gid.getValue();
		String day = dayf2.getValue();
		
		
		if(yg.getText().equals(null)||semg.getText().equals(null)||p.equals("")|| g.equals("")||day.equals("")) {
			
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
			
			if( v == 1 ||v == 2 ||v == 3 ||v == 4) {
				 if( s1 == 1 || s1 == 2) {
					 

						
						
				
					 if(day.equalsIgnoreCase("Monday")) {

						 String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`Monday`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Monday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
					 }
					 else if(day.equalsIgnoreCase("Tuesday")) {
						 //`TuesDay`=1
						 String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`TuesDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Tuesday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
						 
							
						}
						else if(day.equalsIgnoreCase("Wednessday")) {
							//`WednesDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`WednesDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Wednesday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
							 
						}
						else if(day.equalsIgnoreCase("Thursday")) {
							//`ThursDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`ThursDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Thursday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Friday")) {
							//`FriDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`FriDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Friday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Satureday")) {
							//`SatureDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`SatureDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("SatureDay",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
							
							
						}
						else if(day.equalsIgnoreCase("Sunday")) {
							//`SunDay`
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`GID`='"+g+"'\r\n" + 
									"        AND  wd.`SunDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Sunday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       g_tbl.setItems(data);
							
							
							
						}
						else {
							System.out.println("00000000000000000000000000000000000000");
						}
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
		}else {
			TrayNotification tray = new TrayNotification();
		 	String title = "Wrong!";
	        String message = "Please fill by correct year!";
	        //Notification notification = Notification.SUCCESS;
	        tray.setTitle(title);
	        tray.setMessage(message);
	        tray.setNotificationType(NotificationType.ERROR);
	        tray.showAndDismiss(Duration.seconds(5));}
		}
			
	}
	
	public void fillsubGroup(ActionEvent e) throws ClassNotFoundException, SQLException {
		//group
		sg_tbl.setItems(null);
		 ObservableList<available> data  = FXCollections.observableArrayList();
		 dsg.setCellValueFactory(new PropertyValueFactory<available,String> ("Day"));
			ssg.setCellValueFactory(new PropertyValueFactory<available,String> ("Not_Available_Slot"));
			
		int v = Integer.parseInt(ysg.getText());
		int s1 = Integer.parseInt(semsg.getText());
		String p = progsg.getText();
		String g = sgid.getValue();
		String day = dayf3.getValue();
		
		
		if(ysg.getText().equals(null)||semg.getText().equals(null)||p.equals("")|| g.equals("")||day.equals("")) {
			
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
			
			if( v == 1 ||v == 2 ||v == 3 ||v == 4) {
				 if( s1 == 1 || s1 == 2) {
					 

						
						
				
					 if(day.equalsIgnoreCase("Monday")) {

						 String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`Monday`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Monday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
					 }
					 else if(day.equalsIgnoreCase("Tuesday")) {
						 //`TuesDay`=1
						 String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`TuesDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Tuesday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
						 
							
						}
						else if(day.equalsIgnoreCase("Wednessday")) {
							//`WednesDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`WednesDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Wednesday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
							 
						}
						else if(day.equalsIgnoreCase("Thursday")) {
							//`ThursDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`ThursDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Thursday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Friday")) {
							//`FriDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`FriDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Friday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
							
						}
						else if(day.equalsIgnoreCase("Satureday")) {
							//`SatureDay`=1
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`SatureDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("SatureDay",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
								 sg_tbl.setItems(data);
							
							
						}
						else if(day.equalsIgnoreCase("Sunday")) {
							//`SunDay`
							String sql1 = "SELECT  DISTINCT `WorkingFrom`, `WorkingTo`\r\n" + 
									"FROM `workingemployee` we,`employee` e,`workingday&time` wd,`session` se,`student` s,`lectures` l\r\n" + 
									"WHERE  s.`Year`='"+v+"'\r\n" + 
									"        AND s.`Semester`='"+s1+"'\r\n" + 
									"        AND s.`Programme`='"+p+"'\r\n" + 
									"        AND s.`SubGID`='"+g+"'\r\n" + 
									"        AND  wd.`SunDay`=1\r\n" +
									"        AND se.`SubGID`= s.`SubGID`\r\n" + 
									"        AND se.`SID`= l.`SID`\r\n" + 
									"        AND e.`EID`= l.`EID`\r\n" + 
									"        AND e.`EID`= we.`EID`\r\n" + 
									"        AND wd.`SlotID`= we.`SlotID`";
						 
							ResultSet rs2 = DbUtil.getValues(sql1);
							
								 do{
										available al =  new available("Sunday",rs2.getString(1)+" - "+rs2.getString(2));
						
							       	    data.add(al);
										
							       }while(rs2.next());
							       sg_tbl.setItems(data);
							
							
							
						}
						else {
							System.out.println("00000000000000000000000000000000000000");
						}
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
		}else {
			TrayNotification tray = new TrayNotification();
		 	String title = "Wrong!";
	        String message = "Please fill by correct year!";
	        //Notification notification = Notification.SUCCESS;
	        tray.setTitle(title);
	        tray.setMessage(message);
	        tray.setNotificationType(NotificationType.ERROR);
	        tray.showAndDismiss(Duration.seconds(5));}
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
