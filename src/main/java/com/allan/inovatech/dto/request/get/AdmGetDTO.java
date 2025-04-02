package com.allan.inovatech.dto.request.get;

import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.model.entities.Student;

public record AdmGetDTO(
        Integer id,
        String name,
        String email,
        String profilePicUrl
) {
    public static AdmGetDTO fromEntity(Adm adm){
        return new AdmGetDTO(
                adm.getId(),
                adm.getName(),
                adm.getEmail(),
                "http://localhost:8080/adms/" + adm.getId() + "/profile-pic"
        );
    }
}
