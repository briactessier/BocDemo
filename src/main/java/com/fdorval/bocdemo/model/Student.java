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
	 * student grade
	 */
	Integer grade;

	/**
	 * constructeur
	 */
	Student(){	
	}
	
	/**
	 * constructeur
	 */
	public Student(String name, Integer grade) {
		super();
		this.name = name;
		this.grade = grade;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}
	
	

}
