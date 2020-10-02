package controller;

import java.io.IOException;
import java.net.URL;
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

public class SignUPController implements Initializable {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confirmPassword;
	@FXML 
	private AnchorPane rootpane;
	
	@FXML
    public void loadLoginDirrect(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/login.fxml"));
		rootpane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML
	public void loadLoginAsAdmin(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		int val =1;
		
if(username.getText().equals("")|| password.getText().equals("")||confirmPassword.getText().equals("")) {
			
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
			
			if(password.getText().equals(confirmPassword.getText())) {
				String sqlmain ="INSERT INTO `user`(`Username`, `Password`, `us`) "
						+ "VALUES ('"+username.getText()+"','"+password.getText()+"','"+val+"')";
						
						
						DbUtil.dbExecuteQuery(sqlmain);
						
					
							
			           Stage primaryStage = new Stage();
					
							 	TrayNotification tray = new TrayNotification();
							 	String title = " Welcome!";
						        String message = "You've successfully created account as Admin";
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
				 	String title = "Wrong";
			        String message = "Passwords are not matching";
			        //Notification notification = Notification.SUCCESS;
			        tray.setTitle(title);
			        tray.setMessage(message);
			        tray.setNotificationType(NotificationType.WARNING);
			        tray.showAndDismiss(Duration.seconds(6));
			}
			
				}
				
		
			
		}
	
	
	@FXML
	public void loadLoginAsUser(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		int val = 0;
		
if(username.getText().equals("")|| password.getText().equals("")||confirmPassword.getText().equals("")) {
			
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
			if(password.getText().equals(confirmPassword.getText())) {
			String sqlmain ="INSERT INTO `user`(`Username`, `Password`, `us`) "
			+ "VALUES ('"+username.getText()+"','"+password.getText()+"','"+val+"')";
			
			
			DbUtil.dbExecuteQuery(sqlmain);
			
		
				
           Stage primaryStage = new Stage();
		
				 	TrayNotification tray = new TrayNotification();
				 	String title = " Welcome!";
			        String message = "You've successfully created account as Admin";
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
	 	String title = "Wrong";
       String message = "Passwords are not matching";
       //Notification notification = Notification.SUCCESS;
       tray.setTitle(title);
       tray.setMessage(message);
       tray.setNotificationType(NotificationType.WARNING);
       tray.showAndDismiss(Duration.seconds(6));
     }
		}
		
			
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
