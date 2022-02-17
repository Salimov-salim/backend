package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.PersonAnnouncement;
import com.registry.repository.PersonAnnouncementRespository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonAnnouncementService {

    private final PersonAnnouncementRespository personAnnouncementRespository;

    public PersonAnnouncementService(PersonAnnouncementRespository personAnnouncementRespository) {
        this.personAnnouncementRespository = personAnnouncementRespository;
    }

    public ResponseDTO getAll(){
        try {
            List<PersonAnnouncement> personAnnouncements= personAnnouncementRespository.findAll();
            return  ResponseDTO.of(personAnnouncements,"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO getById(int id){
        try {
//            return  personAnnouncementRespository.findById(id);
            return  ResponseDTO.of(personAnnouncementRespository.findById(id),"success");
        }catch (Exception e){
            e.printStackTrace();
//            return null;
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO getByPhoneNumber(String phoneNumber){
        try {
            return  ResponseDTO.of(personAnnouncementRespository.getByPhoneNumber(phoneNumber),"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO getByFullname(String fullname){
        try {
            return  ResponseDTO.of(personAnnouncementRespository.getByFullname(fullname),"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deletePersonAnnouncement(PersonAnnouncement personAnnouncement){
        try {
            personAnnouncementRespository.delete(personAnnouncement);
            return  ResponseDTO.of(personAnnouncement,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO updatePersonAnnouncement(PersonAnnouncement personAnnouncement){
        try {
            PersonAnnouncement pa=personAnnouncementRespository.findById(personAnnouncement.getId());
            pa.setFullname(personAnnouncement.getFullname());
            pa.setPhoneNumber(personAnnouncement.getPhoneNumber());
            pa.setIdsource(personAnnouncement.getIdsource());
            pa.setInsertdate(personAnnouncement.getInsertdate());
            personAnnouncementRespository.saveAndFlush(pa);
            return  ResponseDTO.of(personAnnouncement,"successfully updated");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO savePersonAnnouncement(PersonAnnouncement pa){
        try {
            personAnnouncementRespository.save(pa);
            return ResponseDTO.of(pa,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }
}
