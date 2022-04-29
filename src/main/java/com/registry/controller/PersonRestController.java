package com.registry.controller;


import com.registry.dto.ObjectsForm;
import com.registry.dto.ResponseContacts;
import com.registry.dto.ResponseDTO;
import com.registry.dto.ResponseData;
import com.registry.entity.Cv;
import com.registry.entity.Person;
import com.registry.service.PersonAnnouncementService;
import com.registry.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @Autowired
    PersonAnnouncementService personAnnouncementService;

    @GetMapping("/persons")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping("/persons/{id}")
    public ResponseDTO getPersonById(@PathVariable("id") int id){
        try{
             return  personService.getPersonById(id);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,500,"Error happened");
        }
    }

    @GetMapping("/deletePerson/{personID}")
    public ResponseDTO deletePerson(@PathVariable("personID") int personID){
        System.out.println("salam");
        return personService.deletePerson(personID);
    }

    @PostMapping("/updatePerson")
    public ResponseDTO updatePerson(@RequestBody ResponseData person){
        return personService.updatePerson(person);
    }

    @PostMapping("/addPerson")
    public ResponseDTO savePerson(@RequestBody ResponseData objectsForm){
        boolean result=personService.savePerson(objectsForm);
        if (result == true){
            return ResponseDTO.of(objectsForm,"Successfully added");
        }else {
            return ResponseDTO.of(objectsForm,404,"Error happened");
        }
    }

    @PostMapping("/addNumbers")

    public ResponseDTO saveGetContactTitles(@RequestBody ResponseContacts responseContacts){
        return personAnnouncementService.savePersonAnnouncementGetContact(responseContacts);
    }

}
