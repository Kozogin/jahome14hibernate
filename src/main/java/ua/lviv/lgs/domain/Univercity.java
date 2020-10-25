package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Univercity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column(name="level_of_accreditation")
	private int levelOfAccreditation;
	
	@Column(name="number_of_institutes")
	private int numberOfInstitutes;
	
	@Column(name="number_of_students")
	private int numberOfStudents;
	
	@Column
	private String address;
	
	public Univercity() {}

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

	public int getLevelOfAccreditation() {
		return levelOfAccreditation;
	}

	public void setLevelOfAccreditation(int levelOfAccreditation) {
		this.levelOfAccreditation = levelOfAccreditation;
	}

	public int getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(int numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Univercity [id=" + id + ", name=" + name + ", levelOfAccreditation=" + levelOfAccreditation
				+ ", numberOfInstitutes=" + numberOfInstitutes + ", numberOfStudents=" + numberOfStudents + ", address="
				+ address + "]";
	}

}

