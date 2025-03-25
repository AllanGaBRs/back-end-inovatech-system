package com.allan.inovatech.controller;

import com.allan.inovatech.dto.profile.StudentProfileDTO;
import com.allan.inovatech.dto.request.post.StudentPostDTO;
import com.allan.inovatech.dto.request.put.StudentPutDTO;
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
    public ResponseEntity<List<StudentProfileDTO>> listAll() {
        List<StudentProfileDTO> listDTO = studentService.findAllStudents();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileDTO> findProfileById(@Valid @PathVariable Integer id) {
        StudentProfileDTO student = studentService.findStudentProfileById(id);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<StudentProfileDTO> updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentPutDTO dto) {
        Student student = studentService.updateStudent(id, dto);
        return ResponseEntity.ok(StudentProfileDTO.fromEntity(student));
    }

    @PutMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/active/{id}")
    public void activeStudent(@PathVariable Integer id) {
        studentService.activeStudent(id);
    }

    @PostMapping
    public ResponseEntity<StudentProfileDTO> createStudent(@RequestBody @Valid StudentPostDTO dto) {
        Student student = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentProfileDTO.fromEntity(student));
    }

    @PostMapping("/{id}/upload-profile-pic")
    public ResponseEntity<String> uploadProfilePic(@PathVariable Integer id,
                                                   @RequestParam("file") MultipartFile file) {
        studentService.uploadProfilePicture(id, file);
        return ResponseEntity.ok("Foto de perfil atualizada com sucesso!");
    }

    @GetMapping("/{id}/profile-pic")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable Integer id) {
        byte[] image = studentService.getProfilePicture(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
