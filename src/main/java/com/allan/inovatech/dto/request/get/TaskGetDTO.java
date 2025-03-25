package com.allan.inovatech.dto.request.get;

import com.allan.inovatech.dto.profile.TaskProfileDTO;
import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.entities.TaskKanban;
import com.allan.inovatech.model.enums.TaskStatus;

import java.time.LocalDate;

public record TaskGetDTO(
        Integer id,
        String title,
        String taskDescription,
        TaskStatus sts,
        LocalDate beginDate,
        LocalDate endDate,
        String admName,
        String studentName
) {
    public static TaskGetDTO fromEntity(TaskKanban task) {
        if(task.getStudent() == null){
            Student student = new Student();
            student.setName("");
            task.setStudent(student);
        }
        return new TaskGetDTO(
                task.getId(),
                task.getTitle(),
                task.getTaskDescription(),
                task.getSts(),
                task.getBeginDate(),
                task.getEndDate(),
                task.getAdm().getName(),
                task.getStudent().getName()
        );
    }
}
