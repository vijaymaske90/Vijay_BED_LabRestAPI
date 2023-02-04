package com.gl.lab6.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int studId;
	public String studFirstName;
	public String studLastName;
	public String studDept;
	public String studCountry;
	
	public Student() {
		
	}
	
	public Student(String studFirstName,String studLastName, String studDept, String studCountry) {
		super();
		this.studFirstName = studFirstName;
		this.studLastName = studLastName;
		this.studDept = studDept;
		this.studCountry = studCountry;
	}
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studFirstName=" + studFirstName + ", studLastName=" + studLastName
				+ ", studDept=" + studDept + ", studCountry=" + studCountry + "]";
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudFirstName() {
		return studFirstName;
	}

	public void setStudFirstName(String studFirstName) {
		this.studFirstName = studFirstName;
	}

	public String getStudLastName() {
		return studLastName;
	}

	public void setStudLastName(String studLastName) {
		this.studLastName = studLastName;
	}

	public String getStudDept() {
		return studDept;
	}

	public void setStudDept(String studDept) {
		this.studDept = studDept;
	}

	public String getStudCountry() {
		return studCountry;
	}

	public void setStudCountry(String studCountry) {
		this.studCountry = studCountry;
	}

	public Student(Student student) {
		super();
		this.studFirstName=student.studFirstName;
		this.studLastName=student.studLastName;
		this.studDept=student.studDept;
		this.studCountry=student.studCountry;
	}
}
