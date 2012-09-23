package com.xebia.arquillian.service;

import com.xebia.arquillian.domain.Student;

/**
 * Student Service for saving, updating and getting students.
 */
public interface StudentService {
	
	/**
	 * Saves the student
	 * @param student
	 * @return Student RollNumber
	 */
	long save(Student student);
	
	/**
	 * Updates the student
	 * @param student
	 */
	void update(Student student);
	
	/**
	 * Fetches student by id
	 * @param id
	 * @return Student
	 */
	Student get(long id);

}
