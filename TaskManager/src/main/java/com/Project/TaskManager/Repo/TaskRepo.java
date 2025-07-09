package com.Project.TaskManager.Repo;

import com.Project.TaskManager.Product.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskDetails, Integer> {
    Optional<TaskDetails> findByName(String name);

}

