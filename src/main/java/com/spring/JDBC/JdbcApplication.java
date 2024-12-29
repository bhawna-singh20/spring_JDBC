package com.spring.JDBC;

import com.spring.JDBC.model.Student;
import com.spring.JDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbcApplication.class);
		Student std= context.getBean(Student.class);
		std.setName("Anshi");
		std.setRollNO(12);
		std.setMarks(80);

		StudentService service= context.getBean(StudentService.class);
		service.addService(std);

		List<Student> students= service.getStudent();
		System.out.println(students);
	}

}
