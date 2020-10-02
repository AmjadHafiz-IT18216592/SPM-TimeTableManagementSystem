package controller;

import java.io.IOException;
import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import database.DbUtil;
import javafx.animation.TranslateTransition;
//import connection.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

//import util.connectionClass;

public class AddLocController implements Initializable{
	
    @FXML
    public TextField bName;
    @FXML
    public  AnchorPane homepane;
    @FXML
    public  Pane pane1;
    @FXML
    public TextField Room;
    
    @FXML
    public ComboBox<String> combobox;
    
    @FXML
    public  TextField location_id;
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
	
    
 // inserting locations method
    public static void insertBuildings(String bname,String room, String category)throws ClassNotFoundException,SQLException  {
   
    	String sql = "INSERT INTO `location`(`Room`, `Building`, `category`) VALUES ('" +bname +"','" +room +"','" + category+"')"; 
    	
    	try {
    		DbUtil.dbExecuteQuery(sql);
    		
    	}catch(SQLException e) {
    		System.out.println("Exception occurred while inserting data");
    		e.printStackTrace();
    		throw e;
    	}
    }
   
    //selecting values from the table
   /* @FXML
    private void location_tblMouseClicked(ActionEvent evt) {                                      
        int r = location_tbl.getSelectedRow();
        
        String bname = location_tbl.getValueAt(r, 0).toString();
        String room = location_tbl.getValueAt(r, 1).toString();
        String category = location_tbl.getValueAt(r, 2).toString();
        
        
        bName.setText(bname);
        Room.setText(room);
        combobox.setValue(category);
      
    } */
    
 // updating locations method
    public static void updateBuildings(String bname,String room, String category)throws ClassNotFoundException,SQLException  {
    	
    	String sql = "UPDATE `location` SET `Room` = '" +room +"', `category`= '" + category+"' WHERE `Building` = '" +bname +"' ";
    	
    	try {
    		DbUtil.dbExecuteQuery(sql);
    		
    	}catch(SQLException e) {
    		System.out.println("Exception occurred while updating the record");
    		e.printStackTrace();
    		throw e;}
    }
    
    
  
    
 // calling insert method into the button event
    @FXML
	private void addBuildings(ActionEvent evt) throws ClassNotFoundException,SQLException {
		if(!((bName.equals("")) || (Room.equals("")) || (combobox.equals("")))) {
			
			insertBuildings(bName.getText(), Room.getText(),combobox.getValue()); 
		}     
		
    	else{
             JOptionPane.showInputDialog(this, "Required areas cannot be empty!!");
        }
        
	
}
 // calling update method into the button event
    @FXML
     private void updateB(ActionEvent evt) throws ClassNotFoundException,SQLException {
    	
    	try {
    		updateBuildings(bName.getText(), Room.getText(),combobox.getValue());
    		
    		}catch(SQLException e) {
    			System.out.println("Error occured while updating the data"+e);
    			e.printStackTrace();
        		throw e;
    		}
    		
    	
}

 //delete button event with operations
    @FXML
     private void deleteteB(ActionEvent evt) throws ClassNotFoundException,SQLException {
    	
    	
   	 if(!(bName.getText().equals(""))){
            int d =1;// JOptionPane.showInternalConfirmDialog(this,"Do you really want to delete?","Delete record",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

            if(d == 0){
           	 String id = location_id.getText();

                String del = "DELETE from `location` WHERE `LocationID` = '"+ id +"'";
                try {
                   
                    //tableload();
                    bName.setText("");
                    Room.setText("");
                    combobox.setValue("");
                          
                } catch (Exception e) {

                }
            }
            else{
           	 	bName.setText("");
                Room.setText("");
                combobox.setValue("");
            }
        }
        else{
            JOptionPane.showInputDialog(this, "Please select a record you want to delete!");
        }
    	
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
    public void loadMan(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml_File/ManageLocations.fxml"));
		homepane.getChildren().setAll(pane);
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    ObservableList<String> list = FXCollections.observableArrayList("Lecture Hall","Laboratory","Other");
	
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox.setItems(list);
		pane1.setTranslateX(-343);
		
	}



	
}



