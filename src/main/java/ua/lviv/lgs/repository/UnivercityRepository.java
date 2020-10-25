package ua.lviv.lgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Univercity;

public interface UnivercityRepository extends JpaRepository<Univercity, Integer>{
	
	Univercity findByName(String name);
	
	Univercity findByAddress(String address);
	
	List<Univercity> findByLevelOfAccreditation(Integer levelOfAccreditation);
	
	List<Univercity> findByLevelOfAccreditationLessThan(Integer levelOfAccreditation);
	
	List<Univercity> findByNumberOfInstitutes(Integer numberOfInstitutes);
	
	List<Univercity> findByNumberOfStudents(Integer numberOfStudents);
	
	List<Univercity> findByNumberOfStudentsBetween(Integer min, Integer max);
	
	List<Univercity> findByAddressIsNull();
	

}
