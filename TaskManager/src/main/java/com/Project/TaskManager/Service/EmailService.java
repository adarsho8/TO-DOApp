package com.Project.TaskManager.Service;

import com.Project.TaskManager.DTO.TaskDetails;
import com.Project.TaskManager.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TaskRepo repo;
    //@Scheduled(cron = "0 * * * * *")
    public void sendemail()
    {
        List<TaskDetails> findtaskbyduedate=repo.getDueDate(LocalDate.now());
                for(TaskDetails tasks:findtaskbyduedate){
                    SimpleMailMessage message=new SimpleMailMessage();
                    message.setText("Hello Sir/Mam "+tasks.getName()+" is due complete the task");
                    message.setSubject("Task remainder");
                    message.setTo(tasks.getEmail());
                    mailSender.send(message);



                }


    }

}
