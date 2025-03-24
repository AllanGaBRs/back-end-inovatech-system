package com.allan.inovatech.controller;

import com.allan.inovatech.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{id}/upload-profile-pic")
    public ResponseEntity<String> uploadProfilePic(@PathVariable Integer id,
                                                   @RequestParam("file") MultipartFile file) {
        studentService.uploadProfilePicture(id, file);
        return ResponseEntity.ok("Imagem salva com sucesso!");
    }

    @GetMapping("/{id}/profile-pic")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable Integer id) {
        byte[] image = studentService.getProfilePicture(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
