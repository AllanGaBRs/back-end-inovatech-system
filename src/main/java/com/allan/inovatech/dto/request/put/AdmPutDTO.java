package com.allan.inovatech.dto.request.put;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record AdmPutDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail informado é inválido")
        String email
) {
}
