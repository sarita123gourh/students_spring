package com.db.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student{
 @Id
 @Column (name="rollNo")
 private int rollNo;
 @Column (name="name")
 private String name;
 @Column (name="batch")
 private String batch;
 @Column (name="marks")
 private int marks;
 @Column (name="joiningDate")
 private String joiningDate;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int rollNo, String name, String batch, int marks, String joiningDate) {
	super();
	this.rollNo = rollNo;
	this.name = name;
	this.batch = batch;
	this.marks = marks;
	this.joiningDate = joiningDate;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public String getJoiningDate() {
	return joiningDate;
}
public void setJoiningDate(String joiningDate) {
	this.joiningDate = joiningDate;
}
@Override
public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", batch=" + batch + ", marks=" + marks + ", joiningDate="
			+ joiningDate + "]";
}

 


}
