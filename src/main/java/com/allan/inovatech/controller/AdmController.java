package com.allan.inovatech.controller;

import com.allan.inovatech.dto.request.get.AdmGetDTO;
import com.allan.inovatech.dto.request.post.AdmPostDTO;
import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.service.AdmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adms")
public class AdmController {

    @Autowired
    private AdmService admService;

    @PostMapping("/create")
    public ResponseEntity<AdmGetDTO> createAdm(@RequestBody @Valid AdmPostDTO dto){
        Adm adm = admService.createAdm(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(AdmGetDTO.fromEntity(adm));
    }

}
