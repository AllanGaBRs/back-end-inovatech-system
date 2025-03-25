package com.allan.inovatech.dto.request.post;

import com.allan.inovatech.model.entities.Adm;
import jakarta.validation.constraints.NotBlank;

public record TaskPostDTO(

        @NotBlank(message = "Titulo da task não pode estar vazio")
        String title,
        @NotBlank(message = "Descrção da task não pode estar vazio")
        String taskDescription,
        @NotBlank(message = "id do adm não pode estar vazio")
        Integer idAdm
) {
}
