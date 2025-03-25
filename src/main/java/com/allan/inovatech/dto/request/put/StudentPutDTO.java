package com.allan.inovatech.dto.request.put;

import com.allan.inovatech.model.enums.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentPutDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotNull(message = "O curso deve ser informado")
        Course course,
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail informado é inválido")
        String email
) {
}
