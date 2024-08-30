package com.TaskManager.Assessment.Service;

import com.TaskManager.Assessment.Repository.TaskRepo;
import com.TaskManager.Assessment.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepository;

    public Task createTask(Task task, Project project) {
        task.setProject(project);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByProject(Project project) {
        return taskRepository.findByProject(project);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    // Additional methods for updating tasks can be added here
}
