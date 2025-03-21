package com.allan.inovatech.model.entities;

import com.allan.inovatech.model.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_taskskanban")
public class TaskKanban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String taskDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus sts = TaskStatus.AF;

    @Column(nullable = false)
    private LocalDate beginDate;

    @Column
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_adm")
    private Adm adm;

    public TaskKanban(){

    }

    public TaskKanban(Integer id, String title, String taskDescription, TaskStatus sts, LocalDate beginDate, LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.sts = sts;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskStatus getSts() {
        return sts;
    }

    public void setSts(TaskStatus sts) {
        this.sts = sts;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Adm getAdm() {
        return adm;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }


}
