package ua.lviv.lgs.domain;

public class Student {
	
	private static int autoIncrement;
	
	private int id;
	private String name;
	private int age;
	
	public Student() {
		autoIncrement++;
		id = autoIncrement;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		autoIncrement++;
		id = autoIncrement;
	}
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}	
	
	public void setStudent(Student student) {
		this.name = student.getName();
		this.age = student.getAge();
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
