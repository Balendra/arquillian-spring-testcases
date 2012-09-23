/**
 * 
 */
package com.xebia.arquillian.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.arquillian.domain.Student;
import com.xebia.arquillian.repository.StudentRepository;

/**
 * StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@PostConstruct
	protected void init() {

		if (studentRepository == null) {

			throw new IllegalStateException(
					"Student Repository has not been initialized.Please initialize it.");
		}
	}

	@Override
	public long save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void update(Student student) {
		studentRepository.update(student);

	}

	@Override
	public Student get(long id) {
		return studentRepository.get(id);
	}

}
