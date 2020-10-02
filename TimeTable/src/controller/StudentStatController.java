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

public class StudentStatController {
	
	@FXML 
	LineChart <String,Number> linechart1;
	
	@FXML
    public  AnchorPane homepane;
	
	public void displaybtnAction(ActionEvent event) {
			linechart1.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
		series.getData().add(new XYChart.Data<String,Number>("Mr.P.Fernando", 150));
		series.getData().add(new XYChart.Data<String,Number>("Ms. I.V. Edirisinghe", 155));
		series.getData().add(new XYChart.Data<String,Number>("Dr. S. Jayasinghe", 145));
		series.getData().add(new XYChart.Data<String,Number>("Mr. R.Wijesinghe", 160));
		series.getData().add(new XYChart.Data<String,Number>("Prof.S. Senevirathne", 130));
		series.getData().add(new XYChart.Data<String,Number>("Ms. M. Silva", 140));
		series.setName("Monthly student count");
		
		linechart1.getData().add(series);
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