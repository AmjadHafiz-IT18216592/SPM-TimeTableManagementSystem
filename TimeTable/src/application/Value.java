package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Value {

	private  SimpleStringProperty Sday;
	private  SimpleStringProperty Sdue;
	private  SimpleStringProperty Sid;
	private  SimpleStringProperty Ssub;
	private  SimpleStringProperty Stag;
	private  SimpleFloatProperty Sfrom;
	private  SimpleFloatProperty Sto;
	private  SimpleStringProperty Sloc;
	private  SimpleStringProperty Scon;
	private  SimpleIntegerProperty Ss;
	public Value(String sday,String sdue,String stag,String sid,String ssub,Float sfrom,Float sto,String sloc,String scon,Integer ss) {
		
		Sday = new SimpleStringProperty(sday);
		Sdue = new SimpleStringProperty(sdue);
		Sid = new SimpleStringProperty(sid);
		Ssub = new SimpleStringProperty(ssub);
		Stag = new SimpleStringProperty(stag);
		Sfrom = new SimpleFloatProperty(sfrom);
		Sto = new SimpleFloatProperty(sto);
		Sloc =  new SimpleStringProperty(sloc);
		Scon = new SimpleStringProperty(scon);
		Ss = new SimpleIntegerProperty(ss);
	}

	public String getScon() {
		return Scon.get();
	}


	public Integer getSs() {
		return Ss.get();
	}


	public Float getSfrom() {
		return Sfrom.get();
	}

	public String getSloc() {
		return Sloc.get();
	}
	public Float getSto() {
		return Sto.get();
	}

	

	public String getSid() {
		return Sid.get();
	}

	
	public String getSsub() {
		return Ssub.get();
	}

	public String getStag() {
		return Stag.get();
	}

	public String getSday() {
		return Sday.get();
	}

	
	public String getSdue() {
		return Sdue.get();
	}

	
}
