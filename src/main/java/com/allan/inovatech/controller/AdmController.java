package com.allan.inovatech.controller;

import com.allan.inovatech.dto.request.get.AdmGetDTO;
import com.allan.inovatech.dto.request.post.AdmPostDTO;
import com.allan.inovatech.dto.request.put.AdmPutDTO;
import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.service.AdmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/edit/{id}")
    public ResponseEntity<AdmGetDTO> updateAdm(@PathVariable Integer id, @RequestBody @Valid AdmPutDTO dto){
        Adm adm = admService.updateAdm(id, dto);
        return ResponseEntity.ok(AdmGetDTO.fromEntity(adm));
    }

    @PutMapping("/delete/{id}")
    public void deleteAdm(@PathVariable Integer id){
        admService.deleteAdm(id);
    }

    @PutMapping("/active/{id}")
    public void activeAdm(@PathVariable Integer id){
        admService.activeAdm(id);
    }

    @PostMapping("/{id}/upload-profile-pic")
    public ResponseEntity<String> uploadProfilePic(@PathVariable Integer id,
                                                   @RequestParam("file") MultipartFile file) {
        admService.uploadProfilePicture(id, file);
        return ResponseEntity.ok("Foto de perfil atualizada com sucesso!");
    }

    @GetMapping("/{id}/profile-pic")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable Integer id) {
        byte[] image = admService.getProfilePicture(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
    }
}
