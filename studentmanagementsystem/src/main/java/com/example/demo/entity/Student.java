package com.example.demo.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String course;

	@Column
	private int fees;

	public Student() {}

	public Student(int id, String name, String email, String course, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.fees = fees;
	}

	public Student(String name, String email, String course, int fees) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + ", fees=" + fees
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, email, fees, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(course, other.course) && Objects.equals(email, other.email) && fees == other.fees
				&& id == other.id && Objects.equals(name, other.name);
	}

	
}
