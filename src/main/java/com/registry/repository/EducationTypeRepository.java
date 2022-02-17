package com.registry.repository;

import com.registry.entity.Educationtype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationTypeRepository extends JpaRepository<Educationtype,String> {


    Educationtype findById(Integer integer);
}
