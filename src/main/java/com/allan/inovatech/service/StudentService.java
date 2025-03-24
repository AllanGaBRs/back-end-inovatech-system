package com.allan.inovatech.service;

import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void uploadProfilePicture(Integer studentId, MultipartFile file) {
        try {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            student.setProfilePic(file.getBytes()); 
            studentRepository.save(student);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar imagem", e);
        }
    }

    public byte[] getProfilePicture(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getProfilePic() == null) {
            throw new RuntimeException("Nenhuma imagem encontrada");
        }

        return student.getProfilePic();
    }
}
