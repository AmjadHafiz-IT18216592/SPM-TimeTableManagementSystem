package application;

import javafx.beans.property.SimpleStringProperty;

public class available {

	private  SimpleStringProperty Day;
	private  SimpleStringProperty Not_Available_Slot;
	
	
	
	public available(String d, String s) {
		
		Day  = new SimpleStringProperty(d);
		Not_Available_Slot =  new SimpleStringProperty(s);
		
	}

	public String getDay() {
		return Day.get();
	}
	public String getNot_Available_Slot() {
		return Not_Available_Slot.get();
	}
	
	
}
