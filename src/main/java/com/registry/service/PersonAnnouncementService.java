package com.registry.service;

import com.registry.dto.ResponseContacts;
import com.registry.dto.ResponseDTO;
import com.registry.entity.NumberTags;
import com.registry.entity.PersonAnnouncement;
import com.registry.entity.Sources;
import com.registry.repository.NumberTagsRepository;
import com.registry.repository.PersonAnnouncementRespository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PersonAnnouncementService {

    private final PersonAnnouncementRespository personAnnouncementRespository;
    private final NumberTagsRepository numberTagsRepository;

    public PersonAnnouncementService(PersonAnnouncementRespository personAnnouncementRespository, NumberTagsRepository numberTagsRepository) {
        this.personAnnouncementRespository = personAnnouncementRespository;
        this.numberTagsRepository = numberTagsRepository;
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

    public ResponseDTO savePersonAnnouncementGetContact(ResponseContacts pa){
        try {
            List<NumberTags> numberTags=numberTagsRepository.findAllTagsByPhoneNumber(pa.getPhoneNumber());
            if (numberTags.size()>0){
                if (numberTags.size() < pa.getTitles().size()){
                    PersonAnnouncement announcement=personAnnouncementRespository.findByPhoneNumber(pa.getPhoneNumber());
                    System.out.println(numberTags.get(0).getIdpersonannouncement().getId());
                    numberTagsRepository.deleteByIdpersonannouncement(numberTags.get(0).getIdpersonannouncement());

                    for (String title :
                            pa.getTitles()) {
                        NumberTags tags=new NumberTags();
                        tags.setTitle(title);
                        tags.setIdpersonannouncement(announcement);
                        tags.setInsertdate(new Timestamp(System.currentTimeMillis()));
                        numberTagsRepository.saveAndFlush(tags);
                    }
                    return ResponseDTO.of(pa,"titles list successfully updates");
                }
                return ResponseDTO.of(pa,"number available");
            }
            PersonAnnouncement personAnnouncement = new PersonAnnouncement();
            Sources sources=new Sources();
            sources.setId(1);
            personAnnouncement.setPhoneNumber(pa.getPhoneNumber());
            personAnnouncement.setIdsource(sources);
            personAnnouncement.setFullname(pa.getTitles().get(0));
            personAnnouncement.setInsertdate(new Timestamp(System.currentTimeMillis()));
            personAnnouncementRespository.saveAndFlush(personAnnouncement);
            for (String title :
                    pa.getTitles()) {
                NumberTags tags=new NumberTags();
                tags.setTitle(title);
                tags.setIdpersonannouncement(personAnnouncement);
                tags.setInsertdate(new Timestamp(System.currentTimeMillis()));
                numberTagsRepository.saveAndFlush(tags);
            }
            return ResponseDTO.of(pa,"number titles list successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

//    public ResponseDTO savePersonAnnouncementGetContact(ResponseContacts pa){
//        try {
//
//
//
//            PersonAnnouncement personAnnouncement = new PersonAnnouncement();
//            Sources sources=new Sources();
//            sources.setId(1);
//            personAnnouncement.setPhoneNumber(pa.getPhoneNumber());
//            personAnnouncement.setIdsource(sources);
//            personAnnouncement.setFullname(pa.getTitles().get(0));
//            personAnnouncement.setInsertdate(new Timestamp(System.currentTimeMillis()));
//            personAnnouncementRespository.saveAndFlush(personAnnouncement);
//            for (String title :
//                    pa.getTitles()) {
//                NumberTags tags=new NumberTags();
//                tags.setTitle(title);
//                tags.setIdpersonannouncement(personAnnouncement);
//                tags.setInsertdate(new Timestamp(System.currentTimeMillis()));
//                numberTagsRepository.saveAndFlush(tags);
//            }
//            return ResponseDTO.of(pa,"number titles list successfully added");
//        }catch (Exception e){
//            e.printStackTrace();
//            return  ResponseDTO.of(null,404,"error");
//        }
//    }


    public ResponseDTO savePersonAnnouncement(PersonAnnouncement pa){
        try {
            personAnnouncementRespository.saveAndFlush(pa);
            return ResponseDTO.of(pa,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }
}
