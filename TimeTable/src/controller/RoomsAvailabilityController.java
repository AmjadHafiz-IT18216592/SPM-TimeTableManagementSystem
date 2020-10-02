package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RoomsAvailabilityController implements Initializable {
	@FXML
	private AnchorPane homepane;
	@FXML
	private Pane pane1;
	//@FXML
	//private Pane homepane;
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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

		

	
}
