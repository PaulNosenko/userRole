package mic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mic.entity.Role;
import mic.entity.User;
import mic.entity.UserRole;
import mic.repository.RoleDao;
import mic.repository.UserDAO;
import mic.repository.UserRoleDao;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	UserDAO userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	UserRoleDao urDao;
	
	@RequestMapping("/roles")
	public List<Role> roles(){
		return roleDao.findAll();
	}
	
	@RequestMapping("/userRoles")
	public List<UserRole> userRoles(){
		return urDao.findAll();
	}
	
	@RequestMapping("/userRoles/{id}")
	public List<UserRole> userRoleOfUser(@PathVariable long id){
		return urDao.findByUserId(id);
	}
	
	@RequestMapping("/users")
	public List<User> findUsers(){
		return userDao.findAll();
	}
	
	@RequestMapping("/isAdmin/{id}")
	public String isAdmin(@PathVariable long id) {
		for (UserRole userRolev : urDao.findByUserId(id)) {
			if(userRolev.getRole().getName().equals("ADMIN")) {
				return "Yes, IS ADMIN";
			}
		}
		return "No IS not an Admin";
	}
	
	@RequestMapping(value = "/rolesOfUser/{id}")
	public List<UserRole> userRoles(@PathVariable long id){
		return urDao.findByUserId(id);
	}
	
}
