package com.capgemini.bean;

import java.time.LocalDate;

public class Student {

	public Student(int studId, String studName, LocalDate bDate) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.bDate = bDate;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	int studId;
	String studName;
	LocalDate bDate;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public LocalDate getbDate() {
		return bDate;
	}
	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}
	@Override
	public String toString() {
		return "Student => \n\tstudId=" + studId + ", \n\tstudName=" + studName
				+ ", \n\tbDate=" + bDate;
	}
	
	
	
}
