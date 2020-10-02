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
//import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class parallelSessionController implements Initializable {
	
	@FXML 
	private AnchorPane painPane;
	@FXML
	private TextField semester;
	 @FXML
	private ComboBox<String> subject;
	@FXML
	private ComboBox<String>  tag;
	@FXML
	private ComboBox<String>  gid;
	@FXML
	private ComboBox<String>  sgid;
	
	@FXML
	private TextField year;
	@FXML
	private TextField prog;
	
	@FXML
	private Button addPs;
	@FXML
	public  Label day;

	@FXML
	public Label du;
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
	private ComboBox<String> location;
	@FXML
	private TextField sc;
	
	@FXML
	private ComboBox<String> con;

	 public String  sday ;
	 public String sdue ;
	public String sfrom ;
	
	public String sto ;
	private String p ;
	private Integer y, sem;
	//private String selectedType;
	//private String selectedSub;
	private Float f ,t ;
	ObservableList<String> list = FXCollections.observableArrayList("Lecture","Tutorial","Lab");
	
	   
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<String> list3 = FXCollections.observableArrayList();
    ObservableList<String> list4 = FXCollections.observableArrayList();
    ObservableList<String> list5 = FXCollections.observableArrayList();
    ObservableList<String> list6 = FXCollections.observableArrayList();
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		pane1.setTranslateX(-343);

		day.setText(Demo2Controller.val.getSday());
		du.setText(Demo2Controller.val.getSdue());
	System.out.println("00000000000000000000000000"+Demo2Controller.val.getSday());
		//pane1.setVisible(true);
	
    
	tag.setItems(list);
	
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
	    public void loadavail(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/availablity.fxml"));
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
		list3.clear();
		list4.clear();
		list5.clear();
		list6.clear();
		y = Integer.parseInt(year.getText());
		sem = Integer.parseInt(semester.getText());
		p = prog.getText();
		
		//p = prog.getText();
		 //System.out.println("---------------------------------"+p.toString());
		 
		 if( y == 1 ||y == 2 ||y == 3 ||y == 4) {
			 if( sem == 1 || sem == 2) {
		String sql1 = "SELECT DISTINCT `SubjectName`  FROM subject WHERE `OfferdYear` ='"+y+"' AND `OfferdSemester` = '"+sem+"' AND `SubjectCode` LIKE '"+p+"%'"; // 
		ResultSet rs1 = DbUtil.getValues(sql1);
		do{
			list2.add(rs1.getString(1));
	         subject.setItems(list2);
       } while(rs1.next());
		
		
		String sql2 = "SELECT DISTINCT `SubGID` FROM `student` WHERE  `Year`='"+y+"' AND `Semester`='"+sem+"' AND `Programme`='"+p+"'";
		ResultSet rs2 = DbUtil.getValues(sql2);
		do{
			list3.add(rs2.getString(1));
	         sgid.setItems(list3);
	        
	         
       } while(rs2.next());
		
		String sql4 = "SELECT DISTINCT `GID` FROM `student` WHERE  `Year`='"+y+"' AND `Semester`='"+sem+"' AND  `Programme`='"+p+"'";
		ResultSet rs4 = DbUtil.getValues(sql4);
		do{
			
	         list4.add(rs4.getString(1));
	         gid.setItems(list4);
	         
       } while(rs4.next());
		
	String sql6 = "SELECT `Room` FROM `location`";
		ResultSet rs6 = DbUtil.getValues(sql6);
		do{
			list5.add(rs6.getString(1));
	        location.setItems(list5);
	        
       } while(rs6.next());
		 
		String sql7 = "SELECT `FirstName`, `LastName` FROM `employee`";
		ResultSet rs7 = DbUtil.getValues(sql7);
		do{
			list6.add(rs7.getString(1)+" "+rs7.getString(2));
	         con.setItems(list6);
	        
       } while(rs7.next()); 
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
	
	public void addParallelSession(ActionEvent e) throws ClassNotFoundException, SQLException {
		String slotID = null;
		
		if(year.getText().equals("")||semester.getText().equals("")||prog.getText().equals("")||sgid.getValue().equals("")||sc.getText().equals("")||con.getValue().equals("")||gid.getValue().equals("")||location.getValue().equals(""))
		{
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
			
			if(Demo2Controller.val.getSid().equals(sgid.getValue())) { //checking the sub group
				 TrayNotification tray = new TrayNotification();
				 	String title = "Wrong!";
			        String message = "Can not assign a sesssion.Sub group '"+sgid.getValue()+"' already booked! ";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndDismiss(Duration.seconds(5));
			}
			else {
				int scount = Integer.parseInt(sc.getText().toString());
				String sql1 = "SELECT `SubjectCode` FROM `subject` WHERE `SubjectName` = '"+subject.getValue()+"'";
				ResultSet rs1 = DbUtil.getValues(sql1);

				String sql2 = "SELECT `LocationID` FROM `location` WHERE `Room` ='"+location.getValue()+"'";
				ResultSet rs2 = DbUtil.getValues(sql2);
				
				String day = Demo2Controller.val.getSday();
				float duration = (Demo2Controller.val.getSto()-Demo2Controller.val.getSfrom())/10000;
				float to = Demo2Controller.val.getSto();
				float from = Demo2Controller.val.getSfrom();
				
				int flag = -1;
				
				if(day.equalsIgnoreCase("monday")) {//Monday----------------------------------------
					
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("Tuesday")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("WednesDay")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("ThursDay")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("FriDay")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("SatureDay")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
				else if(day.equalsIgnoreCase("SunDay")) {
					String sql4 = "\r\n" + 
							"select *\r\n" + 
							"from `session` s,`lectures` l,`employee` e,`workingday&time` wt,`workingemployee` we\r\n" + 
							"where s.`SID` = l.`SID` AND\r\n" + 
							"      l.`EID` = e.`EID` AND\r\n" + 
							"      e.`EID` = we.`EID` AND\r\n" + 
							"      we.`SlotID` = wt.`SlotID` AND\r\n" + 
							"      s.`LocationID` = '"+rs2.getString(1)+"' AND\r\n" + 
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
					
					String sql3 ="INSERT INTO `session`(`Duration`, `StudentCount`, `LocationID`, `SubjectCode`, `SubGID`, `Type`) "
							+ "VALUES ('"+duration+"','"+scount+"','"+rs2.getString(1)+"','"+rs1.getString(1)+"','"+sgid.getValue()+"','"+tag.getValue()+"')";
					
					DbUtil.dbExecuteQuery(sql3);

					String sql5 ="SELECT `SID` FROM `session` WHERE `LocationID`='"+rs2.getString(1)+"' AND `SubjectCode`='"+rs1.getString(1)+"'  AND `SubGID` ='"+sgid.getValue()+"' AND `Type`='"+tag.getValue()+"'";
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
