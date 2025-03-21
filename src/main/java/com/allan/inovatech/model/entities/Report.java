package com.allan.inovatech.model.entities;

import com.allan.inovatech.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private Status sts = Status.PENDENTE;

    @Column(nullable = false)
    private String reportDescription;

    @Column
    private LocalDate sendDate = LocalDate.now();

    @Column(nullable = false)
    private LocalTime amountHours;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public Report(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getSts() {
        return sts;
    }

    public void setSts(Status sts) {
        this.sts = sts;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalTime getAmountHours() {
        return amountHours;
    }

    public void setAmountHours(LocalTime amountHours) {
        this.amountHours = amountHours;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }
}
