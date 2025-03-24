package com.allan.inovatech.controller;

import com.allan.inovatech.dto.profile.StudentProfileDTO;
import com.allan.inovatech.dto.request.StudentRequestDTO;
import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentProfileDTO>> listAll(){
        List<StudentProfileDTO> listDTO = studentService.findAllStudents();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileDTO> findProfileById(@Valid @PathVariable Integer id){
        StudentProfileDTO student = studentService.findStudentProfileById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<StudentProfileDTO> createStudent(@RequestBody @Valid StudentRequestDTO dto) {
        Student student = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentProfileDTO.fromEntity(student));
    }

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
