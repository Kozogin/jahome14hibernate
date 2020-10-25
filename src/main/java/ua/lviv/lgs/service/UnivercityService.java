package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.domain.Univercity;

public interface UnivercityService {
	
	Univercity save (Univercity univercity);
	
	Univercity findById(Integer id);
	
	Univercity update (Univercity univercity);
	
	void deleteById(Integer id);
	
	public List<Univercity> findAll();
	
	
	Univercity findByName(String name);
	
	Univercity findByAddress(String address);
	
	List<Univercity> findByLevelOfAccreditation(Integer levelOfAccreditation);
	
	List<Univercity> findByLevelOfAccreditationLessThan(Integer levelOfAccreditation);
	
	List<Univercity> findByNumberOfInstitutes(Integer numberOfInstitutes);
	
	List<Univercity> findByNumberOfStudents(Integer numberOfStudents);
	
	List<Univercity> findByNumberOfStudentsBetween(Integer min, Integer max);
	
	List<Univercity> findByAddressIsNull();

}
