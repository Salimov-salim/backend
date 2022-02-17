package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.WorkExperience;
import com.registry.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkExperienceService {

    private final WorkExperienceRepository workExperienceRepository;
    public WorkExperienceService(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    public ResponseDTO getAll(){
        try {
            List<WorkExperience> workExperiences= workExperienceRepository.findAll();
            return  ResponseDTO.of(workExperiences,"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO getById(int id){
        try {
            return  ResponseDTO.of(workExperienceRepository.findById(id),"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deleteWorkExperienceByPersonId(int id){
        try {
            WorkExperience workExperience=workExperienceRepository.getByPersonID(id);
            workExperienceRepository.delete(workExperience);
            return  ResponseDTO.of(workExperience,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO updatePersonEducation(WorkExperience experience){
        try {
            WorkExperience workExperience=workExperienceRepository.getByPersonID(experience.getId());
            workExperience.setPosition(experience.getPosition());
            workExperience.setWorkplace(experience.getWorkplace());
            workExperience.setStatus(experience.getStatus());
            workExperience.setStartdate(experience.getStartdate());
            workExperience.setEnddate(experience.getEnddate());
            workExperience.setInsertdate(new Date());
            workExperience.setIdperson(experience.getIdperson());

            workExperienceRepository.saveAndFlush(workExperience);
            return  ResponseDTO.of(workExperience,"successfully updated");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO savePersonEducation(WorkExperience workExperience){
        try {
            workExperienceRepository.save(workExperience);
            return ResponseDTO.of(workExperience,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }
}
