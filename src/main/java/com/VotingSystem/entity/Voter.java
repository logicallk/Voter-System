package com.VotingSystem.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {
	@Id
	
	private int vid;
	@NotBlank(message = "Name can not be blank")
	@Size(min = 4,max = 10,message = "Name should be 4 or 10 character")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "Only character is allow in name")
	private String votername;
	private LocalDate DOB;
	private String gender;

	private String username;
	private String password;
	private String district;
	public Voter(int vid,
			@NotBlank(message = "Name can not be blank") @Size(min = 4, max = 10, message = "Name should be 4 or 10 character") @Pattern(regexp = "^[a-zA-Z]+$", message = "Only character is allow in name") String votername,
			LocalDate dOB, String gender, String username, String password, String district) {
		super();
		this.vid = vid;
		this.votername = votername;
		DOB = dOB;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.district = district;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVotername() {
		return votername;
	}
	public void setVotername(String votername) {
		this.votername = votername;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "Voter [vid=" + vid + ", votername=" + votername + ", DOB=" + DOB + ", gender=" + gender + ", username="
				+ username + ", password=" + password + ", District=" + district + "]";
	}
	
	
	
}
