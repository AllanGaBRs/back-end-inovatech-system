package com.allan.inovatech.config;

import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.entities.TaskKanban;
import com.allan.inovatech.model.enums.Course;
import com.allan.inovatech.repository.StudentRepository;
import com.allan.inovatech.repository.TaskKanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TaskKanbanRepository taskKanbanRepository;

    @Override
    public void run(String... args) throws Exception {
        Student st1 = new Student();
        st1.setName("Allan");
        st1.setEmail("allan@gmail.com");
        st1.setCourse(Course.SI);
        st1.setPassword("12345");
        st1.setRegisterDate(LocalDate.now());

        studentRepository.save(st1);

        TaskKanban tk1 = new TaskKanban();
        tk1.setTitle("Fazer o KanBan");
        tk1.setTaskDescription("Cade meu kanban Allan?");
        tk1.setBeginDate(LocalDate.now());
        tk1.setStudent(st1);

        taskKanbanRepository.save(tk1);

        st1.getTasks().add(tk1);
        studentRepository.save(st1);

        Student st2 = new Student();
        st2.setName("Bruno");
        st2.setEmail("bruno@gmail.com");
        st2.setCourse(Course.ADS);
        st2.setPassword("54321");
        st2.setRegisterDate(LocalDate.now());

        studentRepository.save(st2);

        TaskKanban tk2 = new TaskKanban();
        tk2.setTitle("Finalizar relatório");
        tk2.setTaskDescription("Preciso entregar o relatório até sexta.");
        tk2.setBeginDate(LocalDate.now());
        tk2.setStudent(st2);

        taskKanbanRepository.save(tk2);

        TaskKanban tk3 = new TaskKanban();
        tk3.setTitle("Estudar para prova");
        tk3.setTaskDescription("A prova de arquitetura de computadores tá chegando!");
        tk3.setBeginDate(LocalDate.now());
        tk3.setStudent(st2);

        taskKanbanRepository.save(tk3);

        st2.getTasks().add(tk2);
        st2.getTasks().add(tk3);
        studentRepository.save(st2);


    }
}
