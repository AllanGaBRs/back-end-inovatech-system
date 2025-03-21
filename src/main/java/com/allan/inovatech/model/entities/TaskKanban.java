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
    private String title;
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private TaskStatus sts;
    private LocalDate beginDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    
}
