package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class students {

	private  SimpleStringProperty SubGID;
	private  SimpleStringProperty GID;
	private  SimpleIntegerProperty SubGroupNo;
	private  SimpleIntegerProperty GroupNo;
	private  SimpleIntegerProperty Year;
	private  SimpleIntegerProperty Semester;
	private  SimpleStringProperty Programme;
	
	
	public students(String subGID, String gID, Integer subGroupNo,Integer groupNo,Integer year, Integer semester,String programme) {
		
		SubGID  = new SimpleStringProperty(subGID);
		GID =  new SimpleStringProperty(gID);
		SubGroupNo = new SimpleIntegerProperty(subGroupNo);
		GroupNo = new SimpleIntegerProperty(groupNo);
		Year = new SimpleIntegerProperty(year);
		Semester = new SimpleIntegerProperty(semester);
		Programme = new SimpleStringProperty(programme);
	}

	public String getSubGID() {
		return SubGID.get();
	}
	public String getGID() {
		return GID.get();
	}
	public Integer getSubGroupNo() {
		return SubGroupNo.get();
	}
	public Integer getGroupNo() {
		return GroupNo.get();
	}
	public Integer getYear() {
		return Year.get();
	}
	public Integer getSemester() {
		return Semester.get();
	}
	public String getProgramme() {
		return Programme.get();
	}
	
	

	
	
	
	
}
