package com.registry.repository;

import com.registry.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience,Integer> {


    @Query(value="select u from WorkExperience u where u.idperson = :idperson")
    WorkExperience getByPersonID(@Param("idperson") Integer idperson);
}
