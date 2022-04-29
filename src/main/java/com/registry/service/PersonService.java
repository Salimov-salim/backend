package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.dto.ResponseData;
import com.registry.entity.*;
import com.registry.repository.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final WorkExperienceService workExperienceService;
    private final PersonEducationService personEducationService;
    private final AdditionalInfoService additionalInfoService;
    private final PersonAnnouncementService personAnnouncementService;
    private final CvRepository cvRepository;
    private final PersonSocialNetworksService personSocialNetworksService;


    public PersonService(PersonRepository personRepository, WorkExperienceService workExperienceService, PersonEducationService personEducationService, AdditionalInfoService additionalInfoService, PersonAnnouncementService personAnnouncementService, CvRepository cvRepository, PersonSocialNetworksService personSocialNetworksService) {
        this.personRepository = personRepository;
        this.workExperienceService = workExperienceService;
        this.personEducationService = personEducationService;
        this.additionalInfoService = additionalInfoService;
        this.personAnnouncementService = personAnnouncementService;
        this.cvRepository = cvRepository;
        this.personSocialNetworksService = personSocialNetworksService;
    }

    public List<Person> getAll(){
        try {
            return personRepository.findActives(1);
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

    public boolean savePerson(ResponseData objectsForm){
        try {
            if (objectsForm.getCv() !=null && objectsForm.getCv().getContent()!=null){
                objectsForm.getCv().setInsertdate(new Timestamp(System.currentTimeMillis()));
                Cv cv=cvRepository.saveAndFlush(objectsForm.getCv());
                objectsForm.getPerson().setIdcv(cv);
            }
            objectsForm.getPerson().setIsactive(1);
            objectsForm.getPerson().setInsertdate(new Timestamp(System.currentTimeMillis()));
            objectsForm.getPerson().setStatus(Boolean.TRUE);
            Person person=personRepository.saveAndFlush(objectsForm.getPerson());

            if(objectsForm.getPersonsocialnetworks()!=null && objectsForm.getPersonsocialnetworks().getName()!=null)  {
                objectsForm.getPersonsocialnetworks().setInsertdate(new Timestamp(System.currentTimeMillis()));
                objectsForm.getPersonsocialnetworks().setIdperson(person);
                personSocialNetworksService.savePersonSocialNetwork(objectsForm.getPersonsocialnetworks());
            }
            if(objectsForm.getPersonsocialnetworks2()!=null && objectsForm.getPersonsocialnetworks2().getName()!=null) {
                objectsForm.getPersonsocialnetworks2().setInsertdate(new Timestamp(System.currentTimeMillis()));
                objectsForm.getPersonsocialnetworks2().setIdperson(person);
                personSocialNetworksService.savePersonSocialNetwork(objectsForm.getPersonsocialnetworks2());
            }
            if(objectsForm.getAdditionalinformation()!=null && objectsForm.getAdditionalinformation().getNote()!=null){
                objectsForm.getAdditionalinformation().setInsertdate(new Timestamp(System.currentTimeMillis()));
                objectsForm.getAdditionalinformation().setIdperson(person);
                additionalInfoService.saveAdditionalInformation(objectsForm.getAdditionalinformation());
            }
            if(objectsForm.getWorkExperience()!=null && objectsForm.getWorkExperience().getWorkplace()!=null) {
                objectsForm.getWorkExperience().setInsertdate(new Timestamp(System.currentTimeMillis()));
                objectsForm.getWorkExperience().setIdperson(person);
                workExperienceService.savePersonWorkExperience(objectsForm.getWorkExperience());
            }
            if(objectsForm.getWorkExperience2()!=null && objectsForm.getWorkExperience2().getWorkplace()!=null) {
                objectsForm.getWorkExperience2().setInsertdate(new Timestamp(System.currentTimeMillis()));
                objectsForm.getWorkExperience2().setIdperson(person);
                workExperienceService.savePersonWorkExperience(objectsForm.getWorkExperience2());
            }
            if(objectsForm.getPersonEducation()!=null && objectsForm.getPersonEducation().getIdeducationtype()!=null) {
                objectsForm.getPersonEducation().setIdperson(person);
                personEducationService.savePersonEducation(objectsForm.getPersonEducation());
            }
            if(objectsForm.getPersonEducation2()!=null && objectsForm.getPersonEducation2().getIdeducationtype()!=null) {
                objectsForm.getPersonEducation2().setIdperson(person);
                personEducationService.savePersonEducation(objectsForm.getPersonEducation2());
            }
            if(objectsForm.getPerson()!=null && objectsForm.getPerson().getPhonenumber()!=null) {
                objectsForm.getPersonEducation2().setIdperson(person);
                PersonAnnouncement personAnnouncement=new PersonAnnouncement();
                Sources sources=new Sources();
                sources.setId(1);
                personAnnouncement.setIdsource(sources);
                personAnnouncement.setFullname(objectsForm.getPerson().getName()+objectsForm.getPerson().getSurname()+objectsForm.getPerson().getFathername());
                personAnnouncement.setPhoneNumber(objectsForm.getPerson().getPhonenumber());
                personAnnouncement.setPersonId(person);
                personAnnouncement.setInsertdate(new Timestamp(System.currentTimeMillis()));
                personAnnouncementService.savePersonAnnouncement(personAnnouncement);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ResponseDTO updatePerson(ResponseData personDTO) {
        try {
            Person oldPerson= personRepository.findById(personDTO.getPerson().getId());
            oldPerson.setName(personDTO.getPerson().getName());
            oldPerson.setSurname(personDTO.getPerson().getSurname());
            oldPerson.setFathername(personDTO.getPerson().getFathername());
            oldPerson.setMilitarystate(personDTO.getPerson().getMilitarystate());
            oldPerson.setStatus(personDTO.getPerson().getStatus());
            oldPerson.setBlockstatus(personDTO.getPerson().getBlockstatus());
            oldPerson.setEmail(personDTO.getPerson().getEmail());
            System.out.println(personDTO.getPerson().getId());
            Additionalinformation oldInfo= additionalInfoService.getAddInfoByPersonID(personDTO.getPerson());
            if(personDTO.getAdditionalinformation().getNote()!=null) {
                oldInfo.setNote(personDTO.getAdditionalinformation().getNote());
                additionalInfoService.saveAdditionalInformation(oldInfo);
            }
            personRepository.saveAndFlush(oldPerson);
            return ResponseDTO.of(personDTO,"successfully updated");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.of(personDTO,404,"error happened when updating person information!");
        }
    }

    public ResponseDTO deletePerson(int personDTO){
        try {
            System.out.println("person deleted");
            Person person= personRepository.findById(personDTO);
            person.setIsactive(0);
            personRepository.saveAndFlush(person);
            return ResponseDTO.of(personDTO,"Successfully deleted");
        }catch (Exception e){
            return  ResponseDTO.of(personDTO,404,"Error happened");
        }
    }


}
