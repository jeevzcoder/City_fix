package org.project.city_fix;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.project.city_fix.Models.Authority;
import org.project.city_fix.Models.Department;
import org.project.city_fix.Models.User;
import org.project.city_fix.Repositories.AuthorityRepo;
import org.project.city_fix.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityFixApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AuthorityRepo authRepo;

	//@Test
	//@Transactional
	public void saveUsers() {
		User user1 = new User(1L, "abhi", "abbc@email.com", "abhi123", null);
		User user2 = new User(22L, "axiii", "abascas@email.com", "asdf23", null);

		Authority auth1 = new Authority(2L, "Auth 1", Department.water, "auth1@email.com");
		Authority auth2 = new Authority(22L, "Auth 2", Department.road, "auth2@email.com");

//		userRepo.save(user1);
//		userRepo.save(user2);
//		authRepo.save(auth1);
//		authRepo.save(auth2);
	}
}