/**
 * 
 */
package com.xebia.arquillian.domain;

/**
 * @author balendra
 *
 */
public class Student {
	
	private long rollNumber;
	
	private String name;
	
	private String department;
	
	private String course;
	
	private int age;
	
	public Student() {
		super();
	}

	public Student(long rollNumber, String name, String department,
			String course, int age) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.department = department;
		this.course = course;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the rollNumber
	 */
	public long getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}
}
