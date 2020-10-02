package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SubjectStatController {
	 @FXML
	    public  AnchorPane homepane;
@FXML 
LineChart <String,Number> linechart2;
	

	public void displaybtnAction(ActionEvent event) {
			linechart2.getData().clear();
			
		XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
		series.getData().add(new XYChart.Data<String,Number>("DSA", 150));
		series.getData().add(new XYChart.Data<String,Number>("PS", 155));
		series.getData().add(new XYChart.Data<String,Number>("MAD", 145));
		series.getData().add(new XYChart.Data<String,Number>("ESD", 160));
		series.getData().add(new XYChart.Data<String,Number>("Professional skills", 130));
		series.getData().add(new XYChart.Data<String,Number>("ITP", 140));
		series.setName("lecture hours per week ");
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<String,Number>();
		series1.getData().add(new XYChart.Data<String,Number>("DSA",100 ));
		series1.getData().add(new XYChart.Data<String,Number>("PS", 165));
		series1.getData().add(new XYChart.Data<String,Number>("MAD", 140));
		series1.getData().add(new XYChart.Data<String,Number>("ESD", 80));
		series1.getData().add(new XYChart.Data<String,Number>("Professional skills", 90));
		series1.getData().add(new XYChart.Data<String,Number>("ITP", 50));
		series1.setName("lab hours per week ");
		
		linechart2.getData().addAll(series);
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
