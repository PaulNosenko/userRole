package mic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mic.entity.Role;
import mic.entity.User;
import mic.entity.UserRole;
import mic.repository.RoleDao;
import mic.repository.UserDAO;
import mic.repository.UserRoleDao;

@SpringBootApplication
public class Mic4Application implements CommandLineRunner{

	@Autowired
	UserDAO userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserRoleDao urDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Mic4Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		userDao.save(new User(null, "User1"));
		userDao.save(new User(null, "User2"));
		
		roleDao.save(new Role(null, "USER"));
		roleDao.save(new Role(null, "ADMIN"));
		
		urDao.save(new UserRole(null, userDao.findOne((long) 1), roleDao.findOne((long) 1)));
		urDao.save(new UserRole(null, userDao.findOne((long) 1), roleDao.findOne((long) 2)));
		urDao.save(new UserRole(null, userDao.findOne((long) 2), roleDao.findOne((long) 1)));
		
	}
}
