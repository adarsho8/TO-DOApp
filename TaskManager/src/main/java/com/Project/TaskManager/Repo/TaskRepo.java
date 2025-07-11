package com.Project.TaskManager.Repo;

import com.Project.TaskManager.DTO.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskDetails, Integer> {
    Optional<TaskDetails> findByName(String name);
    @Query("SELECT t FROM TaskDetails t WHERE t.DueDate = :DueDate")
    List<TaskDetails> getDueDate(@Param("DueDate") LocalDate DueDate);

}

