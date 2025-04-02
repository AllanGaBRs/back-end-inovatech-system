package com.allan.inovatech.dto.profile;

import com.allan.inovatech.model.entities.Adm;

import java.util.List;

public record AdmProfileDTO(
    Integer id,
    String name,
    String email,
    String profilePicture,
    List<TaskProfileDTO> tasks,
    List<FeedbackProfileDTO> feedbacks
) {
    public static AdmProfileDTO fromEntity(Adm adm){
        return new AdmProfileDTO(
                adm.getId(),
                adm.getName(),
                adm.getEmail(),
                "http://localhost:8080/adms/" + adm.getId() + "/profile-pic",
                adm.getTasks().stream().map(TaskProfileDTO::fromEntity).toList(),
                adm.getFeedbacks().stream().map(FeedbackProfileDTO::fromEntity).toList()
        );
    }
}
