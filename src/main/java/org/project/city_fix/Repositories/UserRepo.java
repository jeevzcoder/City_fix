package org.project.city_fix.Repositories;

import org.project.city_fix.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);
}
