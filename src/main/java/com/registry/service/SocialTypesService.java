package com.registry.service;

import com.registry.entity.Socialtypes;
import com.registry.repository.SocialTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialTypesService {

    private final SocialTypesRepository socialTypesRepository;

    public SocialTypesService(SocialTypesRepository socialTypesRepository) {
        this.socialTypesRepository = socialTypesRepository;
    }


    public List<Socialtypes> getAll(){
        try {
            return  socialTypesRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Socialtypes getByID(int id){
        try {
            return  socialTypesRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
