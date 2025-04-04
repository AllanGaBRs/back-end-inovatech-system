package com.allan.inovatech.service;

import com.allan.inovatech.dto.profile.StudentProfileDTO;
import com.allan.inovatech.dto.request.get.StudentGetDTO;
import com.allan.inovatech.dto.request.post.StudentPostDTO;
import com.allan.inovatech.dto.request.put.StudentPutDTO;
import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.enums.AccountStatus;
import com.allan.inovatech.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Esse metodo deve ser alterado ou removido, fiz ele apenas para testar a listagem
    public List<StudentGetDTO> findAllStudents(){
        List<Student> list = studentRepository.findAll();
        List<StudentGetDTO> listDTO = new ArrayList<StudentGetDTO>();

        for (Student student : list) {
            listDTO.add(StudentGetDTO.fromEntity(student));
        }

        return listDTO;
    }

    public Student createStudent(StudentPostDTO dto){
        Student student = new Student();
        student.setRa(dto.ra());
        student.setName(dto.name());
        student.setCourse(dto.course());
        student.setEmail(dto.email());
        student.setPassword(dto.password());
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, StudentPutDTO dto){
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Student not found"));
        if(student.getStudentStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Aluno inativo");
        }
        student.setRa(dto.ra());
        student.setName(dto.name());
        student.setCourse(dto.course());
        student.setEmail(dto.email());
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Student not found"));
        if(student.getStudentStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Aluno já está inativo");
        }
        student.setStudentStatus(AccountStatus.INATIVO);
        studentRepository.save(student);
    }

    public void activeStudent(Integer id){
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Student not found"));
        if(student.getStudentStatus() == AccountStatus.ATIVO){
            throw new IllegalStateException("Aluno já está ativo");
        }
        student.setStudentStatus(AccountStatus.ATIVO);
        studentRepository.save(student);
    }

    public StudentProfileDTO findStudentProfileById(Integer id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        if(student.getStudentStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Aluno inativo");
        }
        return StudentProfileDTO.fromEntity(student);
    }

    public void uploadProfilePicture(Integer studentId, MultipartFile file) {
        try {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            if(student.getStudentStatus() == AccountStatus.INATIVO){
                throw new IllegalStateException("Aluno inativo");
            }

            student.setProfilePic(file.getBytes());
            studentRepository.save(student);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar imagem", e);
        }
    }

    public byte[] getProfilePicture(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if(student.getStudentStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Aluno inativo");
        }

        if (student.getProfilePic() == null) {
            throw new RuntimeException("Nenhuma imagem encontrada");
        }

        return student.getProfilePic();
    }
}
