package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void create(User user) {
		userRepository.save(user);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
