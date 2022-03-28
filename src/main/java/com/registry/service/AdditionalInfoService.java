package com.registry.service;


import com.registry.dto.ResponseDTO;
import com.registry.entity.Additionalinformation;
import com.registry.entity.Person;
import com.registry.repository.AdditionalInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalInfoService {

    private final AdditionalInfoRepository additionalInfoRepository;


    public AdditionalInfoService(AdditionalInfoRepository additionalInfoRepository) {
        this.additionalInfoRepository = additionalInfoRepository;
    }

    public ResponseDTO getAll(){
        try {
            List<Additionalinformation> additionalinformations= additionalInfoRepository.findAll();
            return  ResponseDTO.of(additionalinformations,"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public Additionalinformation getAddInfoByPersonID(Person person){
        try {

            return additionalInfoRepository.getByPersonID(person);
        }
        catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }

    public ResponseDTO getById(int id){
        try {
            return  ResponseDTO.of(additionalInfoRepository.findById(id),"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deleteAdditionalInformationByPersonId(int id){
        try {
            Additionalinformation additionalinformation=additionalInfoRepository.getByPersonID(new Person());
            additionalInfoRepository.delete(additionalinformation);
            return  ResponseDTO.of(additionalinformation,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO updateAdditionalInformation(int id,String note){
        try {
            Additionalinformation additionalinformation=additionalInfoRepository.getByPersonID(new Person());
            additionalinformation.setNote(note);
            additionalInfoRepository.saveAndFlush(additionalinformation);
            return  ResponseDTO.of(additionalinformation,"successfully updated");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO saveAdditionalInformation(Additionalinformation additionalinformation){
        try {
            additionalInfoRepository.saveAndFlush(additionalinformation);
            return ResponseDTO.of(additionalinformation,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

}
