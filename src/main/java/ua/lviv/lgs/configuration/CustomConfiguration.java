package ua.lviv.lgs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.impl.StudentDaoImpl;
import ua.lviv.lgs.domain.Student;

@Configuration
public class CustomConfiguration {
	
	@Bean(name="student")
	public Student getStudent() {
		Student student = new Student();
		student.setName("Ray");
		student.setAge(18);	
		return student;
	}
	
	@Bean(name="studentDao")
	public StudentDaoImpl getStudentDao() {				
		return new StudentDaoImpl();
	}
	
	
	

}
