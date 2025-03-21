package com.allan.inovatech.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_passwordchangecode")
public class PasswordChangeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String passcode;

    @Column
    private LocalDateTime changeDate;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public PasswordChangeCode(){

    }

    public PasswordChangeCode(String passcode, Integer id, LocalDateTime changeDate, Student student) {
        this.passcode = passcode;
        this.id = id;
        this.changeDate = changeDate;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
