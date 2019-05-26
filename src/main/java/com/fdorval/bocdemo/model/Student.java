package com.fdorval.bocdemo.model;

/**
 * bean
 * @author franc
 *
 */
public class Student {
	
	/**
	 * student name
	 */
	String name;
	

	/**
	 * student name
	 */
	String firstName;
	
	/**
	 * student grade
	 */
	Integer grade;

	/**
	 * constructeur
	 */
	Student(){	
	}

	
	public Student(String name, String firstName, int grade) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.grade = grade;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", firstName=" + firstName + ", grade=" + grade + "]";
	}
	

	
	

}
