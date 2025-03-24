package com.allan.inovatech.dto.profile;

import com.allan.inovatech.model.entities.Suggestion;
import com.allan.inovatech.model.enums.Status;

public record SuggestionProfileDTO(
        Integer id,
        String title,
        String description,
        Status status
) {
    public static SuggestionProfileDTO fromEntity(Suggestion suggestion) {
        return new SuggestionProfileDTO(
                suggestion.getId(),
                suggestion.getSuggestionTitle(),
                suggestion.getSuggestionDescription(),
                suggestion.getStatus()
        );
    }
}

