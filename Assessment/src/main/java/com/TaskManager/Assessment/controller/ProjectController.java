package com.TaskManager.Assessment.controller;

import com.TaskManager.Assessment.Service.ProjectService;
import com.TaskManager.Assessment.models.Project;
import com.TaskManager.Assessment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(projectService.createProject(project, user));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getUserProjects(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(projectService.getProjectsByUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}