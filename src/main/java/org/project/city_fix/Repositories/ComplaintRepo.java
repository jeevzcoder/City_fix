package org.project.city_fix.Repositories;

import org.project.city_fix.Models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

    //void save(Complaint complaint);


    @Override
    <S extends Complaint> S save(S entity);

    @Override
    List<Complaint> findAll();

    @Override
    Optional<Complaint> findById(Long aDouble);
    //findBy
}
