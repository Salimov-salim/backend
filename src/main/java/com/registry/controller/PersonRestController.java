package com.registry.controller;


import com.registry.dto.ObjectsForm;
import com.registry.dto.ResponseDTO;
import com.registry.entity.Cv;
import com.registry.entity.Person;
import com.registry.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseDTO getAll(){
        return personService.getAll();
    }
//
//    @GetMapping("/persons/{statuscode}")
//    public ResponseDTO getAllByStatus(@PathVariable("statuscode") int statuscode){
//        return personService.getAllByStatus(statuscode);
//    }

    @GetMapping("/persons/{id}")
    public ResponseDTO getPersonById(@PathVariable("id") int id){
        try{
             return  personService.getPersonById(id);
//            return ResponseDTO.of(person,"Success");
        }catch (Exception e){
            e.printStackTrace();
//            return null;
            return  ResponseDTO.of(null,500,"Error happened");
        }
    }

    @GetMapping("/deletePerson")
    public ResponseDTO deletePerson(@RequestBody Person person){
        return personService.deletePerson(person);
    }

    @PostMapping("/updatePerson")
    public ResponseDTO updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }
//
    @PostMapping("/addPerson")
    public ResponseDTO savePerson(@RequestBody ObjectsForm objectsForm){

        boolean result=personService.savePerson(objectsForm);


        if (result == true){
            return ResponseDTO.of(objectsForm,"Successfully added");
        }else {
            return ResponseDTO.of(objectsForm,404,"Error happened");
        }
    }

    @GetMapping("/Person")
    public ResponseDTO getPersonNameAndSurname(@RequestParam(name="name",required = false) String name,
                                                  @RequestParam(name="surname",required = false) String surname)
    {
       return personService.getPersonByNameAndSurname(name,surname);
    }


    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

}
