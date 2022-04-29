package com.registry.repository;

import com.registry.entity.PersonAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonAnnouncementRespository extends JpaRepository<PersonAnnouncement,String> {


    PersonAnnouncement findById(Integer s);

    PersonAnnouncement findByPhoneNumber(String s);

    @Query(value="select u from PersonAnnouncement u where u.phoneNumber like :phoneNumber")
    PersonAnnouncement getByPhoneNumber(@Param("phoneNumber") String phoneNumber);


    @Query(value="select u from PersonAnnouncement u where u.fullname like :fullname")
    PersonAnnouncement getByFullname(@Param("fullname") String fullname);
}
