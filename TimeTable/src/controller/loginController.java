package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



import database.DbUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
;

public class loginController implements Initializable {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	@FXML 
	private AnchorPane rootpane;
	@FXML
	public void loadHomeAsUser(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		
if(username.getText().equals("")|| password.getText().equals("")) {
			
			 TrayNotification tray = new TrayNotification();
		 	String title = "Fields are empty!";
	        String message = "Please fill the fields correctly";
	        //Notification notification = Notification.SUCCESS;
	        tray.setTitle(title);
	        tray.setMessage(message);
	        tray.setNotificationType(NotificationType.WARNING);
	        tray.showAndDismiss(Duration.seconds(6));
			 
		}
		else {
			
			String sqlmain = "SELECT * FROM user WHERE `Username`='"+username.getText()+"' AND `Password`='"+password.getText()+"'";
			ResultSet rs1 = DbUtil.getValues(sqlmain);
			
			
			
			if(rs1.getRow() == 0) {
				
			 	TrayNotification tray = new TrayNotification();
			 	String title = "Wrong!";
		        String message = "Please enter your username or password correctly";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.ERROR);
		        tray.showAndDismiss(Duration.seconds(5));
			}
			else {
				if(rs1.getInt(3) ==0 ) {
				 	
           Stage primaryStage = new Stage();
		
				 	TrayNotification tray = new TrayNotification();
				 	String title = " Welcome!";
			        String message = "You've successfully Login as Admin";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.SUCCESS);
			        tray.showAndDismiss(Duration.seconds(6));
			        
					
					AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/home.fxml"));
					rootpane.getChildren().setAll(pane);
					
					Scene scene = new Scene(pane);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				}
				else {
					TrayNotification tray = new TrayNotification();
				 	String title = " Wrong!";
			        String message = "You're unable login as normal user";
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
	public void loadHomeAsAdmin(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
	
		
if(username.getText().equals("")|| password.getText().equals("")) {
			
			 TrayNotification tray = new TrayNotification();
		 	String title = "Fields are empty!";
	        String message = "Please fill the fields correctly";
	        //Notification notification = Notification.SUCCESS;
	        tray.setTitle(title);
	        tray.setMessage(message);
	        tray.setNotificationType(NotificationType.WARNING);
	        tray.showAndDismiss(Duration.seconds(6));
			 
		}
		else {
			
			String sqlmain = "SELECT * FROM user WHERE `Username`='"+username.getText()+"' AND `Password`='"+password.getText()+"'";
			ResultSet rs1 = DbUtil.getValues(sqlmain);
			
			
			
			if(rs1.getRow() == 0) {
				
			 	TrayNotification tray = new TrayNotification();
			 	String title = "Wrong!";
		        String message = "Please enter your username or password correctly";
		        //Notification notification = Notification.SUCCESS;
		        tray.setTitle(title);
		        tray.setMessage(message);
		        tray.setNotificationType(NotificationType.ERROR);
		        tray.showAndDismiss(Duration.seconds(5));
			}
			else {
				if(rs1.getInt(3) ==1 ) {
				 	
           Stage primaryStage = new Stage();
		
				 	TrayNotification tray = new TrayNotification();
				 	String title = " Welcome!";
			        String message = "You've successfully Login as Admin";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.SUCCESS);
			        tray.showAndDismiss(Duration.seconds(6));
			        
			        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/home.fxml"));
			    	javafx.application.Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							rootpane.getChildren().setAll(pane);
							
							Scene scene = new Scene(rootpane);
							//Scene scene = rootpane.getScene();
							
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.show();
						}
					});
					
					
				}
				else {
					TrayNotification tray = new TrayNotification();
				 	String title = " Wrong";
			        String message = "You're unable to log as admin";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndDismiss(Duration.seconds(6));
			        
				}
		
			}
		}
	}
	public void loadSignUP(ActionEvent e) throws IOException {
		   Stage primaryStage = new Stage();
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/SignUP.fxml"));
		rootpane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
