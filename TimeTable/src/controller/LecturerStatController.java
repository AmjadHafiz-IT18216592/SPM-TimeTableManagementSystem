package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LecturerStatController implements Initializable{

	 @FXML
	    public  AnchorPane homepane;
	@FXML LineChart <String,Number> linechart;
	
	
	public void displaybtnAction(ActionEvent event) {
			linechart.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
		series.getData().add(new XYChart.Data<String,Number>("Mr.P.Fernando", 150));
		series.getData().add(new XYChart.Data<String,Number>("Ms. I.V. Edirisinghe", 155));
		series.getData().add(new XYChart.Data<String,Number>("Dr. S. Jayasinghe", 145));
		series.getData().add(new XYChart.Data<String,Number>("Mr. R.Wijesinghe", 160));
		series.getData().add(new XYChart.Data<String,Number>("Prof.S. Senevirathne", 130));
		series.getData().add(new XYChart.Data<String,Number>("Ms. M. Silva", 140));
		series.setName("Monthly lecture hours");
		
		linechart.getData().add(series);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}

