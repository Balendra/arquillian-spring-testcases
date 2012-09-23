package com.xebia.arquillian.repository;

import com.xebia.arquillian.domain.Student;

/**
 * Student Repository for saving, updating and getting students.
 *
 */
public interface StudentRepository {
	
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
