package com.allan.inovatech.model.entities;

import com.allan.inovatech.model.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_suggestion")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String suggestionTitle;

    @Column(nullable = false)
    private String suggestionDescription;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status = Status.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    public Suggestion(){

    }

    public String getSuggestionDescription() {
        return suggestionDescription;
    }

    public void setSuggestionDescription(String suggestionDescription) {
        this.suggestionDescription = suggestionDescription;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSuggestionTitle() {
        return suggestionTitle;
    }

    public void setSuggestionTitle(String suggestionTitle) {
        this.suggestionTitle = suggestionTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
