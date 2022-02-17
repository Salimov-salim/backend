package com.registry.repository;

import com.registry.entity.Personsocialnetworks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonSocialNetworksRepository extends JpaRepository<Personsocialnetworks,Integer> {

    @Query(value="select u from Personsocialnetworks u where u.idperson = :idperson")
    Personsocialnetworks getByPersonID(@Param("idperson") Integer idperson);
}
