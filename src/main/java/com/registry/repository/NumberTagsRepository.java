package com.registry.repository;

import com.registry.entity.NumberTags;
import com.registry.entity.PersonAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NumberTagsRepository extends JpaRepository<NumberTags,Integer> {

//    List<NumberTags> findAllByIdpersonannouncement(Integer s);


    @Query(value="select u from NumberTags u where u.idpersonannouncement.phoneNumber like :phoneNumber")
    List<NumberTags> findAllTagsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Transactional
    void deleteByIdpersonannouncement(PersonAnnouncement id);
}
