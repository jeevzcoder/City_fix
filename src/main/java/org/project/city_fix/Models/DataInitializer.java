package org.project.city_fix.Models;

import jakarta.annotation.PostConstruct;
import org.project.city_fix.Models.Authority;
import org.project.city_fix.Models.Department;
import org.project.city_fix.Models.User;
import org.project.city_fix.Repositories.AuthorityRepo;
import org.project.city_fix.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private AuthorityRepo authRepo;
//
//    @PostConstruct
//    public void initData() {
//        User user1 = new User(1L, "abhi", "abbc@email.com", "abhi123", null);
//        User user2 = new User(22L, "axiii", "abascas@email.com", "asdf23", null);
//
//        Authority auth1 = new Authority(2L, "Auth 1", Department.water, "auth1@email.com");
//        Authority auth2 = new Authority(22L, "Auth 2", Department.road, "auth2@email.com");
//
//        userRepo.save(user1);
//        userRepo.save(user2);
//        authRepo.save(auth1);
//        authRepo.save(auth2);
//   }
}
