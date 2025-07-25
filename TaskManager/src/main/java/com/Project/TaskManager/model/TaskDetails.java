package com.Project.TaskManager.model;

import com.Project.TaskManager.enums.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDate;


@Entity
@Table(name="TaskDetails")
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskId;
    @Column(name="TaskName")
    private String name;
    private String Description;
    private LocalDate DueDate;
    private boolean TaskStatus;
    private  Priority Priority;
    @ManyToOne
    @JoinColumn(name="userid")
    private users user;

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public @NotBlank(message = "TaskName should not be blank") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "TaskName should not be blank") String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public @Future LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(@Future LocalDate dueDate) {
        DueDate = dueDate;
    }

    public boolean isTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        TaskStatus = taskStatus;
    }

    public com.Project.TaskManager.enums.Priority getPriority() {
        return Priority;
    }

    public void setPriority(com.Project.TaskManager.enums.Priority priority) {
        Priority = priority;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }
}
