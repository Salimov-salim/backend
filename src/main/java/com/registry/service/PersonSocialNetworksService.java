package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.Personsocialnetworks;
import com.registry.repository.PersonSocialNetworksRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonSocialNetworksService {


    private final PersonSocialNetworksRepository personSocialNetworksRepository;
    private final SocialTypesService socialTypesService;

    public PersonSocialNetworksService(PersonSocialNetworksRepository personSocialNetworksRepository, SocialTypesService socialTypesService) {
        this.personSocialNetworksRepository = personSocialNetworksRepository;
        this.socialTypesService = socialTypesService;
    }


    public ResponseDTO getAll(){
        try {
            List<Personsocialnetworks> personsocialnetworks= personSocialNetworksRepository.findAll();
            return  ResponseDTO.of(personsocialnetworks,"success");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO deletePersonSocialNetworkByPersonId(int id){
        try {
            Personsocialnetworks personsocialnetwork=personSocialNetworksRepository.getByPersonID(id);
            personSocialNetworksRepository.delete(personsocialnetwork);
            return  ResponseDTO.of(personsocialnetwork,"successfully deleted");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO updatePersonSocialNetwork(Personsocialnetworks personsocialnetworks){
        try {
            Personsocialnetworks personsocialnetworks1=personSocialNetworksRepository.getByPersonID(personsocialnetworks.getId());
            personsocialnetworks1.setInsertdate(new Date());
            personSocialNetworksRepository.saveAndFlush(personsocialnetworks);
            return  ResponseDTO.of(personsocialnetworks1,"successfully updated");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

    public ResponseDTO savePersonSocialNetwork(Personsocialnetworks personsocialnetworks){
        try {
            personSocialNetworksRepository.saveAndFlush(personsocialnetworks);
            return ResponseDTO.of(personsocialnetworks,"successfully added");
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseDTO.of(null,404,"error");
        }
    }

}
