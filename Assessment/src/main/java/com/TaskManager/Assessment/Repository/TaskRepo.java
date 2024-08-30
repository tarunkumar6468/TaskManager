package com.TaskManager.Assessment.Repository;

import com.TaskManager.Assessment.models.Project;
import com.TaskManager.Assessment.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
}