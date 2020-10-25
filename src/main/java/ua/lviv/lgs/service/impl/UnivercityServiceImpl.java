package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.domain.Univercity;
import ua.lviv.lgs.repository.UnivercityRepository;
import ua.lviv.lgs.service.UnivercityService;

@Service
public class UnivercityServiceImpl implements UnivercityService{
	

	@Autowired
	private UnivercityRepository univercityRepository; 

	@Override
	public Univercity save(Univercity univercity) {
		return univercityRepository.saveAndFlush(univercity);
	}

	@Override
	public Univercity findById(Integer id) {
		return univercityRepository.getOne(id);
	}

	@Override
	public Univercity update(Univercity univercity) {
		return univercityRepository.save(univercity);
	}

	@Override
	public void deleteById(Integer id) {
		univercityRepository.deleteById(id);
	}

	@Override
	public Univercity findByName(String name) {
		return univercityRepository.findByName(name);
	}

	@Override
	public Univercity findByAddress(String address) { 
		return univercityRepository.findByAddress(address);
	}

	@Override
	public List<Univercity> findAll() {		
		return univercityRepository.findAll();
	}

	@Override
	public List<Univercity> findByLevelOfAccreditation(Integer levelOfAccreditation) {		
		return univercityRepository.findByLevelOfAccreditation(levelOfAccreditation);
	}

	@Override
	public List<Univercity> findByNumberOfInstitutes(Integer numberOfInstitutes) {
		return univercityRepository.findByNumberOfInstitutes(numberOfInstitutes);
	}

	@Override
	public List<Univercity> findByNumberOfStudents(Integer numberOfStudents) {
		return univercityRepository.findByNumberOfStudents(numberOfStudents);
	}

	@Override
	public List<Univercity> findByLevelOfAccreditationLessThan(Integer levelOfAccreditation) {
		return univercityRepository.findByLevelOfAccreditationLessThan(levelOfAccreditation);		
	}

	@Override
	public List<Univercity> findByNumberOfStudentsBetween(Integer min, Integer max) {
		return univercityRepository.findByNumberOfStudentsBetween(min, max);
	}

	@Override
	public List<Univercity> findByAddressIsNull() {
		return univercityRepository.findByAddressIsNull();
	}

}
