package com.registry.repository;

import com.registry.entity.Universities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<Universities,String> {

   Universities findById(Integer integer);
}
