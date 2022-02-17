package com.registry.service;


import com.registry.entity.Educationtype;
import com.registry.repository.EducationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationTypesService {

    private final EducationTypeRepository educationTypeRepository;


    public EducationTypesService(EducationTypeRepository educationTypeRepository) {
        this.educationTypeRepository = educationTypeRepository;
    }

    public List<Educationtype> getAll(){
        try {
            return educationTypeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Educationtype getByID(int id){
        try {
            return educationTypeRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
