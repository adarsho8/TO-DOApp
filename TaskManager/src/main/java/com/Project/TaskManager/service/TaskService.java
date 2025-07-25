package com.Project.TaskManager.service;

import com.Project.TaskManager.dto.GetTaskDetailsDTO;
import com.Project.TaskManager.exceptions.BadRequestException;
import com.Project.TaskManager.exceptions.ResourceNotFoundException;
import com.Project.TaskManager.model.TaskDetails;
import com.Project.TaskManager.repository.TaskRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public TaskDetails createTask(TaskDetails taskdetails)
    {
        if(taskdetails.getName()==null || taskdetails.getName().isBlank())
        {
            throw new BadRequestException("Taskname should not be empty");
        }
        return repo.save(taskdetails);
    }

    public TaskDetails UpdateTask(TaskDetails taskdetails)
    {
        return repo.save(taskdetails);
    }
    public String deleteTaskByName(int TaskId) {
        return repo.findById(TaskId)
                .map(task->{
                            repo.deleteById(TaskId);
                            return "task deleted sucessfully";}
                ).orElseThrow(()->new ResourceNotFoundException("Taskid not found"));

    }


    public List<GetTaskDetailsDTO> getTaskDetailsDTO() {
        return repo.findAll().stream()
            .map(task -> modelMapper.map(task, GetTaskDetailsDTO.class))
            .collect(Collectors.toList());
}


    public List<GetTaskDetailsDTO> getTaskDetailsDTObyName(String name)
    {
        return getTaskDetailsDTO().stream()
                .filter(task->task.getName()
                        .equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


}
