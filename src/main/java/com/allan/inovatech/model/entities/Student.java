package com.allan.inovatech.model.entities;

import com.allan.inovatech.model.enums.Course;
import com.allan.inovatech.model.enums.StudentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "studentName", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Course course;

    @Column(length = 20, nullable = false)
    private String password;

    @Column
    private LocalDate registerDate;

    @Enumerated(EnumType.STRING)
    @Column
    private StudentStatus studentStatus = StudentStatus.AT;

    @Column
    private String changeCode;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<TaskKanban> tasks = new ArrayList<TaskKanban>();

    @OneToMany(mappedBy = "student")
    private List<Suggestion> suggestions = new ArrayList<Suggestion>();

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCodes(String changeCode) {
        this.changeCode = changeCode;
    }

    public List<TaskKanban> getTasks() {
        return tasks;
    }

    public void addTasks(TaskKanban task) {
        tasks.add(task);
    }
}
