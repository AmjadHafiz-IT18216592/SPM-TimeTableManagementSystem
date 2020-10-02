package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class homeController implements Initializable {

	
	@FXML
	 VBox v6,v7,v8,v9,v10,v11;
	@FXML
	 Pane p6,p7,p8,p9,p10,p11;
	@FXML 
	 VBox v3;
	@FXML
	 Pane p3;
	@FXML 
	 VBox v4;
	@FXML
	 Pane p4;
	@FXML 
	 VBox v5;
	@FXML
	 Pane p5;
	@FXML 
	private AnchorPane homepane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//p1.setTranslateX(-1310);
		
		// TranslateTransition slide = new TranslateTransition(Duration.seconds(0.5),b1);
			//slide.setToY(p1.getPrefHeight());//+(p1.getPrefWidth()b1.getLayoutY())
			// slide.play();
			
			 p3.setTranslateY(v3.getPrefHeight()-380);
			 p4.setTranslateY(v4.getPrefHeight()-380);
			 p5.setTranslateY(v5.getPrefHeight()-380);
			 p6.setTranslateY(v6.getPrefHeight()-380);
			 p7.setTranslateY(v7.getPrefHeight()-380);
			 p8.setTranslateY(v8.getPrefHeight()-380);
			 p9.setTranslateY(v9.getPrefHeight()-380);
			 p10.setTranslateY(v10.getPrefHeight()-380);
			 p11.setTranslateY(v11.getPrefHeight()-380);
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
    public void loadLocation(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/AddLoc.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML
    public void loadStat(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Demo1.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML
    public void loadsession(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/Demo2.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
/*
 * 	public void bottom(MouseEvent event) {
		 
		
		 TranslateTransition slide = new TranslateTransition(Duration.seconds(0.5),b1);
			slide.setToY(b1.getLayoutY());//(p1.getPrefWidth()
			 slide.play();
		
	}
	
	
	public void top(MouseEvent event) {
		
		 TranslateTransition slide = new TranslateTransition(Duration.seconds(0.5),b1);
			slide.setToY(p1.getPrefHeight());
			 slide.play();
			 
	}
	
 */
	
	@FXML
	public void runthree(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p3);
			slide.setToY(v3.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p3.setTranslateY(v3.getPrefHeight()-353);
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
	public void run3(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p3);
		
		slide.setToY(v3.getPrefHeight()-259);
		slide.play();
		
		p3.setTranslateY(p3.getPrefHeight());
		
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
	public void runfour(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p4);
			slide.setToY(v4.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p4.setTranslateY(v4.getPrefHeight()-353);
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
	public void run4(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p4);
		
		slide.setToY(v4.getPrefHeight()-259);
		slide.play();
		
		p4.setTranslateY(p4.getPrefHeight());
		
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
	public void runfive(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p5);
			slide.setToY(v5.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p5.setTranslateY(v5.getPrefHeight()-353);
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
	public void run5(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p5);
		
		slide.setToY(v5.getPrefHeight()-259);
		slide.play();
		
		p5.setTranslateY(p5.getPrefHeight());
		
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
	public void runsix(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p6);
			slide.setToY(v6.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p6.setTranslateY(v6.getPrefHeight()-353);
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
	public void run6(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p6);
		
		slide.setToY(v6.getPrefHeight()-259);
		slide.play();
		
		p6.setTranslateY(p6.getPrefHeight());
		
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
	public void runseven(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p7);
			slide.setToY(v7.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p7.setTranslateY(v7.getPrefHeight()-353);
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
	public void run7(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p7);
		
		slide.setToY(v7.getPrefHeight()-259);
		slide.play();
		
		p7.setTranslateY(p7.getPrefHeight());
		
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
	public void runeight(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p8);
			slide.setToY(v8.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p8.setTranslateY(v8.getPrefHeight()-353);
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
	public void run8(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p8);
		
		slide.setToY(v8.getPrefHeight()-259);
		slide.play();
		
		p8.setTranslateY(p8.getPrefHeight());
		
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
	public void runnine(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p9);
			slide.setToY(v9.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p9.setTranslateY(v9.getPrefHeight()-353);
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
	public void run9(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p9);
		
		slide.setToY(v9.getPrefHeight()-259);
		slide.play();
		
		p9.setTranslateY(p9.getPrefHeight());
		
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
	public void runten(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p10);
			slide.setToY(v10.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p10.setTranslateY(v10.getPrefHeight()-353);
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
	public void run10(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p10);
		
		slide.setToY(v10.getPrefHeight()-259);
		slide.play();
		
		p10.setTranslateY(p10.getPrefHeight());
		
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
	public void runeleven(MouseEvent event) {
		 
		 TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
			slide.setNode(p11);
			slide.setToY(v11.getPrefHeight()-380);
			//slide.setToY(v3.getLayoutY()-359);
			slide.play();
		 
			
			//p3.setTranslateY(v3.getPrefHeight()-253);
			 p11.setTranslateY(v11.getPrefHeight()-353);
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
	public void run11(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(p11);
		
		slide.setToY(v11.getPrefHeight()-259);
		slide.play();
		
		p11.setTranslateY(p11.getPrefHeight());
		
		slide.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				//pane1.setVisible(false);
				//spane.setVisible(true);
				//pane2.setVisible(true);
			}
		});
	}
public void backToLogin(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/login.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}

