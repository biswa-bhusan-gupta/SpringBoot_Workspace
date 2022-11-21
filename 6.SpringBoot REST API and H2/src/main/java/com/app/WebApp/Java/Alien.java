package com.app.WebApp.Java;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Table Name
public class Alien {
	
	@Id  // Column Name
    private int aid;
    private String aname;
    
    
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]"; // We get these values from Form Action as aid and aname and convert it into String
	}
    
	
    
}
