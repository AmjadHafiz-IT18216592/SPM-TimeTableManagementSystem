package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class tag {

	private  SimpleStringProperty Code;
	private  SimpleStringProperty Subject;
	private  SimpleStringProperty Type;
	private  SimpleIntegerProperty Year;
	private  SimpleIntegerProperty Semester;

	

	public tag(String code,String subject,String ta,Integer year,Integer semester) {
		Code = new SimpleStringProperty(code);
		Subject = new SimpleStringProperty(subject);
		Type = new SimpleStringProperty(ta);
		Year = new SimpleIntegerProperty(year);
		Semester = new SimpleIntegerProperty(semester);
		
	}
	public String getCode() {
		return Code.get();
	}
	public String getSubject() {
		return Subject.get();
	}
	public String getType() {
		return Type.get();
	}
	public Integer getYear() {
		return Year.get();
	}
	public Integer getSemester() {
		return Semester.get();
	}
	
}
