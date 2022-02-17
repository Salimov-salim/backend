package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.PersonEducation;
import com.registry.repository.PersonEducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonEducationService {

    private final PersonEducationRepository personEducationRepository;
    private final EducationTypesService educationTypesService;

    public PersonEducationService(PersonEducationRepository personEducationRepository, EducationTypesService educationTypesService) {
        this.personEducationRepository = personEducationRepository;
        this.educationTypesService = educationTypesService;
    }

    public ResponseDTO getAll(){
        try {
            List<PersonEducation> personEducations= personEducationRepository.findAll();
            return  ResponseDTO.of(personEducations,"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO getById(int id){
        try {
            return  ResponseDTO.of(personEducationRepository.findById(id),"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deletePersonEducationByPersonId(int id){
        try {
            PersonEducation personEducation=personEducationRepository.getByPersonID(id);
            personEducationRepository.delete(personEducation);
            return  ResponseDTO.of(personEducation,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO updatePersonEducation(PersonEducation pe){
        try {
            PersonEducation personEducation=personEducationRepository.getByPersonID(pe.getId());
            personEducation.setIdperson(pe.getIdperson());
            personEducation.setIduniversity(pe.getIduniversity());
            personEducation.setIdeducationtype(pe.getIdeducationtype());
            personEducation.setEnddate(pe.getEnddate());
            personEducation.setStartdate(pe.getStartdate());
            personEducationRepository.saveAndFlush(personEducation);
            return  ResponseDTO.of(personEducation,"successfully updated");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO savePersonEducation(PersonEducation personEducation){
        try {
            personEducationRepository.save(personEducation);
            return ResponseDTO.of(personEducation,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

}
