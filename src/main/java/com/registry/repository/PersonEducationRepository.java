package com.registry.repository;

import com.registry.entity.PersonEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonEducationRepository extends JpaRepository<PersonEducation,Integer> {

    @Query(value="select u from PersonEducation u where u.idperson = :idperson")
    PersonEducation getByPersonID(@Param("idperson") Integer idperson);
}
