/**
 * 
 */
package com.xebia.arquillian.service;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.xebia.arquillian.domain.Student;
import com.xebia.arquillian.repository.StudentRepository;
import com.xebia.arquillian.repository.StudentRepositoryImpl;

/**
 * StudentServiceTestCase
 */
@RunWith(Arquillian.class)
@SpringConfiguration("applicationContext.xml")
public class StudentServiceTestCase {

	@Autowired
	private StudentService studentService;

	@Deployment
	public static Archive createTestArchive() {

		return ShrinkWrap
				.create(JavaArchive.class, "student-service.jar")
				.addClasses(Student.class, StudentService.class,
						StudentServiceImpl.class, StudentRepository.class,
						StudentRepositoryImpl.class)
				.addAsResource("applicationContext.xml");
	}

	@Test
	public void testSave() {

		Student student1 = createStudent(1, "Balendra", "Spring", "Java", 29);
		Student student2 = createStudent(2, "John", "Arquillian", "Java", 29);

		long rollNumber1 = studentService.save(student1);
		long rollNumber2 = studentService.save(student2);

		assertEquals(rollNumber1, student1.getRollNumber());
		assertEquals(rollNumber2, student2.getRollNumber());

	}

	@Test
	public void testGet() {

		Student student = createStudent(1, "Balendra", "Spring", "Java", 29);
		studentService.save(student);
		assertEquals("Balendra", studentService.get(1).getName());
		assertEquals("Java", studentService.get(1).getCourse());
		assertEquals(29, studentService.get(1).getAge());

	}

	@Test
	public void testUpdate() {

		Student student = createStudent(1, "Balendra", "Spring", "Java", 29);
		studentService.save(student);
		student.setCourse("Arquillian");
		studentService.update(student);
		assertEquals("Arquillian", studentService.get(1).getCourse());

	}

	private Student createStudent(long rollNumber, String name,
			String department, String course, int age) {

		return new Student(rollNumber, name, department, course, age);

	}

}
