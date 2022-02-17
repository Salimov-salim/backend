package com.registry.service;

import com.registry.entity.Universities;
import com.registry.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    public UniversityRepository universityRepository;

    public List<Universities> getAll(){
        return universityRepository.findAll();
    }

    public Universities getUniversityByID(int id){
        return universityRepository.findById(id);
    }
}
