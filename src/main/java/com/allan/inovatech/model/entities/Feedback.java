package com.allan.inovatech.model.entities;

import com.allan.inovatech.model.enums.EntityType;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer idEntity;

    @Column(nullable = false, length = 500)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityType entityType;

    @Column
    private LocalDate feedbackDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "adm_id", nullable = false)
    private Adm adm;

}
