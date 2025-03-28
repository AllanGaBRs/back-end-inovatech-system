package com.allan.inovatech.dto.request.get;

import com.allan.inovatech.dto.profile.ReportProfileDTO;
import com.allan.inovatech.dto.profile.StudentProfileDTO;
import com.allan.inovatech.dto.profile.SuggestionProfileDTO;
import com.allan.inovatech.dto.profile.TaskProfileDTO;
import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.enums.Course;

import java.time.LocalDate;

public record StudentGetDTO(
        Integer id,
        String ra,
        String name,
        String email,
        Course course,
        LocalDate registerDate,
        String profilePicUrl
) {
    public static StudentGetDTO fromEntity(Student student) {
        return new StudentGetDTO(
                student.getId(),
                student.getRa(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getRegisterDate(),
                //URL da foto de perfil
                "http://localhost:8080/students/" + student.getId() + "/profile-pic"
        );
    }
}
