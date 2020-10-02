package application;



import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lecturers {
	private SimpleIntegerProperty EID;
	private SimpleStringProperty FirstName;
	private SimpleStringProperty LastName;
	private SimpleStringProperty Type;
	private SimpleStringProperty Center;
	private SimpleStringProperty Building;
	private SimpleStringProperty Faculty;
	private SimpleStringProperty Department;
	
public Lecturers(Integer eid, String fname, String lname,String type,String center, String building,String faculty,String department) {
		
		EID  = new SimpleIntegerProperty(eid);
		FirstName =  new SimpleStringProperty(fname);
		LastName = new SimpleStringProperty(lname);
		Type=new SimpleStringProperty(type);
		Center = new SimpleStringProperty(center);
		Building = new SimpleStringProperty(building);
		Faculty = new SimpleStringProperty(faculty);
		Department = new SimpleStringProperty(department);
	}

public Integer getEID() {
	return EID.get();
}

public String getFirstName() {
	return FirstName.get();
}

public String getLastName() {
	return LastName.get();
}

public String getType() {
	return Type.get();
}

public String getCenter() {
	return Center.get();
}

public String getBuilding() {
	return Building.get();
}

public String getFaculty() {
	return Faculty.get();
}

public String getDepartment() {
	return Department.get();
}

	
}

