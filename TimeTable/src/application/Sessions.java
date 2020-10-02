package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sessions {
	private  SimpleIntegerProperty SessionID;
	private  SimpleStringProperty SubjectCode;
	private  SimpleStringProperty Tag ;
	private SimpleStringProperty GroupID;
	private SimpleIntegerProperty StudentCount;
	private SimpleFloatProperty Duration;
	
	public Sessions(Integer sessionID,
			String subjectCode, String tag, String groupID,
			Integer studentCount, Float duration) {
		super();
		SessionID = new SimpleIntegerProperty(sessionID);
		SubjectCode = new SimpleStringProperty(subjectCode);
		Tag = new SimpleStringProperty(tag);
		GroupID = new SimpleStringProperty(groupID);
		StudentCount = new SimpleIntegerProperty(studentCount);
		Duration = new SimpleFloatProperty(duration);
	}

	public Integer getSessionID() {
		return SessionID.get();
	}


	public String getSubjectCode() {
		return SubjectCode.get();
	}

	public String getTag() {
		return Tag.get();
	}

	public String getGroupID() {
		return GroupID.get();
	}

	public Integer getStudentCount() {
		return StudentCount.get();
	}

	public Float getDuration() {
		return Duration.get();
	}
	
	
	}
	
	



