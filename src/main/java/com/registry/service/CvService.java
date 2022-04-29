package com.registry.service;

import com.registry.dto.ResponseDTO;
import com.registry.entity.Cv;
import com.registry.repository.CvRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.stream.Stream;

@Service
public class CvService {

    private final CvRepository cvRepository;

    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public Cv getFile(Integer id) {
        return cvRepository.findById(id).get();
    }

}
