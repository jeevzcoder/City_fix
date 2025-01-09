package org.project.city_fix;

import org.project.city_fix.Models.Department;
import org.project.city_fix.Models.User;
import org.project.city_fix.Repositories.AuthorityRepo;
import org.project.city_fix.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplaintController {
    //@Autowired
    UserRepo userRepo;
    //@Autowired
    AuthorityRepo authRepo;
    User user1 = new User(1L,"abhi","abbc@email.com","abhi123",null);
    User user2 = new User(2L,"axiii","abascas@email.com","asdf23",null);
    User savedUser = userRepo.save(user1);
    User u2=userRepo.save(user2);
    //Department department = new Department(1L,"IT",null);

	//userRepo.save(user1);
	//userRepo.save(user2);


}
