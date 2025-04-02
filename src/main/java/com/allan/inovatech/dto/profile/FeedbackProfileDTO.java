package com.allan.inovatech.dto.profile;

import com.allan.inovatech.model.entities.Feedback;
import java.time.LocalDate;

public record FeedbackProfileDTO(
        Integer id,
        Integer idEntity,
        String message,
        String entityType,
        LocalDate feedbackDate
) {
    public static FeedbackProfileDTO fromEntity(Feedback feedback){
        return new FeedbackProfileDTO(
                feedback.getId(),
                feedback.getIdEntity(),
                feedback.getMessage(),
                feedback.getEntityType().name(),
                feedback.getFeedbackDate()
        );
    }
}
