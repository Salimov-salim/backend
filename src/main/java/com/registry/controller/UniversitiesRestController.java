package com.registry.controller;

import com.registry.entity.Person;
import com.registry.entity.Socialtypes;
import com.registry.entity.Universities;
import com.registry.service.SocialTypesService;
import com.registry.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversitiesRestController {
    @Autowired
    public UniversityService universityService;

    @Autowired
    public SocialTypesService socialTypesService;

    @GetMapping("/universities")
    public List<Universities> getAll(){
        return universityService.getAll();
    }


    @GetMapping("/socialPages")
    public List<Socialtypes> getAllSocialPages(){
        return socialTypesService.getAll();
    }
}
