package com.allan.inovatech.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_adm")
public class Adm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullName", nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "keypass", nullable = false)
    private String password;

    @Column
    private String changeCodes;

    @OneToMany(mappedBy = "adm")
    private List<TaskKanban> tasks;

    public Adm(){

    }

    public Adm(String password, Integer id, String name, String email) {
        this.password = password;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskKanban> getTasks() {
        return tasks;
    }

    public void addTask(TaskKanban task) {
        tasks.add(task);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChangeCodes() {
        return changeCodes;
    }

    public void setChangeCodes(String changeCodes) {
        this.changeCodes = changeCodes;
    }
}
