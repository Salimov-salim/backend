package com.registry.repository;

import com.registry.entity.Sources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Sources,Integer> {
}
