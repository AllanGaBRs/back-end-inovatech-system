package com.allan.inovatech.dto.profile;

import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.enums.Course;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO para representar o perfil de um estudante.
 * Inclui suas tarefas, sugestões e relatórios.
 */
public record StudentProfileDTO(

        Integer id,
        String name,
        String email,
        Course course,
        LocalDate registerDate,
        String profilePicUrl,
        List<TaskProfileDTO> tasks,
        List<SuggestionProfileDTO> suggestions,
        List<ReportProfileDTO> reports


) {
    /**
     * Converte uma entidade Student para um DTO.
     * @param student Entidade Student do banco de dados.
     * @return StudentProfileDTO contendo os dados do estudante.
     */
    public static StudentProfileDTO fromEntity(Student student) {
        return new StudentProfileDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getRegisterDate(),
                //URL da foto de perfil
                "http://localhost:8080/students/" + student.getId() + "/profile-pic",
                student.getTasks().stream().map(TaskProfileDTO::fromEntity).toList(),
                student.getSuggestions().stream().map(SuggestionProfileDTO::fromEntity).toList(),
                student.getReports().stream().map(ReportProfileDTO::fromEntity).toList()
        );
    }
}
