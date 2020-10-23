package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.dao.impl.StudentDaoImpl;
import ua.lviv.lgs.domain.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Student student = (Student) ctx.getBean("student");
		System.out.println(student);
		
		StudentDao studentDao = (StudentDaoImpl) ctx.getBean("studentDao");
		
		System.out.println("create");
		studentDao.create(student);
		studentDao.create(new Student("Ivan", 14));
		studentDao.create(new Student("Robert", 44));
		
		System.out.println("before delete");
		studentDao.readAll().forEach(System.out::println);
		
		System.out.println("delete");
		studentDao.delete(2);
		
		System.out.println("afrer delete, before update");
		studentDao.readAll().forEach(System.out::println);
		
		System.out.println("update");
		studentDao.update(new Student(3, "vasily", 42));
		
		System.out.println("afrer update");
		studentDao.readAll().forEach(System.out::println);
		
		System.out.println("read");
		System.out.println(studentDao.read(1));		
		
		System.out.println("read all");
		studentDao.readAll().forEach(System.out::println);
		
		
	}

}
