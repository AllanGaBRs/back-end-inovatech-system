package com.allan.inovatech.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<TaskKanban> tasks = new ArrayList<TaskKanban>();

    public Adm(){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adm adm = (Adm) o;
        return Objects.equals(id, adm.id) && Objects.equals(name, adm.name) && Objects.equals(email, adm.email) && Objects.equals(password, adm.password) && Objects.equals(changeCodes, adm.changeCodes) && Objects.equals(tasks, adm.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, changeCodes, tasks);
    }

    @Override
    public String toString() {
        return "Adm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password;
    }
}
