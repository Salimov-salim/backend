package com.registry.repository;

import com.registry.entity.Socialtypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialTypesRepository extends JpaRepository<Socialtypes,String> {

    Socialtypes findById(Integer s);
}
