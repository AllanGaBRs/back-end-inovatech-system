package com.allan.inovatech.dto.profile;

import com.allan.inovatech.model.entities.TaskKanban;
import com.allan.inovatech.model.enums.TaskStatus;

import java.time.LocalDate;

public record TaskProfileDTO(

        Integer id,
        String title,
        String taskDescription,
        TaskStatus sts,
        LocalDate beginDate,
        LocalDate endDate,
        Integer admId,
        String admName

) {
    public static TaskProfileDTO fromEntity(TaskKanban task) {
        return new TaskProfileDTO(
                task.getId(),
                task.getTitle(),
                task.getTaskDescription(),
                task.getSts(),
                task.getBeginDate(),
                task.getEndDate(),
                task.getAdm().getId(),
                task.getAdm().getName()
        );
    }
}
