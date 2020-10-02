package controller;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ManageLocationsController {

	
	    @FXML
	    public  Pane pane1;
	 @FXML
	    public  AnchorPane homepane;
	 
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
		public void loadAvailRoom(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/RoomsAvailability.fxml"));
			homepane.getChildren().setAll(pane);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	 @FXML
		public void loadpref(ActionEvent e) throws IOException {
			
			Stage primaryStage = new Stage();
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/PrefferedLocations.fxml"));
			homepane.getChildren().setAll(pane);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
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
	
    
}
