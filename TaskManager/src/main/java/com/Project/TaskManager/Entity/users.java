package com.Project.TaskManager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @NotNull
    private String username;
    @Email
    private String email;
    @OneToMany(mappedBy ="user",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<TaskDetails> tasks;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public List<TaskDetails> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDetails> tasks) {
        this.tasks = tasks;
    }
}
