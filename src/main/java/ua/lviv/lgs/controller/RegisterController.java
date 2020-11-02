package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.UserRoleService;
import ua.lviv.lgs.service.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(HttpServletRequest request) {			
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {			
		return "home";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String s403(HttpServletRequest request) {			
		return "403";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {			
		return "login";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {			
		return "hello";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {			
		return "register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		System.out.println("********-------------****************--------------");
				
		User user = new User();
		
		user.setUserName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		
		String password = request.getParameter("password");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);		
		
		user.setPassword(hashedPassword);
		user.setEnabled(1);
		
		userService.create(user);
		
		UserRole userRole = new UserRole();
		
		userRole.setRole("ROLE_USER");	
		
		userRole.setUserid(userService.findByUserName(user.getUserName()).getUserId());
		userRoleService.create(userRole);
		
		System.out.println("user id " + userService.findByUserName(user.getUserName()).getUserId());
		
		return "login";
	}

}
