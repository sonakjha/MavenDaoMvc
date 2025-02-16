package com.training.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student 
{
	private long id;
	private String name;
	private long mobileNo;
	private char gender;
	private float gradPerc;
	private double salary;
	private boolean isMember;
	private LocalDate dob;
	private LocalDateTime joining;
	
	public Student() {
	}
	public Student(long id, String name, long mobileNo, char gender, float gradPerc, double salary, boolean isMember,
			LocalDate dob, LocalDateTime joining) {
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.gradPerc = gradPerc;
		this.salary = salary;
		this.isMember = isMember;
		this.dob = dob;
		this.joining = joining;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public float getGradPerc() {
		return gradPerc;
	}
	public void setGradPerc(float gradPerc) {
		this.gradPerc = gradPerc;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isMember() {
		return isMember;
	}
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getJoining() {
		return joining;
	}
	public void setJoining(LocalDateTime joining) {
		this.joining = joining;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", gender=" + gender + ", gradPerc="
				+ gradPerc + ", salary=" + salary + ", isMember=" + isMember + ", dob=" + dob + ", joining=" + joining
				+ "]";
	}
}
