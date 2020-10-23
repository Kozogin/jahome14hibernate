package ua.lviv.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.domain.Student;

public class StudentDaoImpl implements StudentDao{
	private List<Student> listOfStudents = new ArrayList<>();

	@Override
	public Student create(Student t) {
		listOfStudents.add(t);
		return t;
	}

	@Override
	public Student read(Integer id) {
		Student student;
		student = listOfStudents.stream()
				.filter(s-> s.getId() == id)
				.findFirst().orElse(new Student());
		return student;
	}

	@Override
	public Student update(Student t) {		
		listOfStudents = listOfStudents.stream().peek(s->{
			if(s.getId() == t.getId()) {
				s.setStudent(t);
			}
		})
				.collect(Collectors.toList());
		return t;
	}

	@Override
	public void delete(Integer id) {
		listOfStudents = listOfStudents.stream().filter(s -> s.getId() != id)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> readAll() {		
		return listOfStudents;
	}

}
