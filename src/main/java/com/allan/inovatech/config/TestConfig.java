package com.allan.inovatech.config;

import com.allan.inovatech.model.entities.Student;
import com.allan.inovatech.model.enums.Course;
import com.allan.inovatech.repository.StudentRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Student st = new Student();
        st.setName("Allan");
        st.setEmail("allan@gmail");
        st.setCourse(Course.SI);
        st.setPassword("12345");
        st.setRegisterDate(LocalDate.now());

        studentRepository.save(st);


    }
}
