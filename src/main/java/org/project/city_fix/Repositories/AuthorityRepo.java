package org.project.city_fix.Repositories;

import org.project.city_fix.Models.Authority;
import org.project.city_fix.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
    @Override
    <S extends Authority> S save(S entity);

    @Override
    Optional<Authority> findById(Long id);
    Optional<Authority > findByName(String name);
    Optional<List<Authority>> findByDepartment(Department department);

}
