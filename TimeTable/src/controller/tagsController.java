package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import application.tag;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;



public class tagsController implements Initializable {
	
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
	private ComboBox<String> tagbox;
	@FXML
	private ComboBox<String> sub;
	
	
	@FXML
	private TableView<tag> tags_tbl;
	@FXML
	private TableColumn<tag,String> code_tbl;
	@FXML
	private TableColumn<tag,Integer> year_tbl;
	@FXML
	private TableColumn<tag,Integer> sem_tbl;
	
	@FXML
	private TableColumn<tag,String> sub_tbl;
	@FXML
	private TableColumn<tag,String> tag_tbl;
	
	private String p ;
	private Integer y, sem;
	private String selectedType;
	private String selectedSub;
	ObservableList<String> list = FXCollections.observableArrayList("Lecture","Tutorial","Lab");
	
   
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<String> list3 = FXCollections.observableArrayList();
    ObservableList<String> list4 = FXCollections.observableArrayList();
	@FXML
	private TextField prog;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tagbox.setItems(list);
		
		pane1.setTranslateX(-343);
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
	
	
	public void setfields(KeyEvent e) throws ClassNotFoundException, SQLException {
		list2.clear();
		y = Integer.parseInt(year.getText());
		sem = Integer.parseInt(semester.getText());
		
		
		p = prog.getText();
		 //System.out.println("---------------------------------"+p.toString());
		String sql1 = "SELECT DISTINCT `SubjectName`  FROM subject WHERE `OfferdYear` ='"+y+"' AND `OfferdSemester` = '"+sem+"'  AND `SubjectCode` LIKE '"+p+"%'"; // 
		ResultSet rs1 = DbUtil.getValues(sql1);
		do{
			list2.add(rs1.getString(1));
	         sub.setItems(list2);
       } while(rs1.next());
		
		
	}
	


	public void viewAllTags(ActionEvent e) throws ClassNotFoundException, SQLException {
		
   	 ObservableList<tag> data  = FXCollections.observableArrayList();
   	    code_tbl.setCellValueFactory(new PropertyValueFactory<tag,String>("Code"));
		sub_tbl.setCellValueFactory(new PropertyValueFactory<tag,String> ("Subject"));
		tag_tbl.setCellValueFactory(new PropertyValueFactory<tag,String> ("Type"));
		year_tbl.setCellValueFactory(new PropertyValueFactory<tag,Integer> ("Year"));
		sem_tbl.setCellValueFactory(new PropertyValueFactory<tag,Integer> ("Semester"));
		
		
		
		
		  String sql1 =	"SELECT s.`SubjectCode`,s.`SubjectName`,t.`Type`,s.`OfferdYear`, s.`OfferdSemester`  FROM  tag t,subject s WHERE  t.`SubjectCode` = s.`SubjectCode`";
	       

	       ResultSet rs = DbUtil.getValues(sql1);
	       
	       
	       do{ tag  tagChild = new tag(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			  
	       	    data.add(tagChild);
				
	       }while(rs.next());
	        tags_tbl.setItems(data);
	           
    }
	 
	
	public void addTags(ActionEvent e) throws ClassNotFoundException, SQLException {
		 if(year.getText().equals("") || semester.getText().equals("") || prog.getText().equals("")||sub.getValue() == null || year.getText().equals(null) ||semester.getText().equals(null) || tagbox.getValue() == null  ){
				
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
					 int s1 = Integer.parseInt(semester.getText());
					 if( s1 == 1 || s1 == 2) {
				 y = Integer.parseInt(year.getText());
					sem = Integer.parseInt(semester.getText());
					p = prog.getText();
					
					  TrayNotification tray = new TrayNotification();
					 	String title = "Success!";
				        String message = "Details entered succsessfully!";
				        //Notification notification = Notification.SUCCESS;
				        tray.setTitle(title);
				        tray.setMessage(message);
				        tray.setNotificationType(NotificationType.SUCCESS);
				        tray.showAndDismiss(Duration.seconds(5));
			   	 ObservableList<tag> data  = FXCollections.observableArrayList();
			   	    code_tbl.setCellValueFactory(new PropertyValueFactory<tag,String>("Code"));
					sub_tbl.setCellValueFactory(new PropertyValueFactory<tag,String> ("Subject"));
					tag_tbl.setCellValueFactory(new PropertyValueFactory<tag,String> ("Type"));
					year_tbl.setCellValueFactory(new PropertyValueFactory<tag,Integer> ("Year"));
					sem_tbl.setCellValueFactory(new PropertyValueFactory<tag,Integer> ("Semester"));
					
					String t = tagbox.getValue();
					String s = sub.getValue();
					String sql = "SELECT `SubjectCode` FROM `subject` WHERE  `SubjectName` = '"+s+"'";
					ResultSet rs1 = DbUtil.getValues(sql);
					

					String sql2 = "INSERT INTO tag (`Type`, `SubjectCode`) VALUES ('"+t+"','"+rs1.getString(1)+"')";
					DbUtil.dbExecuteQuery(sql2);
					String sc = rs1.getString(1);
					
					  String sql1 = "SELECT s.`SubjectCode`,s.`SubjectName` ,t.`Type`,s.`OfferdYear`, s.`OfferdSemester` FROM  tag t,subject s WHERE s.`OfferdYear` ='"+y+"' AND s.`OfferdSemester` ='"+sem+"' AND t. `SubjectCode` = s.`SubjectCode` AND s.`SubjectCode` = '"+sc+"'";
				       ResultSet rs = DbUtil.getValues(sql1);
						

					  tag  tagChild = new tag(rs.getString(1),rs.getString(2),t,rs.getInt(4),rs.getInt(5));
					  
			   	    data.add(tagChild);
			   	 tags_tbl.setItems(data);
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
		 prog.setText(null);
		 sub.setItems(null);
		 tags_tbl.setItems(null);
		 
	 }
	 public void getDetails(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
		 
		  //Bill selected = table.getSelectionModel().getSelectedItem();
		  tag selected = tags_tbl.getSelectionModel().getSelectedItem();
		  if(selected == null) {
			 /*
			  *  TrayNotification tray = new TrayNotification();
			 	String title = "Row isn't selected!";
		        String message = "Please select a row in table.";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.ERROR);
		        tray.showAndDismiss(Duration.seconds(4));
		
			  */
		  }
		  else {
			   int index = tags_tbl.getSelectionModel().getSelectedIndex();
				 //String sql = "SELECT * FROM `item` WHERE CategoryName = '"+selected.getItem()+"' AND BrandName = '"+selected.getBrand()+"'";
				 //ResultSet rs = DbUtil.getValues(sql);
			     //String  itemID = rs.getString(1);
				 year.setText(selected.getYear().toString());
				 semester.setText(selected.getSemester().toString());
				   sub.setValue(selected.getSubject());
				   selectedSub = selected.getSubject();
				   
				   selectedType = selected.getType();
				   tagbox.setValue(selected.getType());
					String sql = "SELECT `SubjectCode` FROM `subject` WHERE  `SubjectName` = '"+selectedSub+"'";
					ResultSet rs1 = DbUtil.getValues(sql);
					String sc = rs1.getString(1);
					
				   if(sc.matches("(.*)IT(.*)")) {
					   prog.setText("IT");
				   }
				   else if(sc.matches("(.*)BM(.*)")){
					   prog.setText("BM");
				   }
				   else
					   prog.setText(" ");
				   
				 
			       
				  /*
				   * qn = selected.getQuantity();
				 tx.setText(itemID);
				 cb3.setValue(qn);
				setItemID(itemID);
				setIndex(index);
				   */
			   System.out.println("================== "+index);
		  }
		
		
	  }
	 public void editDetails(ActionEvent e) throws ClassNotFoundException, SQLException {
		   
		   if(year.getText().equals("") || semester.getText().equals("") || prog.getText().equals("")||sub.getValue() == null || year.getText().equals(null) ||semester.getText().equals(null) || tagbox.getValue() == null  ){
			   
			   TrayNotification tray = new TrayNotification();
			 	String title = "Unable to edit!";
		        String message = "Please select a row to get details.";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.WARNING);
		        tray.showAndDismiss(Duration.seconds(4));
			   
		   }
		   else {
			   TrayNotification tray = new TrayNotification();
			 	String title = "Success!";
		        String message = "Details are updated succsessfully!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.SUCCESS);
		        tray.showAndDismiss(Duration.seconds(5));
			  
			    String t = tagbox.getValue();
				String s = sub.getValue();
				
				String sql = "SELECT `SubjectCode` FROM `subject` WHERE  `SubjectName` = '"+s+"'";
				ResultSet rs1 = DbUtil.getValues(sql);
				String sc = rs1.getString(1);
				
				String sql2 = "UPDATE tag SET `Type`='"+t+"' WHERE `SubjectCode`= '"+sc+"' AND `Type`='"+selectedType+"'";
				DbUtil.dbExecuteQuery(sql2);	
				
				//tags_tbl.setItems(null);
				viewAllTags(e);
		   }
		}
	 
	 public void deleteDetails(ActionEvent e) throws ClassNotFoundException, SQLException {
		   
		   if(sub.getValue() == null || year.getText().equals(null) ||semester.getText().equals(null) || tagbox.getValue() == null){
			   
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
			   TrayNotification tray = new TrayNotification();
			 	String title = "Success!";
		        String message = "Details are deleted succsessfully!";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.SUCCESS);
		        tray.showAndDismiss(Duration.seconds(5));
			  
				String s = sub.getValue();
				  System.out.println("================== "+s);
				String sql = "SELECT `SubjectCode` FROM `subject` WHERE  `SubjectName` = '"+s+"'";
				ResultSet rs1 = DbUtil.getValues(sql);
				String sc = rs1.getString(1);
				
				String sql2 = "DELETE FROM tag  WHERE `SubjectCode`= '"+sc+"' AND `Type`='"+selectedType+"'";
				DbUtil.dbExecuteQuery(sql2);	
				
				//tags_tbl.setItems(null);
				viewAllTags(e);
		   }
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
