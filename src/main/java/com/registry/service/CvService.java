package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.Cv;
import com.registry.repository.CvRepository;
import org.springframework.stereotype.Service;

@Service
public class CvService {

    private final CvRepository cvRepository;

    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public ResponseDTO getAllCV(){
        try{
            return ResponseDTO.of(cvRepository.findAll(),"success");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.of(null,404,"error");
        }
    }

    public  ResponseDTO getCvById(int id){
        try{
            return  ResponseDTO.of(cvRepository.findById(id),"success");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO saveCV(Cv cv){
        try {
            cvRepository.save(cv);
            return ResponseDTO.of(cv,"successfully saved");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deleteCV(Cv cv){
        try {
            cvRepository.delete(cv);
            return ResponseDTO.of(cv,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.of(null,404,"error");
        }
    }
}
