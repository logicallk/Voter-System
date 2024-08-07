package com.VotingSystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Election {
	@Id
	private int eid;
	private String etype;
	private LocalDate estartdate;
	public Election(int eid, String etype, LocalDate estartdate) {
		super();
		this.eid = eid;
		this.etype = etype;
		this.estartdate = estartdate;
	}
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public LocalDate getEstartdate() {
		return estartdate;
	}
	public void setEstartdate(LocalDate estartdate) {
		this.estartdate = estartdate;
	}
	@Override
	public String toString() {
		return "Election [eid=" + eid + ", etype=" + etype + ", estartdate=" + estartdate + "]";
	}
	
	
	

}
