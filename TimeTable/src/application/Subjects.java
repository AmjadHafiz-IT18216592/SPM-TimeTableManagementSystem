package application;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Subjects {
	
	private  SimpleStringProperty SubjectCode;
	private  SimpleStringProperty SubjectName ;
	private SimpleIntegerProperty LectureHours;
	private SimpleIntegerProperty TutorialHour;
	private SimpleIntegerProperty LabeHour;
	private SimpleIntegerProperty EvaluationHour;
	private  SimpleIntegerProperty OfferedYear;
	private  SimpleIntegerProperty OfferedSemester;
	
	public Subjects(String subcode, String subname,Integer noOfLeH, Integer noOfTH, Integer noOfLH,
			Integer noOfEH, Integer oyear, Integer oseme ) {
		SubjectCode  = new SimpleStringProperty(subcode);
		SubjectName =  new SimpleStringProperty(subname);
		LectureHours = new SimpleIntegerProperty(noOfLeH);
		TutorialHour = new SimpleIntegerProperty(noOfTH);
		LabeHour = new SimpleIntegerProperty(noOfLH);
		EvaluationHour = new SimpleIntegerProperty(noOfEH);
		OfferedYear  = new SimpleIntegerProperty(oyear);
		OfferedSemester  = new SimpleIntegerProperty(oseme);
		
		
	}


	public Integer getOfferedYear() {
		return OfferedYear.get();
	}

	public Integer getOfferedSemester() {
		return OfferedSemester.get();
	}

	public String getSubjectCode() {
		return SubjectCode.get();
	}

	public String getSubjectName() {
		return SubjectName.get();
	}

	public Integer getLectureHours() {
		return LectureHours.get();
	}

	public Integer getTutorialHour() {
		return TutorialHour.get();
	}

	public Integer getLabHour() {
		return LabeHour.get();
	}

	public Integer getEvaluationHour() {
		return EvaluationHour.get();
	}
	
	
}
