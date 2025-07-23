package com.Project.TaskManager.Service;

import com.Project.TaskManager.Exceptions.BadRequestException;
import com.Project.TaskManager.Exceptions.ResourceNotFoundException;
import com.Project.TaskManager.Entity.TaskDetails;
import com.Project.TaskManager.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;
    public List<TaskDetails> getTasks()
    {
        return repo.findAll();
    }
    public TaskDetails createTask(TaskDetails taskdetails)
    {
        if(taskdetails.getName()==null || taskdetails.getName().isBlank())
        {
            throw new BadRequestException("Taskname should not be empty");
        }
        return repo.save(taskdetails);
    }
    public Optional<TaskDetails> getTaskByName(String name)
    {
        Optional<TaskDetails> task =repo.findByName(name);
        if(task.isEmpty())
        {
            throw new ResourceNotFoundException("TaskDetails Not Found with"+name);
        }
        return repo.findByName(name);
    }
    public TaskDetails UpdateTask(TaskDetails taskdetails)
    {
        return repo.save(taskdetails);
    }
    public String deleteTaskByName(int TaskId) {
        Optional<TaskDetails> tasks=repo.findById(TaskId);
        if(tasks.isPresent()) {
            repo.deleteById(TaskId);
            return "Task deleted sucessfully";
        }
        else {
            throw new ResourceNotFoundException("TaskID doesnot exists");
        }

    }


}
