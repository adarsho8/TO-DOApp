package com.Project.TaskManager.controller;

import com.Project.TaskManager.dto.GetTaskDetailsDTO;
import com.Project.TaskManager.model.TaskDetails;
import com.Project.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TO-DOAPP")
public class TaskController {
    @Autowired
    private TaskService service;
    @GetMapping
    public List<GetTaskDetailsDTO> getTasks()
    {
        return service.getTaskDetailsDTO();
    }
    @PostMapping
    public TaskDetails createTask(@Valid @RequestBody TaskDetails taskdetails)
    {
        return service.createTask(taskdetails);
    }
    @GetMapping("/{name}")
    public List<GetTaskDetailsDTO> getTaskByName(@PathVariable String name)
    {
        return service.getTaskDetailsDTObyName(name);
    }
    @PutMapping()
    public TaskDetails UpdateTask(@RequestBody @Valid TaskDetails taskdetails)
    {
        return service.UpdateTask(taskdetails);
    }
    @DeleteMapping("/{TaskId}")
    public String deleteTaskByName(@PathVariable int TaskId) {
        return service.deleteTaskByName(TaskId);
    }

}
