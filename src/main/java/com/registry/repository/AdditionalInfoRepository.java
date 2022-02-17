package com.registry.repository;

import com.registry.entity.Additionalinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdditionalInfoRepository extends JpaRepository<Additionalinformation,String> {



    Additionalinformation findById(Integer integer);

    @Query(value="select u from Additionalinformation u where u.idperson = :idperson")
    Additionalinformation getByPersonID(@Param("idperson") Integer idperson);
}
