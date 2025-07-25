package com.Project.TaskManager.dto;



import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
public class GetTaskDetailsDTO {
    @NotBlank(message = "Taskname should not be blanck")
    private String name;
    private String Description;
    @Future
    private LocalDate DueDate;
    private boolean TaskStatus;
    private String Priority;
    private int taskId;

    public @NotBlank(message = "Taskname should not be blanck") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Taskname should not be blanck") String name) {
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

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
