package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Sessions;
import application.Value;
import database.DbUtil;
import javafx.animation.TranslateTransition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;

public class Demo2Controller implements Initializable{
	@FXML 
	private AnchorPane painPane;
	@FXML
	private TextField semester;
	 @FXML
	private ComboBox<String> subject;
	
	@FXML
	private ComboBox<String> tag;
	
	@FXML
	private TextField year;
	@FXML
	private ComboBox<String> gid;
	@FXML
	private ComboBox<String> sgid;
	//@FXML
	//private ComboBox<String> loc;
 
	@FXML
	private ComboBox<String> con;
	@FXML
	public TextField sc;
	@FXML
	public TextField day;
	@FXML
	public  TextField from;
	@FXML
	public  TextField to;
	@FXML
	private Button mc;
	@FXML
	private Button mp;
	@FXML
	private Pane pane1;
	@FXML
	private Pane homepane;
	@FXML
	private ComboBox<String> locationBox;
	
	
	//------------------
	@FXML
	private TextField search;
	@FXML
	private TableView<Sessions> sessions_tbl;
	@FXML
	private TableColumn<Sessions,Integer> sid_tbl;
	@FXML
	private TableColumn<Sessions,String> lec_tbl;
	@FXML
	private TableColumn<Sessions,String> sub_tbl;
	@FXML
	private TableColumn<Sessions,String> subcode_tbl;
	@FXML
	private TableColumn<Sessions,String> tag_tbl;
	@FXML
	private TableColumn<Sessions,String> gid_tbl;
	@FXML
	private TableColumn<Sessions,Integer> scount_tbl;
	@FXML
	private TableColumn<Sessions,Integer> duration_tbl;
	
	private String p ;
	
	private Integer selectedsession;
	
	@FXML
	private TextArea txtsession;
	@FXML
	private TextArea txtsession1;
	@FXML
	private TextArea txtsession2;
	@FXML
	private TextArea txtsession3;
	@FXML
	private TextArea txtsession4;
	@FXML
	private TextArea txtsession5;
	@FXML
	private TextArea txtsession6;
	
	//--------------------
	 public String  sday ;
	 public String sdue ;
	public String sfrom ;
	
	public String sto ;
	//private String p ;
	private Integer y, sem;
	private int s;
	//private String selectedSub;
	private Float f ,t ;
	private String l;
	ObservableList<String> list = FXCollections.observableArrayList("Lecture","Tutorial","Lab");
	
	   
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<String> list3 = FXCollections.observableArrayList();
    ObservableList<String> list4 = FXCollections.observableArrayList();
    ObservableList<String> list5 = FXCollections.observableArrayList();
    ObservableList<String> list6 = FXCollections.observableArrayList();
    //ObservableList<String> list6 = FXCollections.observableArrayList("A890","YU90");
    
    public String sid ,sub,location,dura,preta;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//ObservableList<String> list5 = FXCollections.observableArrayList();
		tag.setItems(list);
		
		pane1.setTranslateX(-343);
		
	   
		 
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
	
	
	public void viewSessions(ActionEvent e) throws ClassNotFoundException, SQLException {
   	 ObservableList<Sessions> data  = FXCollections.observableArrayList();
   	 System.out.println("================== a");
   	        sid_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer>("SessionID"));
			//lec_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("LecturerName"));
			//sub_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("Subject"));
			subcode_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("SubjectCode"));
			tag_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("Tag"));
			gid_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("GroupID"));
			scount_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer> ("StudentCount"));
			duration_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer> ("Duration"));
			System.out.println("================== b");
		  String sql1 ="SELECT * FROM `session`";
		 System.out.println("================== c");
	       ResultSet rs = DbUtil.getValues(sql1);
	       
	       
	       do{
				//Sessions std =  new Sessions(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
				
	    	   Sessions std =  new Sessions(rs.getInt(1),rs.getString(5),rs.getString(7),rs.getString(6),rs.getInt(3),rs.getFloat(2));
			   
	    	   System.out.println("================== d");
	       	    data.add(std);
				
	       }while(rs.next());
	        sessions_tbl.setItems(data);
	           
    }
public void getDetails() {
	 Sessions selected =sessions_tbl.getSelectionModel().getSelectedItem();
	 int index =sessions_tbl.getSelectionModel().getSelectedIndex();
	   
    System.out.println("================== "+index);
  
    selectedsession=selected.getSessionID();
   // txtsession.setText(selected.getLecturerName());
   // txtsession1.setText(selected.getSubject());
    txtsession2.setText(selected. getSubjectCode().toString());
    txtsession3.setText(selected.getTag().toString());
    txtsession4.setText(selected.getGroupID().toString());
    txtsession5.setText(selected.getStudentCount().toString());
    txtsession6.setText(selected.getDuration().toString());
	 
}

public void clearSessions(ActionEvent e) {
	
	// sessionid.setText(null);
	 locationBox.setItems(null);
	subject.setItems(null);
	 //subjectcode.setItems(null);
	 tag.setItems(null);
	 gid.setItems(null);
	 sc.setText(null);
	 from.setText(null);
	 to.setText(null);
	 year.setText(null);
	 semester.setText(null);
	 con.setItems(null);
	 sessions_tbl.setItems(null);
	 
}
	public void setfields(KeyEvent e) throws ClassNotFoundException, SQLException {
		list2.clear();
		list3.clear();
		list4.clear();
		list5.clear();
		y = Integer.parseInt(year.getText());
		sem = Integer.parseInt(semester.getText());
		
		
		//p = prog.getText();
		 //System.out.println("---------------------------------"+p.toString());
		String sql1 = "SELECT DISTINCT `SubjectName`  FROM subject WHERE `OfferdYear` ='"+y+"' AND `OfferdSemester` = '"+sem+"'"; // 
		ResultSet rs1 = DbUtil.getValues(sql1);
		do{
			list2.add(rs1.getString(1));
	         subject.setItems(list2);
       } while(rs1.next());
		
		
		String sql2 = "SELECT DISTINCT `SubGID` FROM `student` WHERE  `Year`='"+y+"' AND `Semester`='"+sem+"'";
		ResultSet rs2 = DbUtil.getValues(sql2);
		do{
			list3.add(rs2.getString(1));
	         sgid.setItems(list3);
	        
	         
       } while(rs2.next());
		
		String sql4 = "SELECT DISTINCT `GID` FROM `student` WHERE  `Year`='"+y+"' AND `Semester`='"+sem+"'";
		ResultSet rs4 = DbUtil.getValues(sql4);
		do{
			
	         list4.add(rs4.getString(1));
	         gid.setItems(list4);
	         
       } while(rs4.next());
		
	String sql6 = "SELECT `Room` FROM `location`";
		ResultSet rs6 = DbUtil.getValues(sql6);
		do{
			list5.add(rs6.getString(1));
	         locationBox.setItems(list5);
	        
       } while(rs6.next());
		String sql7 = "SELECT `FirstName`, `LastName` FROM `employee`";
		ResultSet rs7 = DbUtil.getValues(sql7);
		do{
			list6.add(rs7.getString(1)+" "+rs7.getString(2));
	         con.setItems(list6);
	        
       } while(rs7.next()); 
		  
	}
	
	public void addSessions(ActionEvent e) throws ClassNotFoundException, SQLException {
		System.out.println("================== ");
	/*
	 * 	if(eid.getText().equals("")||fname.getText().equals("")||lname.getText().equals("")||category.getText().equals("")||level.getValue()==null||center.getValue()==null||building.getValue()==null||faculty.getValue()==null||department.getValue()==null){
			System.out.println("================== ");
			TrayNotification tray = new TrayNotification();
			    String title = "Empty!";
		        String message ="Please fill the fiels and try!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.WARNING);
		        tray.showAndDismiss(Duration.seconds(5));
			}
	 */
			 
				
				 
				
				
					  
			   	ObservableList<Sessions> data  = FXCollections.observableArrayList();
			   	data.clear();
			   	sid_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer>("SessionID"));
				//lec_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("LecturersName"));
				//sub_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("Subject"));
				subcode_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("SubjectCode"));
				tag_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("Tag"));
				gid_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,String> ("GroupID"));
				scount_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer> ("StudentCount"));
				duration_tbl.setCellValueFactory(new PropertyValueFactory<Sessions,Integer> ("Duration"));
				
				ObservableList<String> list = FXCollections.observableArrayList();
				ObservableList<String> list2 = FXCollections.observableArrayList();
			    ObservableList<String> list3 = FXCollections.observableArrayList();
			    ObservableList<String> list4 = FXCollections.observableArrayList();
			    ObservableList<String> list5 = FXCollections.observableArrayList();
				
				
				   // int ssid = Integer.parseInt(sessionid.getText());
			        String name = con.getValue();
					//String lname = lecturername.getValue();
					String sub = subject.getValue();
					//String scode = subjectcode.getValue();
					String ta = tag.getValue();
					String sg = sgid.getValue();
					
					int scount = Integer.parseInt(sc.getText());
					float f = Float.parseFloat(from.getText().toString());
					float t = Float.parseFloat(to.getText().toString());
					float duration = (t-f)/10000;
					
					
					
					String sql1 = "SELECT `SubjectCode` FROM `subject` WHERE `SubjectName` = '"+subject.getValue()+"'";
					ResultSet rs1 = DbUtil.getValues(sql1);

					String sql2 = "SELECT `LocationID` FROM `location` WHERE `Room` ='"+locationBox.getValue()+"'";
					ResultSet rs2 = DbUtil.getValues(sql2);
					
				
				  //String sql1 = "INSERT INTO session(`Subject`, `SubjectCode`, `SubGID`, `Tag`, `StudentCount`, `Duration`) VALUES ('"+sub+"','"+scode+"','"+ta+"','"+gid+"','"+scount+"','"+dura+"')";
				 // DbUtil.dbExecuteQuery(sql1);
				 
			       int scounts = Integer.parseInt(sc.getText().toString());
			       
			       String sql3 ="INSERT INTO `session`(`Duration`, `StudentCount`, `LocationID`, `SubjectCode`, `SubGID`, `Type`) "
							+ "VALUES ('"+duration+"','"+scounts+"','"+rs2.getString(1)+"','"+rs1.getString(1)+"','"+sg+"','"+tag.getValue()+"')";
					
					DbUtil.dbExecuteQuery(sql3);
					
			       
					 String sql5 ="SELECT * FROM session";
				       ResultSet rs5 = DbUtil.getValues(sql5);
				       
				       /*
				        * 	public Sessions(Integer sessionID, String lecturerName, String subject,
			String subjectCode, String tag, String groupID,
			Integer studentCount, Integer duration) {
				        */    //,rs5.getString(4),rs5.getString(6),
				        
			       do {
			    	   Sessions std =  new Sessions(rs5.getInt(1),rs5.getString(5),rs5.getString(7),rs5.getString(6),rs5.getInt(3),rs5.getFloat(2));
				    data.add(std);
			       }while(rs5.next());
			       sessions_tbl.setItems(data);
			       System.out.println("================== ");
			       

/*
 *  FilteredList <Sessions> filteredData= new FilteredList <> (data, b -> true);
			       search.textProperty().addListener((observable, oldValue, newValue)->{
			       filteredData.setPredicate(session->{
			    	
			    	   if(newValue==null||newValue.isEmpty()) {
			    		return true;
			    	   }
			    	   
			    	   String lowerCaseFilter = newValue.toLowerCase();
			    	   if(session.getLecturerName().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
			    		   return true;
			    		   
			    	   }else if(session.getSubject().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
			    		   return true;
			    		   
			    	   }else if(session.getGroupID().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
			    		   return true;}
			    	   
			    		   else 
			    			   return false;
			    		   
			       });
			       SortedList<Sessions> sortedData=new SortedList<>(filteredData);
			       sortedData.comparatorProperty().bind(sessions_tbl.comparatorProperty());
			       sessions_tbl.setItems(sortedData);
			     });
 */
			       
			    		
			     		 
			    	   
			    	   
			       
			       
			       //TrayNotification tray = new TrayNotification();
			      // 
				 	//String title = "Success!";
			       // String message = "Details entered succsessfully!";
			        //Notification notification = Notification.SUCCESS;
			        //tray.setTitle(title);
			       // tray.setMessage(message);
			        //tray.setNotificationType(NotificationType.SUCCESS);
			        //tray.showAndDismiss(Duration.seconds(5));

					
				 }
	/*
	 * public void setLocations() throws ClassNotFoundException, SQLException {
		String sql6 = "SELECT `Room` FROM `location`";
		ResultSet rs6 = DbUtil.getValues(sql6);
		do{
			list5.add(rs6.getString(1));
	         loc.setItems(list5);
	        
       } while(rs6.next());
	}
	 */
	
	
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
			painPane.getChildren().setAll(pane);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	
	@FXML
     public void loadTags(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/tags.fxml"));
		painPane.getChildren().setAll(pane);
		
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
	public void loadStudent(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/student.fxml"));
		painPane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static Value val;
	String sd;
	
	public void makeParallel(ActionEvent e) throws IOException {
		
		sd = from.getText()+" : "+to.getText();
	    f = Float.parseFloat(from.getText().toString());
	    t = Float.parseFloat(to.getText().toString());
	    l = locationBox.getValue();
	    s = Integer.parseInt(sc.getText().toString());
	    
		System.out.println("----------------------------"+day.getText()+" "+sd+tag.getValue()+" "+sgid.getValue()+" "+subject.getValue());
		
		
		
		 val = new Value(day.getText(),sd, tag.getValue(),sgid.getValue(),subject.getValue(),f,t,l,con.getValue(),s);
		
		
		
 /*
  *    Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/parallelSession.fxml"));
		painPane.getChildren().setAll(pane);
		
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
  */
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_File/parallelSession.fxml"));
		Parent root = (Parent) loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		
		
	}
	
	
	public void makeConsecutive(ActionEvent e) throws IOException {
		sd = from.getText()+" : "+to.getText();
		 f = Float.parseFloat(from.getText().toString());
		    t = Float.parseFloat(to.getText().toString());
		    l = locationBox.getValue();
		    s = Integer.parseInt(sc.getText().toString());
		    
		val =new Value(day.getText(),sd, tag.getValue(),sgid.getValue(),subject.getValue(),f,t,l,con.getValue(),s);
			
				
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_File/consecutiveSession.fxml"));
		Parent root = (Parent) loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		
		
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
