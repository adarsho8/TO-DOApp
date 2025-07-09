package com.Project.TaskManager.Product;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name="TO-DOO APPLICATION")
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskId;
    @NotBlank(message="TaskName should not be blank")
    @Column(name="TaskName")
    private String name;
    private String Description;
    @Future
    private LocalDate DueDate;
    private boolean TaskStatus;
    @Email
    private String email;
    private String Priority;

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }

    public boolean isTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        TaskStatus = taskStatus;
    }

    public String getPriority() {
        return Priority;
    }


    public void setPriority(String priority) {
        Priority = priority;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }
}
