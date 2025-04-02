package com.allan.inovatech.config;

import com.allan.inovatech.model.entities.*;
import com.allan.inovatech.model.enums.Course;
import com.allan.inovatech.model.enums.EntityType;
import com.allan.inovatech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private TaskKanbanRepository taskKanbanRepository;

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void run(String... args) throws Exception {

        Adm adm1 = new Adm();
        adm1.setName("Leandrao");
        adm1.setEmail("leandro@edu.unipar.br");
        adm1.setPassword("01356");

        admRepository.save(adm1);

        TaskKanban tk1 = new TaskKanban();
        tk1.setTitle("Fazer o KanBan");
        tk1.setTaskDescription("Cade meu kanban Allan?");
        tk1.setBeginDate(LocalDate.now());
        tk1.setAdm(adm1);

        TaskKanban tk2 = new TaskKanban();
        tk2.setTitle("Finalizar relatório");
        tk2.setTaskDescription("Preciso entregar o relatório até sexta.");
        tk2.setBeginDate(LocalDate.now());
        tk2.setAdm(adm1);

        TaskKanban tk3 = new TaskKanban();
        tk3.setTitle("Estudar para prova");
        tk3.setTaskDescription("A prova de arquitetura de computadores tá chegando!");
        tk3.setBeginDate(LocalDate.now());
        tk3.setAdm(adm1);

        Student st1 = new Student();
        st1.setRa("252256-1");
        st1.setName("Allan");
        st1.setEmail("allan@gmail.com");
        st1.setCourse(Course.SI);
        st1.setPassword("12345");
        st1.setRegisterDate(LocalDate.now());

        Student st2 = new Student();
        st2.setRa("568492-1");
        st2.setName("Bruno");
        st2.setEmail("bruno@gmail.com");
        st2.setCourse(Course.ADS);
        st2.setPassword("54321");
        st2.setRegisterDate(LocalDate.now());

        studentRepository.save(st1);
        studentRepository.save(st2);

        tk1.setStudent(st1);
        tk2.setStudent(st2);
        tk3.setStudent(st2);
        st1.getTasks().add(tk1);
        st2.getTasks().add(tk2);
        st2.getTasks().add(tk3);

        studentRepository.save(st2);
        studentRepository.save(st1);

        taskKanbanRepository.save(tk1);
        taskKanbanRepository.save(tk2);
        taskKanbanRepository.save(tk3);

        Student test = studentRepository.findById(2).get();
        test.getTasks().forEach(System.out::println);


        Suggestion sg1 = new Suggestion();
        sg1.setSuggestionTitle("Adciona nao sei");
        sg1.setSuggestionDescription("Faz nao sei oq la");
        sg1.setStudent(st1);

        suggestionRepository.save(sg1);

        Report rp1 = new Report();
        rp1.setStudent(st1);
        rp1.setReportDescription("Fiz isso, aquilo e bruu");
        rp1.setAmountHours(LocalTime.of(1, 50));

        reportRepository.save(rp1);

        Feedback fb1 = new Feedback();
        fb1.setAdm(adm1);
        fb1.setEntityType(EntityType.REPORT);
        fb1.setIdEntity(rp1.getId());
        fb1.setMessage("Que relatorio bosta bixo");

        feedbackRepository.save(fb1);

        adm1.addFeedback(fb1);
    }
}
