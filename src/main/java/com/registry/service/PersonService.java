package com.registry.service;

import com.registry.dto.ObjectsForm;
import com.registry.dto.ResponseDTO;
import com.registry.entity.Cv;
import com.registry.entity.Person;
import com.registry.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final WorkExperienceService workExperienceService;
    private final PersonEducationService personEducationService;
    private final PersonAnnouncementService personAnnouncementService;
    private final AdditionalInfoService additionalInfoService;
    private final CvService cvService;
    private final CvRepository cvRepository;
    private final PersonSocialNetworksService personSocialNetworksService;


    public PersonService(PersonRepository personRepository, WorkExperienceService workExperienceService, PersonEducationService personEducationService, PersonAnnouncementService personAnnouncementService, AdditionalInfoService additionalInfoService, CvService cvService, CvRepository cvRepository, PersonSocialNetworksService personSocialNetworksService) {
        this.personRepository = personRepository;
        this.workExperienceService = workExperienceService;
        this.personEducationService = personEducationService;
        this.personAnnouncementService = personAnnouncementService;
        this.additionalInfoService = additionalInfoService;
        this.cvService = cvService;
        this.cvRepository = cvRepository;
        this.personSocialNetworksService = personSocialNetworksService;
    }

    public List<Person> getAll(){
        try {
            return personRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return null;
        }

    }

    public ResponseDTO getAllByStatus(int status){
        return  ResponseDTO.of(personRepository.findByStatus(status));
    }

    public ResponseDTO getPersonById(int id){
        return  ResponseDTO.of(personRepository.findById(id));
    }

    public ResponseDTO getPersonByNameAndSurname(String name, String surname){
        try {
            Person person=personRepository.findByNameAndSurname(name,surname);
            return ResponseDTO.of(person);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.of(null,404,"Error happened");
        }

    }

    public boolean savePerson(ObjectsForm objectsForm){
        try {
            Cv cv=cvRepository.save(objectsForm.getCv());
            objectsForm.getPerson().setIdcv(cv);
            Person person=personRepository.save(objectsForm.getPerson());
            objectsForm.getPersonsocialnetworks().setIdperson(person);
            personSocialNetworksService.savePersonSocialNetwork(objectsForm.getPersonsocialnetworks());
            objectsForm.getAdditionalinformation().setIdperson(person);
            additionalInfoService.saveAdditionalInformation(objectsForm.getAdditionalinformation());
            objectsForm.getPersonsocialnetworks().setIdperson(person);
            personSocialNetworksService.savePersonSocialNetwork(objectsForm.getPersonsocialnetworks());
            objectsForm.getPersonEducation().setIdperson(person);
            personEducationService.savePersonEducation(objectsForm.getPersonEducation());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ResponseDTO updatePerson(Person personDTO) {
        try {
            Person person= personRepository.findById(personDTO.getId());
            person.setName(personDTO.getName());
            person.setSurname(personDTO.getSurname());
            person.setFathername(personDTO.getFathername());
            person.setMilitarystate(personDTO.getMilitarystate());
            Cv c=new Cv();
            c.setId(personDTO.getIdcv().getId());
            person.setIdcv(c);
            person.setStatus(personDTO.getStatus());
            person.setBlockstatus(personDTO.getBlockstatus());
            person.setFin(personDTO.getFin());
            personRepository.saveAndFlush(person);
            return ResponseDTO.of(personDTO,"successfully updated");
        }catch (Exception e) {
            return ResponseDTO.of(null,404,"error happened");
        }
    }

    public ResponseDTO deletePerson(Person personDTO){
        try {
            Person person= personRepository.findById(personDTO.getId());
            personRepository.delete(person);
            return ResponseDTO.of(personDTO,"Successfully deleted");
        }catch (Exception e){
            return  ResponseDTO.of(personDTO,404,"Error happened");
        }
    }

}
