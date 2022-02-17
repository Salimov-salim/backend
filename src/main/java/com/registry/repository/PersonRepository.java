package com.registry.repository;

import com.registry.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {

    Person findById(Integer id);

    @Query(value="select u from Person u where u.name like :name and u.surname like :surname")
    Person findByNameAndSurname(@Param("name") String name,
                                @Param("surname") String surname);

    @Query(value="select u from Person u where u.status like :status")
    List<Person> findByStatus(@Param("status") int status);
}
