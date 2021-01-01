package com.cg.student.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="student_seq",allocationSize=1)
	@NotNull(message="Id is required")
	@Column(name="id")
	private int studentId;

	@NotNull(message="field is required")
	@Size(min=3,max=15,message="Invalid! Please provide valid name")
	@Column(name="firstname",length=15)
	private String firstName;
	
	@NotNull(message="field is required")
	@Size(min=3,max=15,message="Invalid! Please provide valid name")
	@Column(name="lastname",length=15)
	private String lastName;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Column(name="dob",columnDefinition="TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@NotNull(message="field is required")
	@Size(min=3,max=15,message="Invalid! Please provide valid name")
	@Column(name="gender",length=15)
	private String gender;
	
	@NotNull(message="field is required")
	@Size(min=10,max=10,message="Invalid! Please provide valid number")
	@Column(name="phonenumber",length=10)
	private String phoneNumber;
	
	@NotNull(message="field is required")
	@Size(min=3,max=30,message="Invalid! Please provide valid email")
	@Email
	@Column(name="email",length=30)
	private String email;
	
	@NotNull(message="field is required")
	@Size(min=3,max=35,message="Invalid! Please provide valid address")
	@Column(name="address",length=35)
	private String address;
	
	@NotNull(message="field is required")
	@Size(min=3,max=20,message="Invalid! Please provide valid city name")
	@Column(name="city",length=20)
	private String city;
	
	@NotNull(message="field is required")
	@Size(min=3,max=30,message="Invalid! Please provide valid department")
	@Column(name="department",length=30)
	private String department;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
