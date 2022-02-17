package com.registry.dto;


import com.registry.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectsForm {
    private Person person;
    private PersonEducation personEducation;
    private WorkExperience workExperience;
    private Additionalinformation additionalinformation;
    private Personsocialnetworks personsocialnetworks;
    private Cv cv;
    private PersonAnnouncement personAnnouncement;

}
