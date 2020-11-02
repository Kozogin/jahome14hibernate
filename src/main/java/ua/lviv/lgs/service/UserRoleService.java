package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.repository.UserRolesRepository;

@Service
public class UserRoleService {
	
	@Autowired
	UserRolesRepository userRolesRepository;
	
	@Transactional
	public void create(UserRole userRole) {
		userRolesRepository.save(userRole);
	}

}
