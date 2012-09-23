package com.xebia.arquillian.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

import com.xebia.arquillian.domain.Student;

/**
 * StudentRepositoryTestCase
 */
@RunWith(Arquillian.class)
@SpringConfiguration("applicationContext.xml")
public class StudentRepositoryTestCase {

	@Autowired
	private StudentRepository studentRepository;

	@Deployment
	public static Archive createTestArchive() {

		return ShrinkWrap
				.create(JavaArchive.class, "student-repository.jar")
				.addClasses(Student.class, StudentRepository.class,
						StudentRepositoryImpl.class)
				.addAsResource("applicationContext.xml");
	}

	@Test
	public void testSave() {

		Student student1 = createStudent(1, "Balendra", "Spring", "Java", 29);
		long rollNumber1 = studentRepository.save(student1);
		assertEquals(rollNumber1, student1.getRollNumber());

	}

	@Test
	public void testGet() {

		Student student = createStudent(1, "Balendra", "Spring", "Java", 29);
		studentRepository.save(student);
		assertEquals("Balendra", studentRepository.get(1).getName());
		assertEquals("Java", studentRepository.get(1).getCourse());
		assertEquals(29, studentRepository.get(1).getAge());

	}

	@Test
	public void testUpdate() {

		Student student = createStudent(1, "Balendra", "Spring", "Java", 29);
		studentRepository.save(student);
		student.setCourse("Arquillian");
		studentRepository.update(student);
		assertEquals("Arquillian", studentRepository.get(1).getCourse());

	}

	private Student createStudent(long rollNumber, String name,
			String department, String course, int age) {

		return new Student(rollNumber, name, department, course, age);

	}

}
