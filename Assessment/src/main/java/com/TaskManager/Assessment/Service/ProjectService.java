package com.TaskManager.Assessment.Service;

import com.TaskManager.Assessment.Repository.ProjectRepository;
import com.TaskManager.Assessment.models.Project;
import com.TaskManager.Assessment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project, User owner) {
        project.setOwner(owner);
        return projectRepository.save(project);
    }

    public List<Project> getProjectsByUser(User user) {
        return projectRepository.findByOwner(user);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
    }

    // Additional methods for updating projects can be added here
}