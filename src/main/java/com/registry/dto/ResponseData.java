package com.registry.dto;

import com.registry.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private Person person;
    private PersonEducation personEducation;
    private PersonEducation personEducation2;
    private WorkExperience workExperience;
    private WorkExperience workExperience2;
    private Personsocialnetworks personsocialnetworks;
    private Personsocialnetworks personsocialnetworks2;
    private Cv cv;
    private Additionalinformation additionalinformation;
}
