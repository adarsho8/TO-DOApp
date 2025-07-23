package com.Project.TaskManager.Controller;

import com.Project.TaskManager.Entity.TaskDetails;
import com.Project.TaskManager.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TO-DOAPP")
public class TaskController {
    @Autowired
    private TaskService service;
    @GetMapping
    public List<TaskDetails> getTasks()
    {
        return service.getTasks();
    }
    @PostMapping
    public TaskDetails createTask(@Valid @RequestBody TaskDetails taskdetails)
    {
        return service.createTask(taskdetails);
    }
    @GetMapping("/{name}")
    public Optional<TaskDetails> getTaskByName(@PathVariable String name)
    {
        return service.getTaskByName(name);
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
