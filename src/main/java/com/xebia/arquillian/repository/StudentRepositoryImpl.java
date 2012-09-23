/**
 * 
 */
package com.xebia.arquillian.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xebia.arquillian.domain.Student;

/**
 * StudentRepositoryImpl
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final Map<Long, Student> studentDir = new HashMap<Long, Student>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xebia.arquillian.repository.StudentRepository#save(com.xebia.arquillian
	 * .domain.Student)
	 */
	@Override
	public long save(Student student) {
		if (student != null) {
			long rollNumber = student.getRollNumber();
			if (rollNumber != 0L) {
				studentDir.put(rollNumber, student);
				return rollNumber;
			}
		}
		return 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xebia.arquillian.repository.StudentRepository#update(com.xebia.arquillian
	 * .domain.Student)
	 */
	@Override
	public void update(Student student) {
		if (student != null) {
			long rollNumber = student.getRollNumber();
			if (rollNumber != 0L) {
				studentDir.put(rollNumber, student);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xebia.arquillian.repository.StudentRepository#get(long)
	 */
	@Override
	public Student get(long id) {
		// TODO Auto-generated method stub
		return studentDir.get(id);
	}

}
